//package edu.tcu.cs.superfrogschedulerbackend.student;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class StudentControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    StudentService studentService;
//    @Autowired
//    ObjectMapper objectMapper;
//    List<Student> students;
//
//    @BeforeEach
//    void setUp() {
//            this.students = new ArrayList<>();
//            Student s1 = new Student();
//            s1.setId(1);
//            s1.setFirstName("John");
//            s1.setLastName("Smith");
//            s1.setAddress("123 Main St");
//            s1.setEmail("john.smith@gmail.com");
//            this.students.add(s1);
//
//            Student s2 = new Student();
//            s2.setId(2);
//            s2.setFirstName("Michael");
//            s2.setLastName("Nguyen");
//            s2.setAddress("456 Main St");
//            s2.setEmail("michael.nguyen@gmail.com");
//            this.students.add(s2);
//
//            Student s3 = new Student();
//            s3.setId(3);
//            s3.setFirstName("Charlie");
//            s3.setLastName("Green");
//            s3.setAddress("789 Main St");
//            s3.setEmail("charlie.green@gmail.com");
//            this.students.add(s3);
//    }
//
//    @AfterEach
//    void tearDown(){
//
//    }
//
//    @Test
//    void testFindAllStudentsSuccess() throws Exception {
//        given(this.studentService.findAll()).willReturn(this.students);
//
//        this.mockMvc.perform(get("/api/v1/students").accept(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.flag").value(true))
//                .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS))
//                .andExpect(jsonPath("$.message").value("Find All Success"))
//                .andExpect(jsonPath("$.data[0].id").value("1"))
//                .andExpect(jsonPath("$.data[0].firstName").value("John"))
//                .andExpect(jsonPath("$.data[0].lastName").value("Smith"))
//                .andExpect(jsonPath("$.data[1].id").value("2"))
//                .andExpect(jsonPath("$.data[1].firstName").value("Michael"))
//                .andExpect(jsonPath("$.data[1].lastName").value("Nguyen"));
//    }
//
//    @Test
//    void testFindStudentByIdSuccess() throws Exception {
//        given(this.studentService.findById("1")).willReturn(this.students.get(0));
//
//        this.mockMvc.perform(get("/api/v1/students/1").accept(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.flag").value(true))
//                .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS))
//                .andExpect(jsonPath("$.message").value("Find One Success"))
//                .andExpect(jsonPath("$.data.id").value("1"))
//                .andExpect(jsonPath("$.data.firstName").value("John"))
//                .andExpect(jsonPath("$.data.lastName").value("Smith"))
//                .andExpect(jsonPath("$.data.email").value("john.smith@gmail.com"));
//    }
//
//}
