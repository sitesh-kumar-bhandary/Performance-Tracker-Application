package com.siteshkumar.performance_tracker_app_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.siteshkumar.performance_tracker_app_backend.dto.codeforces.UserRatingResponseDto;
import com.siteshkumar.performance_tracker_app_backend.dto.codeforces.UserStatusResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeforcesService {

    private final RestTemplate restTemplate;
    
    public UserStatusResponseDto getUserStatus(String handle){
        String url = "https://codeforces.com/api/user.status?handle=" + handle;
        return restTemplate.getForObject(url, UserStatusResponseDto.class);
    }

    public UserRatingResponseDto getUserRating(String handle){
        String url = "https://codeforces.com/api/user.rating?handle=" + handle;
        return restTemplate.getForObject(url, UserRatingResponseDto.class);
    }
}
