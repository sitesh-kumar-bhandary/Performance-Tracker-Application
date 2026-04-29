package com.siteshkumar.performance_tracker_app_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siteshkumar.performance_tracker_app_backend.dto.codeforces.UserRatingResponseDto;
import com.siteshkumar.performance_tracker_app_backend.dto.codeforces.UserStatusResponseDto;
import com.siteshkumar.performance_tracker_app_backend.service.CodeforcesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/codeforces")
public class CodeforcesController {

    private final CodeforcesService codeforcesService;

    @GetMapping("/status/{handle}")
    public ResponseEntity<UserStatusResponseDto> getUserStatus(@PathVariable String handle){
        UserStatusResponseDto status = codeforcesService.getUserStatus(handle);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/rating/{handle}")
    public ResponseEntity<UserRatingResponseDto> getUserRating(@PathVariable String handle){
        UserRatingResponseDto ratings = codeforcesService.getUserRating(handle);
        return ResponseEntity.ok(ratings);
    }
}
