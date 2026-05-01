package com.siteshkumar.performance_tracker_app_backend.dto.codeforces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    
    private Integer contestId;
    private String contestName;
    private Integer rank;
    private Integer oldRating;
    private Integer newRating;
    
}
