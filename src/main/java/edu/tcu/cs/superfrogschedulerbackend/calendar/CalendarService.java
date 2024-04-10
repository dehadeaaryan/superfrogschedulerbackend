package edu.tcu.cs.superfrogschedulerbackend.calendar;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CalendarService {
    private final CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Calendar findById(String calendarId) {
        return null;
    }
}
