package edu.tcu.cs.superfrogschedulerbackend.studenttimes;

import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint.base-url}/studenttimes")
public class StudentTimesController {
    private final StudentTimesService studentTimesService;

    public StudentTimesController(StudentTimesService studentTimesService) {
        this.studentTimesService = studentTimesService;
    }

    @GetMapping("/{studentTimeId}")
    public Result findCalendarById(@PathVariable String studentTimeId) {
        String message = String.format("requests: %s", studentTimeId);
        return new Result(true, 200, message);
    }
}
