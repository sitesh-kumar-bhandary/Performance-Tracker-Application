package com.siteshkumar.performance_tracker_app_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.siteshkumar.performance_tracker_app_backend.entity.ProblemSolvedEntity;

@Repository
public interface ProblemSolvedRepository extends JpaRepository<ProblemSolvedEntity, Long>{
    
    boolean existsByHandleAndContestIdAndProblemIndex(String handle, Integer contestId, String problemIndex);

}
