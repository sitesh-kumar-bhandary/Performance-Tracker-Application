package com.siteshkumar.performance_tracker_app_backend.dto.codeforces;

import com.siteshkumar.performance_tracker_app_backend.enums.PerformanceLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicStatsDto {

    private Integer solved;
    private PerformanceLevel level;

}