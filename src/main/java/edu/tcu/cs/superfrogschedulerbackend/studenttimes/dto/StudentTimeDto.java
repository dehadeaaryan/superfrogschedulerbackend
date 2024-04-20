package edu.tcu.cs.superfrogschedulerbackend.studenttimes.dto;
import edu.tcu.cs.superfrogschedulerbackend.student.dto.StudentDto;
import jakarta.validation.constraints.NotEmpty;

import java.sql.Time;
import java.util.Date;

public record StudentTimeDto(String id,
                             @NotEmpty(message = "student is required.")
                          StudentDto student,
                             @NotEmpty(message = "date is required.")
                          Date date,
                             Time time) {
}
