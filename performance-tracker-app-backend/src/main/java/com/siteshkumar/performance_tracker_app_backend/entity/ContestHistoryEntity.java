package com.siteshkumar.performance_tracker_app_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "contest_history",
    uniqueConstraints = @UniqueConstraint(columnNames = {"handle", "contestId"}),
    indexes = {
        @Index(name = "idx_handle", columnList = "handle")
    }
)
public class ContestHistoryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String handle;

    @Column(nullable = false)
    private Integer contestId;

    private String contestName;
    private Integer contestRank;
    private Integer oldRating;
    private Integer newRating;
    private Integer ratingChange;

}
