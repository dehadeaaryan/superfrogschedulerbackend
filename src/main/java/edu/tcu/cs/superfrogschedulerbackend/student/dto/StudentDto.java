package edu.tcu.cs.superfrogschedulerbackend.student.dto;
import edu.tcu.cs.superfrogschedulerbackend.request.dto.RequestDto;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.dto.StudentTimeDto;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record StudentDto(Integer id,
                         @NotEmpty(message = "firstName is required.")
                         String firstName,
                         @NotEmpty(message = "lastName is required.")
                         String lastName,
                         @NotEmpty(message = "email is required.")
                         String email,
                         Boolean international,
                         String phoneNumber,
                         String address,
                         List<StudentTimeDto> calendar,
                         List<RequestDto> completedRequests) {
}
