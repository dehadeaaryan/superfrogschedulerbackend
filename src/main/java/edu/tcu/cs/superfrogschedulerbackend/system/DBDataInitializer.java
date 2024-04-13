package edu.tcu.cs.superfrogschedulerbackend.system;

import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DBDataInitializer implements CommandLineRunner {
    private final StudentRepository studentRepository;

    public DBDataInitializer(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setId("1");
        s1.setFirstName("John");
        s1.setLastName("Smith");
        s1.setAddress("123 Main St");
        s1.setEmail("john.smith@gmail.com");

        Student s2 = new Student();
        s2.setId("2");
        s2.setFirstName("Michael");
        s2.setLastName("Nguyen");
        s2.setAddress("456 Main St");
        s2.setEmail("michael.nguyen@gmail.com");

        Student s3 = new Student();
        s3.setId("3");
        s3.setFirstName("Charlie");
        s3.setLastName("Green");
        s3.setAddress("789 Main St");
        s3.setEmail("charlie.green@gmail.com");

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
    }
}
