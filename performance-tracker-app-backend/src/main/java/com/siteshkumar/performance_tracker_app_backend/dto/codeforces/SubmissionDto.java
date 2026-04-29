package com.siteshkumar.performance_tracker_app_backend.dto.codeforces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionDto {
    
    private String verdict;
    private ProblemDto problem;

}
