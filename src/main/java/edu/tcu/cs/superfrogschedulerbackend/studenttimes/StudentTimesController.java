package edu.tcu.cs.superfrogschedulerbackend.studenttimes;

import edu.tcu.cs.superfrogschedulerbackend.student.converter.StudentToStudentDtoConverter;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.converter.StudentTimeDtoToStudentTime;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.converter.StudentTimeToStudentTimeDtoConverter;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.dto.StudentTimeDto;
import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.endpoint.base-url}/studenttimes")
public class StudentTimesController {
    private final StudentTimesService studentTimesService;
    private final StudentTimeToStudentTimeDtoConverter studentTimeToStudentTimeDtoConverter;
    private final StudentTimeDtoToStudentTime studentTimeDtoToStudentTime;
    public StudentTimesController(StudentTimesService studentTimesService, StudentToStudentDtoConverter studentToStudentDtoConverter, StudentTimeToStudentTimeDtoConverter studentTimeToStudentTimeDtoConverter, StudentTimeDtoToStudentTime studentTimeDtoToStudentTime) {
        this.studentTimesService = studentTimesService;
        this.studentTimeToStudentTimeDtoConverter = studentTimeToStudentTimeDtoConverter;
        this.studentTimeDtoToStudentTime = studentTimeDtoToStudentTime;
    }

    @GetMapping("/{studentTimeId}")
    public Result findStudentTimeById(@PathVariable String studentTimeId) {
        StudentTimes foundStudentTime = this.studentTimesService.findById(studentTimeId);
        StudentTimeDto studentTimeDto = this.studentTimeToStudentTimeDtoConverter.convert(foundStudentTime);
        return new Result(true, StatusCode.SUCCESS,"Find One Success", studentTimeDto);
    }

    @PostMapping
    public Result addStudentTime(@Valid @RequestBody StudentTimeDto studentTimeDto) {
        StudentTimes newStudentTime = this.studentTimeDtoToStudentTime.convert(studentTimeDto);
        StudentTimes savedStudentTime = this.studentTimesService.save(newStudentTime);
        StudentTimeDto savedStudentTimeDto = this.studentTimeToStudentTimeDtoConverter.convert(savedStudentTime);
        return new Result(true, StatusCode.SUCCESS,"Add Success", savedStudentTimeDto);
    }

    @PutMapping("/{studentTimeId}")
    public Result updateStudentTime(@PathVariable String studentTimeId, @Valid @RequestBody StudentTimeDto studentTimeDto) {
        StudentTimes update = this.studentTimeDtoToStudentTime.convert(studentTimeDto);
        StudentTimes updatedStudentTime = this.studentTimesService.update(studentTimeId, update);
        StudentTimeDto updatedStudentTimeDto = this.studentTimeToStudentTimeDtoConverter.convert(updatedStudentTime);
        return new Result(true, StatusCode.SUCCESS,"Update Success", updatedStudentTimeDto);
    }

    @DeleteMapping("/{studentTimeId}")
    public Result deleteStudentTime(@PathVariable String studentTimeId) {
        this.studentTimesService.delete(studentTimeId);
        return new Result(true, StatusCode.SUCCESS,"Delete Success");
    }
}
