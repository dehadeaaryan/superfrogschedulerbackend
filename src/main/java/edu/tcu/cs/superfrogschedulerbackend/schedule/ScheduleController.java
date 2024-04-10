package edu.tcu.cs.superfrogschedulerbackend.schedule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.tcu.cs.superfrogschedulerbackend.system.Result;

@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/api/v1/requests/{scheduleId}")
    public Result findScheduleById(@PathVariable String scheduleId) {
        String message = String.format("requests: %s", scheduleId);
        return new Result(true, 200, message);
    }
}
