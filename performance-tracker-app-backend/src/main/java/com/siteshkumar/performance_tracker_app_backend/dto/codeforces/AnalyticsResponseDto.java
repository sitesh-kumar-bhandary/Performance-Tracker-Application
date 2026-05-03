package com.siteshkumar.performance_tracker_app_backend.dto.codeforces;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsResponseDto {

    private Map<String, TopicStatsDto> topics;

}
