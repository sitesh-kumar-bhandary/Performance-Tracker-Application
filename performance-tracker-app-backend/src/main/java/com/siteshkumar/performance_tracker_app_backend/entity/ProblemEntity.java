package com.siteshkumar.performance_tracker_app_backend.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import com.siteshkumar.performance_tracker_app_backend.enums.DifficultyStatus;
import com.siteshkumar.performance_tracker_app_backend.enums.PlatformStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "problems")
public class ProblemEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DifficultyStatus difficulty;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlatformStatus platform;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
