package edu.tcu.cs.superfrogschedulerbackend.studenttimes;

import edu.tcu.cs.superfrogschedulerbackend.schedule.Schedule;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

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
    private String day;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
