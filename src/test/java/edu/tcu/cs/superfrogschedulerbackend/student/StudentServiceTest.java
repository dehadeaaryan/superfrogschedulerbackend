package edu.tcu.cs.superfrogschedulerbackend.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;
    List<Student> students;

    @BeforeEach
    public void setUp() {
        this.students = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1);
        s1.setFirstName("John");
        s1.setLastName("Smith");
        s1.setAddress("123 Main St");
        s1.setEmail("john.smith@gmail.com");
        this.students.add(s1);

        Student s2 = new Student();
        s2.setId(2);
        s2.setFirstName("Michael");
        s2.setLastName("Nguyen");
        s2.setAddress("456 Main St");
        s2.setEmail("michael.nguyen@gmail.com");
        this.students.add(s2);

        Student s3 = new Student();
        s3.setId(3);
        s3.setFirstName("Charlie");
        s3.setLastName("Green");
        s3.setAddress("789 Main St");
        s3.setEmail("charlie.green@gmail.com");
        this.students.add(s3);
    }

    @AfterEach
    void tearDown(){}

    @Test
    void testFindAllSuccess(){
        given(studentRepository.findAll()).willReturn(students);
        List<Student> actualStudents = studentService.findAll();

        assertThat(actualStudents.size()).isEqualTo(students.size());
        verify(studentRepository,times(1)).findAll();
    }

    @Test
    void testFindByIdSuccess() throws Exception {
        Student s1 = new Student();
        s1.setId(1);
        s1.setFirstName("John");
        s1.setLastName("Smith");
        s1.setAddress("123 Main St");
        s1.setEmail("john.smith@gmail.com");

        given(studentRepository.findById("1")).willReturn(Optional.of(s1));

        Student returnStudent = studentService.findById("1");

        assertThat(returnStudent.getId()).isEqualTo(s1.getId());
        assertThat(returnStudent.getFirstName()).isEqualTo("John");
        assertThat(returnStudent.getLastName()).isEqualTo("Smith");
        assertThat(returnStudent.getAddress()).isEqualTo("123 Main St");
        assertThat(returnStudent.getEmail()).isEqualTo("john.smith@gmail.com");

        verify(studentRepository,times(1)).findById("1");

    }
}
