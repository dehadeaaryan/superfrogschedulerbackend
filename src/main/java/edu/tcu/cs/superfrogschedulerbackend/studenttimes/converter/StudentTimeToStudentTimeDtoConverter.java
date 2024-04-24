package edu.tcu.cs.superfrogschedulerbackend.studenttimes.converter;

import edu.tcu.cs.superfrogschedulerbackend.studenttimes.StudentTimes;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.dto.StudentTimeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentTimeToStudentTimeDtoConverter implements Converter<StudentTimes, StudentTimeDto>{

    @Override
    public StudentTimeDto convert(StudentTimes source) {
        return null;
    }
}
