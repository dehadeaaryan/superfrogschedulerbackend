package edu.tcu.cs.superfrogschedulerbackend.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tcu.cs.superfrogschedulerbackend.request.dto.RequestDto;
import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
import edu.tcu.cs.superfrogschedulerbackend.system.exception.ObjectNotFoundException;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class RequestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RequestService requestService;

    @Autowired
    ObjectMapper objectMapper;

    List<Request> requests;

    @BeforeEach
    void setUp() {
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
        given(this.requestService.findById("123456789")).willReturn(this.requests.get(0));

        // When and Then
        this.mockMvc.perform(get("/api/v1/requests/123456789").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.flag").value(true))
                .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS))
                .andExpect(jsonPath("$.message").value("Find One Success"))
                .andExpect(jsonPath("$.data.id").value("123456789"))
                .andExpect(jsonPath("$.data.customerFirstName").value("John"))
                .andExpect(jsonPath("$.data.customerLastName").value("Doe"))
                .andExpect(jsonPath("$.data.phoneNumber").value("4694694699"))
                .andExpect(jsonPath("$.data.email").value("someEmail"))
//                .andExpect(jsonPath("$.data.startTime").value(this.requests.getFirst().getStartTime().toString()))
                .andExpect(jsonPath("$.data.duration").value(1.5))
                .andExpect(jsonPath("$.data.eventType").value("Wedding"))
                .andExpect(jsonPath("$.data.eventTitle").value("Rains of Castamere"))
                .andExpect(jsonPath("$.data.organizationName").value("Not an organization"))
                .andExpect(jsonPath("$.data.eventAddress").value("2800 S University Dr, Fort Worth, TX 76109"))
                .andExpect(jsonPath("$.data.onCampus").value(true))
                .andExpect(jsonPath("$.data.specialInstructions").value("None"))
                .andExpect(jsonPath("$.data.expensesAndBenefitsToSpiritTeam").value("Members get food"))
                .andExpect(jsonPath("$.data.otherOutsideOrganizations").value("TCU"))
                .andExpect(jsonPath("$.data.eventDescription").value("What is a wedding?"))
                .andExpect(jsonPath("$.data.status").value("Pending"))
                .andExpect(jsonPath("$.data.approved").value(false))
                .andExpect(jsonPath("$.data.paid").value(false))
                .andExpect(jsonPath("$.data.amount").value(100.00));
    }

    @Test
    void testFindRequestByIdNotFound() throws Exception {
        // Given
        given(this.requestService.findById("123456789")).willThrow(new ObjectNotFoundException("request", "123456789"));

        // When and Then
        this.mockMvc.perform(get("/api/v1/requests/123456789").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.flag").value(false))
                .andExpect(jsonPath("$.code").value(StatusCode.NOT_FOUND))
                .andExpect(jsonPath("$.message").value("Could not find request with Id 123456789"))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    @Test
    void testFindAllRequestsSuccess() throws Exception {
        // Given
        List<Request> requests = this.requests;
        given(this.requestService.findAll()).willReturn(requests);

        // When and Then
        this.mockMvc.perform(get("/api/v1/requests").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.flag").value(true))
                .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS))
                .andExpect(jsonPath("$.message").value("Find All Success"))
                .andExpect(jsonPath("$.data", Matchers.hasSize(requests.size())))
                .andExpect(jsonPath("$.data[0].id").value("123456789"))
                .andExpect(jsonPath("$.data[0].customerFirstName").value("John"))
                .andExpect(jsonPath("$.data[0].customerLastName").value("Doe"))
                .andReturn();
    }

    @Test
    void testCreateRequestSuccess() throws Exception {
        // Given
        Date startTime = new Date(0);
        RequestDto requestDto = new RequestDto("123",
                "John",
                "Doe",
                "4694694699",
                "someEmail",
                startTime,
                1.5,
                "Wedding",
                "Rains of Castamere",
                "Not an organization",
                "2800 S University Dr, Fort Worth, TX 76109",
                true,
                "None",
                "Members get food",
                "TCU",
                "What is a wedding?",
                "Pending",
                false,
                false,
                100.0);

        String json = this.objectMapper.writeValueAsString(requestDto);

        Request savedRequest = new Request();
        savedRequest.setId(requestDto.id());
        savedRequest.setCustomerFirstName("John");
        savedRequest.setCustomerLastName("Doe");
        savedRequest.setPhoneNumber("4694694699");
        savedRequest.setEmail("someEmail");
        savedRequest.setStartTime(startTime);
        savedRequest.setDuration(1.5);
        savedRequest.setEventType("Wedding");
        savedRequest.setEventTitle("Rains of Castamere");
        savedRequest.setOrganizationName("Not an organization");
        savedRequest.setEventAddress("2800 S University Dr, Fort Worth, TX 76109");
        savedRequest.setOnCampus(true);
        savedRequest.setSpecialInstructions("None");
        savedRequest.setExpensesAndBenefitsToSpiritTeam("Members get food");
        savedRequest.setOtherOutsideOrganizations("TCU");
        savedRequest.setEventDescription("What is a wedding?");
        savedRequest.setStatus("Pending");
        savedRequest.setApproved(false);
        savedRequest.setPaid(false);
        savedRequest.setAmount(100.0);

        given(this.requestService.save(Mockito.any(Request.class))).willReturn(savedRequest);

        // When and Then
        this.mockMvc.perform(post("/api/v1/requests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.flag").value(true))
                .andExpect(jsonPath("$.code").value(StatusCode.SUCCESS))
                .andExpect(jsonPath("$.message").value("Create Success"))
                .andExpect(jsonPath("$.data.id").isNotEmpty())
                .andExpect(jsonPath("$.data.customerFirstName").value(savedRequest.getCustomerFirstName()))
                .andExpect(jsonPath("$.data.customerLastName").value(savedRequest.getCustomerLastName()))
                .andExpect(jsonPath("$.data.phoneNumber").value(savedRequest.getPhoneNumber()))
                .andExpect(jsonPath("$.data.email").value(savedRequest.getEmail()))
//                .andExpect(jsonPath("$.data.startTime").value(savedRequest.getStartTime())) // Assuming time as milliseconds
                .andExpect(jsonPath("$.data.duration").value(savedRequest.getDuration()))
                .andExpect(jsonPath("$.data.eventType").value(savedRequest.getEventType()))
                .andExpect(jsonPath("$.data.eventTitle").value(savedRequest.getEventTitle()))
                .andExpect(jsonPath("$.data.organizationName").value(savedRequest.getOrganizationName()))
                .andExpect(jsonPath("$.data.eventAddress").value(savedRequest.getEventAddress()))
                .andExpect(jsonPath("$.data.onCampus").value(savedRequest.getOnCampus()))
                .andExpect(jsonPath("$.data.specialInstructions").value(savedRequest.getSpecialInstructions()))
                .andExpect(jsonPath("$.data.expensesAndBenefitsToSpiritTeam").value(savedRequest.getExpensesAndBenefitsToSpiritTeam()))
                .andExpect(jsonPath("$.data.otherOutsideOrganizations").value(savedRequest.getOtherOutsideOrganizations()))
                .andExpect(jsonPath("$.data.eventDescription").value(savedRequest.getEventDescription()))
                .andExpect(jsonPath("$.data.status").value(savedRequest.getStatus()))
                .andExpect(jsonPath("$.data.approved").value(savedRequest.getApproved()))
                .andExpect(jsonPath("$.data.paid").value(savedRequest.getPaid()))
                .andExpect(jsonPath("$.data.amount").value(savedRequest.getAmount()));
    }


}