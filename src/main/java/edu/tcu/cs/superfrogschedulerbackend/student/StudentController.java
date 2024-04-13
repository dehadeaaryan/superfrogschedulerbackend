package edu.tcu.cs.superfrogschedulerbackend.student;

import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        return new Result(true,200, "Find All Success", foundStudents);

    }

    @GetMapping("/{studentId}")
    public Result findStudentById(@PathVariable String studentId) {
        Student foundStudent = this.studentService.findById(studentId);
        return new Result(true, 200, "Find One Success", foundStudent);
    }

    @PutMapping("/{studentId}")
    public Result updateStudent(@PathVariable String studentId,  @RequestBody Student student) {
        Student updatedStudent =this.studentService.update(student,studentId);
        return new Result(true, 200, "Update Success", updatedStudent);
    }



}
