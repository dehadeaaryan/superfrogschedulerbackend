package edu.tcu.cs.superfrogschedulerbackend.studenttimes.dto;
import edu.tcu.cs.superfrogschedulerbackend.student.dto.StudentDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Date;

public record StudentTimeDto(String id,
                             @NotEmpty(message = "student is required.")
                          Integer studentId,
                             @NotNull(message = "date is required.")
                             String day,
                             String time) {
}
