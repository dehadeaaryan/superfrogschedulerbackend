package edu.tcu.cs.superfrogschedulerbackend.calendar;

import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

// This is supposed to be the Spirit Calendar, which has open schedules of the students

@Entity
public class Calendar implements Serializable {
    @Id
    private String id;
    @ManyToOne
    private Student student;
    private Date date;
    private Time time;

    public Calendar() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
