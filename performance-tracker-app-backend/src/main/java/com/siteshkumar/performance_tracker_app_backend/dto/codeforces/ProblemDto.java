package com.siteshkumar.performance_tracker_app_backend.dto.codeforces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDto {

    private String name;
    private int rating;

}
