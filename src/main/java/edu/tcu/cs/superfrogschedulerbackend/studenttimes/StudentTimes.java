package edu.tcu.cs.superfrogschedulerbackend.studenttimes;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

// This is supposed to be the Spirit Calendar, which has open schedules of the students

@Entity
public class StudentTimes implements Serializable {
    @Id
    private String id;
    @ManyToOne
    private Student student;
    private String event_day;
    private Integer time;

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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
