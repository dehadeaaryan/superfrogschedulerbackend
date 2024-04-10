package edu.tcu.cs.superfrogschedulerbackend.student;

import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/students")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Result findAllStudents(){
        List<Student> foundStudents = this.studentService.findAll();
        return new Result(true,200, foundStudents.toString());

    }

    @GetMapping("/{studentId}")
    public Result findStudentById(@PathVariable String studentId) {
        Student foundStudent = this.studentService.findById(studentId);
        return new Result(true, 200, "Find one success", foundStudent);
    }

}
