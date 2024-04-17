package edu.tcu.cs.superfrogschedulerbackend.request;

import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
import edu.tcu.cs.superfrogschedulerbackend.system.exception.ObjectNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class RequestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RequestService requestService;

    List<Request> requests;

    @BeforeEach
    void setUp() {
        this.requests = new ArrayList<>();
        Request r = new Request();
        r.setId("123456789");
        r.setCustomerFirstName("John");
        r.setCustomerLastName("Doe");
        r.setPhoneNumber("4694694699");
        r.setEventType("Wedding");
        r.setEventTitle("Rains of Castamere");
        r.setOrganizationName("Not an organization");
        r.setEventAddress("2800 S University Dr, Fort Worth, TX 76109");
        r.setOnCampus(true);
        r.setSpecialInstructions("None");
        r.setExpensesAndBenefitsToSpiritTeam("Members get food");
        r.setOtherOutsideOrganizations("TCU");
        r.setEventDescription("What is a wedding?");
        r.setStatus("Pending");
        r.setApproved(false);
        r.setPaid(false);
        r.setAmount(100.00);
        this.requests.add(r);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFindRequestByIdSuccess() throws Exception {
        // Given
        given(this.requestService.findById("123456789")).willReturn(this.requests.getFirst());

        // When and Then
        this.mockMvc.perform(get("/api/v1/requests/123456789").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.flag").value(true))
                .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS))
                .andExpect(jsonPath("$.message").value("Find One Success"))
                .andExpect(jsonPath("$.data.id").value("123456789"));
    }

    @Test
    void testFindRequestByIdNotFound() throws Exception {
        // Given
        given(this.requestService.findById("123456789")).willThrow(new ObjectNotFoundException("request", "123456789"));

        // When and Then
        this.mockMvc.perform(get("/api/v1/requests/123456789").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.flag").value(false))
                .andExpect(jsonPath("$.code").value(StatusCode.NOT_FOUND))
                .andExpect(jsonPath("$.message").value("Could not find request with id 123456789"))
                .andExpect(jsonPath("$.data").isEmpty());
    }
}