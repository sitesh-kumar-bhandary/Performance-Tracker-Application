package com.siteshkumar.performance_tracker_app_backend.dto.codeforces;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRatingResponseDto {

    private String status;
    private List<RatingDto> result;
    
}
