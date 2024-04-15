package edu.tcu.cs.superfrogschedulerbackend.student.dto;
import edu.tcu.cs.superfrogschedulerbackend.calendar.dto.CalendarDto;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record StudentDto(String id,
                         @NotEmpty(message = "firstName is required.")
                         String firstName,
                         @NotEmpty(message = "lastName is required.")
                         String lastName,
                         @NotEmpty(message = "email is required.")
                         String email,
                         Boolean international,
                         String phoneNumber,
                         String address,
                         List<CalendarDto> calendar) {
}
