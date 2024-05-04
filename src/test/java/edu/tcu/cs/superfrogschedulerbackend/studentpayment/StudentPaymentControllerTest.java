package edu.tcu.cs.superfrogschedulerbackend.studentpayment;

import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.given;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class StudentPaymentControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    StudentPaymentService studentPaymentService;


    List<StudentPayment> studentPayments;
    List<Request> requests;

    @BeforeEach
    void setUp() {
        this.studentPayments = new ArrayList<>();

        StudentPayment stuPay1 = new StudentPayment();
        stuPay1.setStudentPaymentFormId(1);
        stuPay1.setStudentFirstName("Jim");
        stuPay1.setStudentLastName("Crass");
        stuPay1.setAmount(100);
        stuPay1.setStudentPaymentPeriod(new Date(0));

        this.requests = new ArrayList<>();
        Request r = new Request();
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
        this.requests.add(r);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGenerateStudentPaymentFormsSuccess() {
        //given
        given(this.studentPaymentService.generateStudentPaymentForm(requests, 1.5)).willReturn(this.studentPayments); //not sure what will be gotten since there's no payment calculation
;        //when and then
        // api end point may not have been written well because there is no pass param
        this.mockMvc.perform(get("/api/v1/studentpaymentform/").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.flag").value(true))
                .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS))
                .andExpect(jsonPath("$.message").value("Student payment forms generated successfully."));

    }
}