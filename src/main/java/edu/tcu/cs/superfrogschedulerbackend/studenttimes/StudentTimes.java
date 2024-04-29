package edu.tcu.cs.superfrogschedulerbackend.studenttimes;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Date;

// This is supposed to be the Spirit Calendar, which has open schedules of the students

@Entity
public class StudentTimes implements Serializable {
    @Id
    private String id;
    @ManyToOne
    private Student student;
    private DayOfWeek event_day;   //Please follow format "yyyy-MM-dd" -fix = as monday, tuesday, ...
    private String time;

    public StudentTimes() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DayOfWeek getEvent_day() {
        return event_day;
    }

    public void setEvent_day(DayOfWeek event_day) {
        this.event_day = event_day;
    }
}
