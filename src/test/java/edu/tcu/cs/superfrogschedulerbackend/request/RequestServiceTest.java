package edu.tcu.cs.superfrogschedulerbackend.request;

import edu.tcu.cs.superfrogschedulerbackend.system.exception.ObjectNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RequestServiceTest {
    @Mock
    RequestRepository requestRepository;
    @InjectMocks
    RequestService requestService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void testFindByIdSuccess() {
        // Given
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
        given(requestRepository.findById("123456789")).willReturn(Optional.of(r));

        // When
        Request returnedRequest = requestService.findById("123456789");

        // Then
        assertThat(returnedRequest.getId()).isEqualTo(r.getId());
        verify(requestRepository, times(1)).findById("123456789");
    }

    @Test
    void testFindByIdNotFound() {
        // Given
        given(requestRepository.findById(Mockito.anyString())).willReturn(Optional.empty());

        // When
        Throwable thrown = catchThrowable(() -> {
            Request returnedRequest = requestService.findById("123456789");
        });

        // Then
        assertThat(thrown).isInstanceOf(ObjectNotFoundException.class).hasMessage("Could not find request with id 123456789");
        verify(requestRepository, times(1)).findById("123456789");
    }
}
