package edu.tcu.cs.superfrogschedulerbackend.studenttimes;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentTimesService {
    private final StudentTimesRepository studentTimesRepository;

    public StudentTimesService(StudentTimesRepository studentTimesRepository) {
        this.studentTimesRepository = studentTimesRepository;
    }

    public StudentTimes findById(String calendarId) {
        return null;
    }
}
