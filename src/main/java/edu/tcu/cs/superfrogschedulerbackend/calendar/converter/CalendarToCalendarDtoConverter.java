package edu.tcu.cs.superfrogschedulerbackend.calendar.converter;

import edu.tcu.cs.superfrogschedulerbackend.calendar.Calendar;
import edu.tcu.cs.superfrogschedulerbackend.calendar.dto.CalendarDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CalendarToCalendarDtoConverter implements Converter<Calendar, CalendarDto>{

    @Override
    public CalendarDto convert(Calendar source) {
        return null;
    }
}
