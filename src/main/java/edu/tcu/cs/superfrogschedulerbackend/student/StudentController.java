package edu.tcu.cs.superfrogschedulerbackend.student;

import edu.tcu.cs.superfrogschedulerbackend.student.converter.StudentDtoToStudent;
import edu.tcu.cs.superfrogschedulerbackend.student.converter.StudentToStudentDtoConverter;
import edu.tcu.cs.superfrogschedulerbackend.student.dto.StudentDto;
import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/students")
@RestController
public class StudentController {
    private final StudentService studentService;
    private final StudentToStudentDtoConverter studentToStudentDtoConverter;
    private final StudentDtoToStudent studentDtoToStudent;

    public StudentController(StudentService studentService, StudentToStudentDtoConverter studentToStudentDtoConverter, StudentDtoToStudent studentDtoToStudent) {
        this.studentService = studentService;
        this.studentToStudentDtoConverter = studentToStudentDtoConverter;
        this.studentDtoToStudent = studentDtoToStudent;
    }

    @GetMapping
    public Result findAllStudents(){
        List<Student> foundStudents = this.studentService.findAll();
        List<StudentDto> studentDtos = foundStudents.stream().map(this.studentToStudentDtoConverter::convert)
                .toList();
        return new Result(true,200, "Find All Success", studentDtos);

    }

    @GetMapping("/{studentId}")
    public Result findStudentById(@PathVariable String studentId) {
        Student foundStudent = this.studentService.findById(studentId);
        StudentDto studentDto = this.studentToStudentDtoConverter.convert(foundStudent);
        return new Result(true, StatusCode.SUCCESS, "Find One Success", studentDto);
    }

    @PutMapping("/{studentId}")
    public Result updateStudent(@PathVariable String studentId,  @RequestBody StudentDto studentDto) {
        Student update = this.studentDtoToStudent.convert(studentDto);
        Student updatedStudent = this.studentService.update(studentId, update);
        StudentDto updatedStudentDto = this.studentToStudentDtoConverter.convert(updatedStudent);
        return new Result(true, 200, "Update Success", updatedStudentDto);
    }

    @DeleteMapping
    public Result deleteStudent(@PathVariable String studentId) {
        this.studentService.delete(studentId);
        return new Result(true, 200, "Delete Success");
    }

    @PostMapping
    public Result addStudent(@Valid @RequestBody StudentDto studentDto) {
        Student newStudent = this.studentDtoToStudent.convert(studentDto);
        Student savedStudent = this.studentService.save(newStudent);
        StudentDto savedStudentDto = this.studentToStudentDtoConverter.convert(savedStudent);
        return new Result(true, 200, "Add Success", savedStudentDto);
    }
}
