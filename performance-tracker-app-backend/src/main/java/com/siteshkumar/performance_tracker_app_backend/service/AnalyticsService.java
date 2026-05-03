package com.siteshkumar.performance_tracker_app_backend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.siteshkumar.performance_tracker_app_backend.dto.codeforces.AnalyticsResponseDto;
import com.siteshkumar.performance_tracker_app_backend.dto.codeforces.TopicStatsDto;
import com.siteshkumar.performance_tracker_app_backend.entity.ProblemSolvedEntity;
import com.siteshkumar.performance_tracker_app_backend.enums.PerformanceLevel;
import com.siteshkumar.performance_tracker_app_backend.repository.ProblemSolvedRepository;
import com.siteshkumar.performance_tracker_app_backend.utils.PerformanceUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final ProblemSolvedRepository problemSolvedRepository;
    private final PerformanceUtils performanceUtils;
    
    public AnalyticsResponseDto getAnalytics(String handle){

        List<ProblemSolvedEntity> problems = problemSolvedRepository.findByHandle(handle);

        Map<String, TopicStatsDto> topics = generateAnalytics(problems);
        List<String> weakTopics = findWeakTopics(topics);
        List<String> strongTopics = findStrongTopics(topics);

        AnalyticsResponseDto response = new AnalyticsResponseDto();
        response.setTopics(topics);
        response.setWeakTopics(weakTopics);
        response.setStrongTopics(strongTopics);

        return response;
    }

    private Map<String, TopicStatsDto> generateAnalytics(List<ProblemSolvedEntity> problems){
        Map<String, Integer> countMap = new HashMap<>();

        for(ProblemSolvedEntity ps : problems){
            if(ps.getTags() == null)
                continue;

            for(String tag : ps.getTags()){
                countMap.put(tag, countMap.getOrDefault(tag, 0)+1);
            }
        }

        Map<String, TopicStatsDto> result = new HashMap<>();
        for(Map.Entry<String, Integer> entry : countMap.entrySet()){
            String tag = entry.getKey();
            int solved = entry.getValue();

            PerformanceLevel level = performanceUtils.getPerformanceLevel(solved);

            TopicStatsDto dto = new TopicStatsDto();
            dto.setSolved(solved);
            dto.setLevel(level);
        
            result.put(tag, dto);
        }

        return result;
    }

    private List<String> findWeakTopics(Map<String, TopicStatsDto> topics){
        List<String> result = new ArrayList<>();

        for(Map.Entry<String, TopicStatsDto> entry : topics.entrySet()){
            PerformanceLevel level = entry.getValue().getLevel();

            if(level == PerformanceLevel.FOUNDATION || level == PerformanceLevel.DEVELOPING)
                result.add(entry.getKey());
        }

        return result;
    }

    private List<String> findStrongTopics(Map<String, TopicStatsDto> topics){
        List<String> result = new ArrayList<>();

        for(Map.Entry<String, TopicStatsDto> entry : topics.entrySet()){
            PerformanceLevel level = entry.getValue().getLevel();

            if(level == PerformanceLevel.PROFICIENT || level == PerformanceLevel.STRONG)
                result.add(entry.getKey());
        }

        return result;
    }

}
