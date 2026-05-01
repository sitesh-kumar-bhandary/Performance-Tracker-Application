package com.siteshkumar.performance_tracker_app_backend.service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import org.springframework.stereotype.Service;
import com.siteshkumar.performance_tracker_app_backend.dto.codeforces.RatingDto;
import com.siteshkumar.performance_tracker_app_backend.dto.codeforces.SubmissionDto;
import com.siteshkumar.performance_tracker_app_backend.dto.codeforces.UserRatingResponseDto;
import com.siteshkumar.performance_tracker_app_backend.dto.codeforces.UserStatusResponseDto;
import com.siteshkumar.performance_tracker_app_backend.entity.ContestHistoryEntity;
import com.siteshkumar.performance_tracker_app_backend.entity.ProblemSolvedEntity;
import com.siteshkumar.performance_tracker_app_backend.exception.ExternalApiException;
import com.siteshkumar.performance_tracker_app_backend.repository.ContestHistoryRepository;
import com.siteshkumar.performance_tracker_app_backend.repository.ProblemSolvedRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSyncService {

    private final CodeforcesService codeforcesService;
    private final ProblemSolvedRepository problemSolvedRepository;
    private final ContestHistoryRepository contestHistoryRepository;

    public void saveProblems(String handle) {

        UserStatusResponseDto response = codeforcesService.getUserStatus(handle);

        if (response == null || !"OK".equals(response.getStatus()))
            throw new ExternalApiException("Failed to fetch submissions from Codeforces");

        List<SubmissionDto> submissions = response.getResult();

        if (submissions == null)
            return;

        for (SubmissionDto sub : submissions) {

            if (!"OK".equals(sub.getVerdict()))
                continue;

            if (problemSolvedRepository.existsByHandleAndContestIdAndProblemIndex(
                    handle, sub.getContestId(), sub.getProblem().getIndex())) {
                continue;
            }

            ProblemSolvedEntity problem = new ProblemSolvedEntity();

            problem.setHandle(handle);
            problem.setContestId(sub.getContestId());
            problem.setProblemIndex(sub.getProblem().getIndex());
            problem.setProblemName(sub.getProblem().getName());
            problem.setRating(sub.getProblem().getRating());
            problem.setTags(sub.getProblem().getTags());

            problem.setSolvedAt(
                    Instant.ofEpochSecond(sub.getCreationTimeSeconds())
                            .atZone(ZoneId.systemDefault())
                            .toLocalDateTime());

            problemSolvedRepository.save(problem);
        }
    }

    public void saveContestHistory(String handle) {

        UserRatingResponseDto userRatings = codeforcesService.getUserRating(handle);

        if (userRatings == null || !"OK".equals(userRatings.getStatus()))
            throw new ExternalApiException("Codeforces API failed while fetching contest history");

        List<RatingDto> ratings = userRatings.getResult();

        if (ratings == null)
            return;

        for (RatingDto r : ratings) {
            if (contestHistoryRepository.existsByHandleAndContestId(handle, r.getContestId()))
                continue;

            ContestHistoryEntity entity = new ContestHistoryEntity();
            entity.setHandle(handle);
            entity.setContestId(r.getContestId());
            entity.setContestName(r.getContestName());
            entity.setContestRank(r.getRank());
            entity.setOldRating(r.getOldRating());
            entity.setNewRating(r.getNewRating());
            entity.setRatingChange(r.getNewRating() - r.getOldRating());

            contestHistoryRepository.save(entity);
        }
    }
}
