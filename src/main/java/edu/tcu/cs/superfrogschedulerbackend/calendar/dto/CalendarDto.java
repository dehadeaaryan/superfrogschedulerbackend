package edu.tcu.cs.superfrogschedulerbackend.calendar.dto;

import edu.tcu.cs.superfrogschedulerbackend.schedule.Schedule;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.student.dto.StudentDto;
import jakarta.validation.constraints.NotEmpty;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.util.Date;

public record CalendarDto(String id,
                          Schedule schedule,
                          @NotEmpty(message = "student is required.")
                          StudentDto student,
                          @NotEmpty(message = "date is required.")
                          Date date,
                          Time time) {
}
