package edu.tcu.cs.superfrogschedulerbackend.studenttimes.converter;

import edu.tcu.cs.superfrogschedulerbackend.student.converter.StudentToStudentDtoConverter;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.StudentTimes;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.dto.StudentTimeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class StudentTimeToStudentTimeDtoConverter implements Converter<StudentTimes, StudentTimeDto>{
     private final StudentToStudentDtoConverter studentToStudentDtoConverter;

    public StudentTimeToStudentTimeDtoConverter(StudentToStudentDtoConverter studentToStudentDtoConverter) {
        this.studentToStudentDtoConverter = studentToStudentDtoConverter;
    }

    private final SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat timeParser = new SimpleDateFormat("HH:mm:ss");
    @Override
    public StudentTimeDto convert(StudentTimes source) {
        Date eventDate = null;
        Time eventTime = null;

//        try {
//            //Parse Date and Time
//            eventDate = dateParser.parse(source.getEvent_day());
//            java.util.Date parsedTime = timeParser.parse(source.getTime());
//            eventTime = new Time(parsedTime.getTime());
//        } catch (ParseException e) {
//        }

//
//
//        //Convert string to date and time
//
//        StudentTimeDto studentTimeDto = new StudentTimeDto(source.getId(),
//                source.getStudent() != null ? source.getStudent().getId() : null,
//                //Convert string to date
//                eventDate,
//                eventTime   );

        StudentTimeDto studentTimeDto = new StudentTimeDto(source.getId(), source.getStudent() != null ? source.getStudent().getId() : null, source.getEvent_day().toString(), source.getTime());
        return studentTimeDto;
    }
}
