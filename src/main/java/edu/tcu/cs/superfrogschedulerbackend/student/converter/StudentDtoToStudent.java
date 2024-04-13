package edu.tcu.cs.superfrogschedulerbackend.student.converter;

import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.student.dto.StudentDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoToStudent implements Converter<StudentDto,Student> {
    @Override
    public Student convert(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.id());
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());
        student.setInternational(studentDto.international());
        student.setPhoneNumber(studentDto.phoneNumber());
        student.setAddress(studentDto.address());
        return student;
    }
}
