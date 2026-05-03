package com.siteshkumar.performance_tracker_app_backend.utils;

import org.springframework.stereotype.Component;
import com.siteshkumar.performance_tracker_app_backend.enums.PerformanceLevel;

@Component
public class PerformanceUtils {

    private PerformanceUtils(){};
    
    public PerformanceLevel getPerformanceLevel(int solved){
        if(solved < 0)
            solved = 0;

        if(solved < 30)
            return PerformanceLevel.FOUNDATION;

        else if(solved < 55)
            return PerformanceLevel.DEVELOPING;

        else if(solved < 80)
            return PerformanceLevel.PROFICIENT;

        else
            return PerformanceLevel.STRONG;
    }
}
