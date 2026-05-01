package com.siteshkumar.performance_tracker_app_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.siteshkumar.performance_tracker_app_backend.entity.ContestHistoryEntity;

@Repository
public interface ContestHistoryRepository extends JpaRepository<ContestHistoryEntity, Long>{
    
    boolean existsByHandleAndContestId(String handle, Integer contestId);
    
}
