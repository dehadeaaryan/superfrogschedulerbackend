package edu.tcu.cs.superfrogschedulerbackend.student.converter;

import edu.tcu.cs.superfrogschedulerbackend.calendar.comverter.CalendarToCalendarDtoConverter;
import edu.tcu.cs.superfrogschedulerbackend.calendar.dto.CalendarDto;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.student.dto.StudentDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;

@Component public class StudentToStudentDtoConverter implements Converter<Student, StudentDto> {
   private final CalendarToCalendarDtoConverter calendarToCalendarDtoConverter;

    public StudentToStudentDtoConverter(CalendarToCalendarDtoConverter calendarToCalendarDtoConverter) {
        this.calendarToCalendarDtoConverter = calendarToCalendarDtoConverter;
    }

    @Override
    public StudentDto convert(Student source) {
        List<CalendarDto> calendarDtos = null;
        if (source.getCalendars() != null) {
            calendarDtos = source.getCalendars().stream()
                    .map(calendar -> this.calendarToCalendarDtoConverter.convert(calendar))
                    .collect(Collectors.toList());
        }

        return new StudentDto(
                source.getId(),
                source.getFirstName(),
                source.getLastName(),
                source.getEmail(),
                source.isInternational(),
                source.getPhoneNumber(),
                source.getAddress(),
                calendarDtos  // This will either be a List<CalendarDto> or null
        );
    }


}
