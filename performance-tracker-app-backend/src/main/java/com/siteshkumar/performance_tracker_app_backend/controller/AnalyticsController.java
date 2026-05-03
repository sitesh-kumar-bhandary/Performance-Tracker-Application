package com.siteshkumar.performance_tracker_app_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.siteshkumar.performance_tracker_app_backend.dto.codeforces.AnalyticsResponseDto;
import com.siteshkumar.performance_tracker_app_backend.service.AnalyticsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;
    
    @GetMapping
    public ResponseEntity<AnalyticsResponseDto> getAnalytics(@RequestParam String handle){
        AnalyticsResponseDto analytics = analyticsService.getAnalytics(handle);
        return ResponseEntity.ok(analytics);
    }
}
