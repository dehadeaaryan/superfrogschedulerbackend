package edu.tcu.cs.superfrogschedulerbackend.schedule;
import java.io.Serializable;

import edu.tcu.cs.superfrogschedulerbackend.calendar.Calendar;
import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Schedule {
    @Id
    private Integer scheduleId;

    @OneToOne
    private Calendar calendar;

    @OneToOne
    private Request request;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }
}
