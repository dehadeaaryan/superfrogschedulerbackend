package edu.tcu.cs.superfrogschedulerbackend.student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(String studentId) {
        return this.studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
    }


}
