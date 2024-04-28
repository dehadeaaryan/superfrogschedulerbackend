package edu.tcu.cs.superfrogschedulerbackend.student.converter;

import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.request.converter.RequestToRequestDtoConverter;
import edu.tcu.cs.superfrogschedulerbackend.request.dto.RequestDto;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.converter.StudentTimeToStudentTimeDtoConverter;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.dto.StudentTimeDto;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.student.dto.StudentDto;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component public class StudentToStudentDtoConverter implements Converter<Student, StudentDto> {
   private final StudentTimeToStudentTimeDtoConverter studentTimeToStudentTimeDtoConverter;
    private final RequestToRequestDtoConverter completedRequestToCompletedRequestDtoConverter;

    public StudentToStudentDtoConverter(@Lazy StudentTimeToStudentTimeDtoConverter studentTimeToStudentTimeDtoConverter, RequestToRequestDtoConverter completedRequestToCompletedRequestDtoConverter) {
        this.studentTimeToStudentTimeDtoConverter = studentTimeToStudentTimeDtoConverter;
        this.completedRequestToCompletedRequestDtoConverter = completedRequestToCompletedRequestDtoConverter;
    }

    @Override
    public StudentDto convert(Student source) {
        List<StudentTimeDto> studentTimeDtos = null;
        List<RequestDto> completedRequestDtos = null;
        if (source.getStudentTimes() != null) {
            studentTimeDtos = source.getStudentTimes().stream()
                    .map(this.studentTimeToStudentTimeDtoConverter::convert)
                    .collect(Collectors.toList());
        }

        if (source.getCompletedRequests() != null) {
            completedRequestDtos = source.getCompletedRequests().stream()
                    .map(this.completedRequestToCompletedRequestDtoConverter::convert)
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
                studentTimeDtos,
                completedRequestDtos
                // This will either be a List<CalendarDto> or null

        );
    }


}
