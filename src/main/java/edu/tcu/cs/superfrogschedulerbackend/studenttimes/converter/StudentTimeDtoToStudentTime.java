package edu.tcu.cs.superfrogschedulerbackend.studenttimes.converter;

import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.student.StudentRepository;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.StudentTimes;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.dto.StudentTimeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

import static java.util.Locale.forLanguageTag;

@Component
public class StudentTimeDtoToStudentTime implements Converter<StudentTimeDto, StudentTimes> {

    private StudentRepository studentRepository;

    public StudentTimeDtoToStudentTime(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentTimes convert(StudentTimeDto source) {
        StudentTimes studentTimes = new StudentTimes();
        studentTimes.setId(source.id());
        studentTimes.setTime(source.time());
        TemporalAccessor accessor = DateTimeFormatter.ofPattern("EEEE", forLanguageTag("en")).parse(source.day());
        studentTimes.setEvent_day(DayOfWeek.from(accessor));
        Optional<Student> student = studentRepository.findById(source.studentId());
        student.ifPresent(studentTimes::setStudent);
        return studentTimes;
    }

}
