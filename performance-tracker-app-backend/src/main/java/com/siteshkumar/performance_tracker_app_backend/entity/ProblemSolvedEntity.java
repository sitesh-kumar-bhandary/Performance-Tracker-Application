package com.siteshkumar.performance_tracker_app_backend.entity;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
@Table(name = "problem_solved",
    uniqueConstraints = @UniqueConstraint(columnNames = {"handle", "contestId", "problemIndex"}),
    indexes = {
        @Index(name = "idx_handle", columnList = "handle")
    }
)
public class ProblemSolvedEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String handle;

    @Column(nullable = false)
    private Integer contestId;

    @Column(nullable = false)
    private String problemIndex;

    private String problemName;
    private Integer rating;

    @ElementCollection
    private List<String> tags;

    private LocalDateTime solvedAt;

}
