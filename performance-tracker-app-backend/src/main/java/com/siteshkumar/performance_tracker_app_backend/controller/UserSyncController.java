package com.siteshkumar.performance_tracker_app_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.siteshkumar.performance_tracker_app_backend.service.UserSyncService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sync")
public class UserSyncController {
    
    private final UserSyncService userSyncService;

    @PostMapping("/{handle}")
    public ResponseEntity<String> syncUser(@PathVariable String handle){
        userSyncService.saveProblems(handle);
        userSyncService.saveContestHistory(handle);

        return ResponseEntity.ok("Data synced successfully !");
    }
}
