package edu.tcu.cs.superfrogschedulerbackend.studenttimes.converter;

import edu.tcu.cs.superfrogschedulerbackend.studenttimes.StudentTimes;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.dto.StudentTimeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentTimeDtoToStudentTime implements Converter<StudentTimeDto, StudentTimes> {

    @Override
    public StudentTimes convert(StudentTimeDto source) {
        StudentTimes studentTimes = new StudentTimes();
        studentTimes.setId(source.id());
        studentTimes.setTime(source.time().toString());
        studentTimes.setEvent_day(source.date().toString());
        return studentTimes;
    }

}
