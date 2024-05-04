package edu.tcu.cs.superfrogschedulerbackend.studentpayment;

import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.request.RequestRepository;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class StudentPaymentServiceTest {

    @Mock
    RequestRepository requestRepository;
    Request request;

    @InjectMocks //Injecting mocks into studentPaymentService object
    //class under test
    StudentPaymentService studentPaymentService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void groupStudentsWithCompletedRequests() {
        //Given - preparing fake data and defining data of mock. Arrange inputs and targets. Define behaviour of Mock obj studentPaymentRepository

        //creating a student to take the request
        Student s1 = new Student();
        s1.setId("1");
        s1.setFirstName("John");
        s1.setLastName("Smith");
        s1.setAddress("123 Main St");
        s1.setEmail("john.smith@gmail.com");
        //this.students.add(s1);

        //creating a new Request object
        //this.request = new ArrayList<>();
        List<Request> requestList = new ArrayList<>();
        Request r = new Request();
        requestList.add(r);
        r.setId("123456789");
        r.setCustomerFirstName("John");
        r.setCustomerLastName("Doe");
        r.setPhoneNumber("4694694699");
        r.setEmail("someEmail");
        r.setStartTime(new Date(0));
        r.setDuration(1.5);
        r.setEventType("Wedding");
        r.setEventTitle("Rains of Castamere");
        r.setOrganizationName("Not an organization");
        r.setEventAddress("2800 S University Dr, Fort Worth, TX 76109");
        r.setOnCampus(true);
        r.setSpecialInstructions("None");
        r.setExpensesAndBenefitsToSpiritTeam("Members get food");
        r.setOtherOutsideOrganizations("TCU");
        r.setEventDescription("What is a wedding?");
        r.setStatus("Completed");
        r.setApproved(false);
        r.setPaid(false);
        r.setAmount(100.00);
        r.setAssignedStudent(s1);
//        this.requests.add(r);

        given(requestRepository.findByStatusCompleted("Completed").willReturn(r));
        given(requestRepository.findBySuperFrogStudent("1").willReturn(s1));

        //When - Act on the target behavior. When steps should cover the method to be tested
        studentPaymentService.groupStudentsWithCompletedRequests(requestList);
        //Then - Assert expected outcomes.
        //assertThat(studentMapWithCompletedRequests.getId()).isEqualTo(s1.getId()); this doesn't seem to be the same syntax for this project
        //since we are returning a map
    }

    @Test
    void generateStudentPaymentForm() {
        //Given



        //When

        //Then
    }
}