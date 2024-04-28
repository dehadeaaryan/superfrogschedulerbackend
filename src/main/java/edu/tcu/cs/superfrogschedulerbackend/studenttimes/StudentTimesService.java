package edu.tcu.cs.superfrogschedulerbackend.studenttimes;

import edu.tcu.cs.superfrogschedulerbackend.system.exception.ObjectNotFoundException;
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
        return this.studentTimesRepository.findById(calendarId)
                .orElseThrow(() -> new ObjectNotFoundException("student time",calendarId));
    }

    public StudentTimes save(StudentTimes newStudentTimes) {

        return this.studentTimesRepository.save(newStudentTimes);
    }

      public StudentTimes update(String calendarId, StudentTimes studentTimes) {
            return this.studentTimesRepository.findById(calendarId)
                    .map(oldStudentTimes -> {
                        oldStudentTimes.setEvent_day(studentTimes.getEvent_day());
                        oldStudentTimes.setTime(studentTimes.getTime());
                        return studentTimesRepository.save(oldStudentTimes);
                    }).orElseThrow(() -> new ObjectNotFoundException("student time", calendarId));
        }

        public void delete(String calendarId) {
            this.studentTimesRepository.findById(calendarId)
                    .orElseThrow(() -> new ObjectNotFoundException("student time",calendarId));
            this.studentTimesRepository.deleteById(calendarId);
        }

}
