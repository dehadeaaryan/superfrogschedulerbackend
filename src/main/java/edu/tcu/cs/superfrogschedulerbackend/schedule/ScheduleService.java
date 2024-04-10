package edu.tcu.cs.superfrogschedulerbackend.schedule;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

        public ScheduleService(ScheduleRepository scheduleRepository){
            this.scheduleRepository = scheduleRepository; 
        }

        public Schedule findById(String scheduleId){
            return null; 
        }
    
}