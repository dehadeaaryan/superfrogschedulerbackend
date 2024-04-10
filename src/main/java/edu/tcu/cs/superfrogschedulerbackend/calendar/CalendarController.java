package edu.tcu.cs.superfrogschedulerbackend.calendar;

import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarController {
    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("/api/v1/requests/{calendarId}")
    public Result findCalendarById(@PathVariable String calendarId) {
        String message = String.format("requests: %s", calendarId);
        return new Result(true, 200, message);
    }
}
