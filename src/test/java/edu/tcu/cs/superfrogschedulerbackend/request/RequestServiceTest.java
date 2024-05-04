//package edu.tcu.cs.superfrogschedulerbackend.request;
//
//import edu.tcu.cs.superfrogschedulerbackend.system.exception.ObjectNotFoundException;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.catchThrowable;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class RequestServiceTest {
//    @Mock
//    RequestRepository requestRepository;
//    @InjectMocks
//    RequestService requestService;
//
//    List<Request> requests;
//
//    @BeforeEach
//    void setUp() {
//        Request r1 = new Request();
//        r1.setId("123456789");
//        r1.setCustomerFirstName("John");
//        r1.setCustomerLastName("Doe");
//        r1.setPhoneNumber("4694694699");
//        r1.setEventType("Wedding");
//        r1.setEventTitle("Rains of Castamere");
//        r1.setOrganizationName("Not an organization");
//        r1.setEventAddress("2800 S University Dr, Fort Worth, TX 76109");
//        r1.setOnCampus(true);
//        r1.setSpecialInstructions("None");
//        r1.setExpensesAndBenefitsToSpiritTeam("Members get food");
//        r1.setOtherOutsideOrganizations("TCU");
//        r1.setEventDescription("What is a wedding?");
//        r1.setStatus("Pending");
//        r1.setApproved(false);
//        r1.setPaid(false);
//        r1.setAmount(100.00);
//        Request r2 = new Request();
//        r2.setId("123456789");
//        r2.setCustomerFirstName("Lemon");
//        r2.setCustomerLastName("Milk");
//        r2.setPhoneNumber("123");
//        r2.setEventType("No");
//        r2.setEventTitle("WOAH");
//        r2.setOrganizationName("Org");
//        r2.setEventAddress("Why");
//        r2.setOnCampus(false);
//        r2.setSpecialInstructions("Ok");
//        r2.setExpensesAndBenefitsToSpiritTeam("Members get drinks");
//        r2.setOtherOutsideOrganizations("nah");
//        r2.setEventDescription("it is");
//        r2.setStatus("Pending");
//        r2.setApproved(false);
//        r2.setPaid(false);
//        r2.setAmount(5000.00);
//        this.requests = new ArrayList<>();
//        requests.add(r1);
//        requests.add(r2);
//    }
//
//    @AfterEach
//    void tearDown() {
//
//    }
//
//    @Test
//    void testFindByIdSuccess() {
//        // Given
//        Request r = new Request();
//        r.setId("123456789");
//        r.setCustomerFirstName("John");
//        r.setCustomerLastName("Doe");
//        r.setPhoneNumber("4694694699");
//        r.setEventType("Wedding");
//        r.setEventTitle("Rains of Castamere");
//        r.setOrganizationName("Not an organization");
//        r.setEventAddress("2800 S University Dr, Fort Worth, TX 76109");
//        r.setOnCampus(true);
//        r.setSpecialInstructions("None");
//        r.setExpensesAndBenefitsToSpiritTeam("Members get food");
//        r.setOtherOutsideOrganizations("TCU");
//        r.setEventDescription("What is a wedding?");
//        r.setStatus("Pending");
//        r.setApproved(false);
//        r.setPaid(false);
//        r.setAmount(100.00);
//        given(requestRepository.findById("123456789")).willReturn(Optional.of(r));
//
//        // When
//        Request returnedRequest = requestService.findById("123456789");
//
//        // Then
//        assertThat(returnedRequest.getId()).isEqualTo(r.getId());
//        verify(requestRepository, times(1)).findById("123456789");
//    }
//
//    @Test
//    void testFindByIdNotFound() {
//        // Given
//        given(requestRepository.findById(Mockito.anyString())).willReturn(Optional.empty());
//
//        // When
//        Throwable thrown = catchThrowable(() -> {
//            Request returnedRequest = requestService.findById("123456789");
//        });
//
//        // Then
//        assertThat(thrown).isInstanceOf(ObjectNotFoundException.class).hasMessage("Could not find request with Id 123456789");
//        verify(requestRepository, times(1)).findById("123456789");
//    }
//
//    @Test
//    void testFindAllSuccess() {
//        // Given
//        given(this.requestRepository.findAll()).willReturn(this.requests);
//
//        // When
//        List<Request> actualRequests = this.requestService.findAll();
//
//        // Then
//        assertThat(actualRequests.size()).isEqualTo(this.requests.size());
//        verify(this.requestRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testSaveSuccess() {
//        // Given
//        Request newRequest = new Request();
//        newRequest.setCustomerFirstName("John");
//        newRequest.setCustomerLastName("Doe");
//        newRequest.setPhoneNumber("555-1234");
//        newRequest.setEmail("john.doe@example.com");
//        newRequest.setEventType("Birthday Party");
//        newRequest.setEventTitle("John's Birthday");
//        newRequest.setOrganizationName("ABC Events");
//        newRequest.setEventAddress("123 Main St");
//        newRequest.setOnCampus(true);
//        newRequest.setSpecialInstructions("Please bring balloons");
//        newRequest.setExpensesAndBenefitsToSpiritTeam("Covering travel expenses");
//        newRequest.setOtherOutsideOrganizations("None");
//        newRequest.setEventDescription("A birthday celebration for John");
//        newRequest.setStatus("Pending");
//        newRequest.setApproved(false);
//        newRequest.setPaid(false);
//        newRequest.setAmount(0.0);
//
//        given(requestRepository.save(newRequest)).willReturn(newRequest);
//
//        // When
//        Request savedRequest = requestService.save(newRequest);
//
//        // Then
//        assertThat(savedRequest).isNotNull();
//        assertThat(savedRequest.getCustomerFirstName()).isEqualTo(newRequest.getCustomerFirstName());
//        assertThat(savedRequest.getCustomerLastName()).isEqualTo(newRequest.getCustomerLastName());
//        assertThat(savedRequest.getPhoneNumber()).isEqualTo(newRequest.getPhoneNumber());
//        assertThat(savedRequest.getEmail()).isEqualTo(newRequest.getEmail());
//        assertThat(savedRequest.getEventType()).isEqualTo(newRequest.getEventType());
//        assertThat(savedRequest.getEventTitle()).isEqualTo(newRequest.getEventTitle());
//        assertThat(savedRequest.getOrganizationName()).isEqualTo(newRequest.getOrganizationName());
//        assertThat(savedRequest.getEventAddress()).isEqualTo(newRequest.getEventAddress());
//        assertThat(savedRequest.getOnCampus()).isEqualTo(newRequest.getOnCampus());
//        assertThat(savedRequest.getSpecialInstructions()).isEqualTo(newRequest.getSpecialInstructions());
//        assertThat(savedRequest.getExpensesAndBenefitsToSpiritTeam()).isEqualTo(newRequest.getExpensesAndBenefitsToSpiritTeam());
//        assertThat(savedRequest.getOtherOutsideOrganizations()).isEqualTo(newRequest.getOtherOutsideOrganizations());
//        assertThat(savedRequest.getEventDescription()).isEqualTo(newRequest.getEventDescription());
//        assertThat(savedRequest.getStatus()).isEqualTo(newRequest.getStatus());
//        assertThat(savedRequest.getApproved()).isEqualTo(newRequest.getApproved());
//        assertThat(savedRequest.getPaid()).isEqualTo(newRequest.getPaid());
//        assertThat(savedRequest.getAmount()).isEqualTo(newRequest.getAmount());
//        verify(requestRepository, times(1)).save(newRequest);
//    }
//
//    @Test
//    void testModifySuccess() {
//        // Given
//        Request oldRequest = new Request();
//        oldRequest.setId("123456789");
//        oldRequest.setCustomerFirstName("John");
//        oldRequest.setCustomerLastName("Doe");
//        oldRequest.setPhoneNumber("4694694699");
//        oldRequest.setEventType("Wedding");
//        oldRequest.setEventTitle("Rains of Castamere");
//        oldRequest.setOrganizationName("Not an organization");
//        oldRequest.setEventAddress("2800 S University Dr, Fort Worth, TX 76109");
//        oldRequest.setOnCampus(true);
//        oldRequest.setSpecialInstructions("None");
//        oldRequest.setExpensesAndBenefitsToSpiritTeam("Members get food");
//        oldRequest.setOtherOutsideOrganizations("TCU");
//        oldRequest.setEventDescription("What is a wedding?");
//        oldRequest.setStatus("Pending");
//        oldRequest.setApproved(false);
//        oldRequest.setPaid(false);
//        oldRequest.setAmount(100.00);
//
//        Request modify = new Request();
//        modify.setCustomerFirstName("Alice");
//        modify.setCustomerLastName("Smith");
//        modify.setPhoneNumber("555-1234");
//        modify.setEmail("alice.smith@example.com");
//        modify.setEventType("Birthday Party");
//        modify.setEventTitle("Alice's Birthday");
//        modify.setOrganizationName("ABC Events");
//        modify.setEventAddress("123 Main St");
//        modify.setOnCampus(true);
//        modify.setSpecialInstructions("Please bring balloons");
//        modify.setExpensesAndBenefitsToSpiritTeam("Covering travel expenses");
//        modify.setOtherOutsideOrganizations("None");
//        modify.setEventDescription("A birthday celebration for Alice");
//        modify.setStatus("Pending");
//
//        given(requestRepository.findById("123456789")).willReturn(Optional.of(oldRequest));
//        given(requestRepository.save(oldRequest)).willReturn(oldRequest);
//
//        // When
//        Request modifiedRequest = requestService.modify("123456789", modify);
//
//        // Then
//        assertThat(modifiedRequest.getId()).isEqualTo("123456789");
//        assertThat(modifiedRequest.getCustomerFirstName()).isEqualTo("Alice");
//        assertThat(modifiedRequest.getCustomerLastName()).isEqualTo("Smith");
//        assertThat(modifiedRequest.getPhoneNumber()).isEqualTo("555-1234");
//        assertThat(modifiedRequest.getEmail()).isEqualTo("alice.smith@example.com");
//        assertThat(modifiedRequest.getEventType()).isEqualTo("Birthday Party");
//        assertThat(modifiedRequest.getEventTitle()).isEqualTo("Alice's Birthday");
//        assertThat(modifiedRequest.getOrganizationName()).isEqualTo("ABC Events");
//        assertThat(modifiedRequest.getEventAddress()).isEqualTo("123 Main St");
//        assertThat(modifiedRequest.getOnCampus()).isTrue();
//        assertThat(modifiedRequest.getSpecialInstructions()).isEqualTo("Please bring balloons");
//        assertThat(modifiedRequest.getExpensesAndBenefitsToSpiritTeam()).isEqualTo("Covering travel expenses");
//        assertThat(modifiedRequest.getOtherOutsideOrganizations()).isEqualTo("None");
//        assertThat(modifiedRequest.getEventDescription()).isEqualTo("A birthday celebration for Alice");
//        assertThat(modifiedRequest.getStatus()).isEqualTo("Pending");
//        assertThat(modifiedRequest.getApproved()).isFalse();
//        assertThat(modifiedRequest.getPaid()).isFalse();
//        assertThat(modifiedRequest.getAmount()).isEqualTo(100.0);
//        verify(requestRepository, times(1)).findById("123456789");
//        verify(requestRepository, times(1)).save(oldRequest);
//    }
//
//    @Test
//    void testModifyNotFound() {
//        // Given
//        Request modify = new Request();
//        modify.setCustomerFirstName("Alice");
//        modify.setCustomerLastName("Smith");
//        modify.setPhoneNumber("555-1234");
//        modify.setEmail("alice.smith@example.com");
//        modify.setEventType("Birthday Party");
//        modify.setEventTitle("Alice's Birthday");
//        modify.setOrganizationName("ABC Events");
//        modify.setEventAddress("123 Main St");
//        modify.setOnCampus(true);
//        modify.setSpecialInstructions("Please bring balloons");
//        modify.setExpensesAndBenefitsToSpiritTeam("Covering travel expenses");
//        modify.setOtherOutsideOrganizations("None");
//        modify.setEventDescription("A birthday celebration for Alice");
//        modify.setStatus("Pending");
//
//        given(requestRepository.findById("123456789")).willReturn(Optional.empty());
//
//        // When
//        assertThrows(ObjectNotFoundException.class, () -> {
//            requestService.modify("123456789", modify);
//        });
//
//        // Then
//        verify(requestRepository, times(1)).findById("123456789");
//    }
//
//    @Test
//    void testDeleteSuccess() {
//        // Given
//        Request request = new Request();
//        request.setId("123456789");
//        request.setCustomerFirstName("John");
//        request.setCustomerLastName("Doe");
//        request.setPhoneNumber("4694694699");
//        request.setEventType("Wedding");
//        request.setEventTitle("Rains of Castamere");
//        request.setOrganizationName("Not an organization");
//        request.setEventAddress("2800 S University Dr, Fort Worth, TX 76109");
//        request.setOnCampus(true);
//        request.setSpecialInstructions("None");
//        request.setExpensesAndBenefitsToSpiritTeam("Members get food");
//        request.setOtherOutsideOrganizations("TCU");
//        request.setEventDescription("What is a wedding?");
//        request.setStatus("Pending");
//        request.setApproved(false);
//        request.setPaid(false);
//        request.setAmount(100.00);
//
//        given(requestRepository.findById("123456789")).willReturn(Optional.of(request));
//        doNothing().when(requestRepository).deleteById("123456789");
//
//        // When
//        requestService.delete("123456789");
//
//        // Then
//        verify(requestRepository, times(1)).deleteById("123456789");
//    }
//
//    @Test
//    void testDeleteNotFound() {
//        // Given
//        given(requestRepository.findById("123456789")).willReturn(Optional.empty());
//
//        // When
//        assertThrows(ObjectNotFoundException.class, () -> {
//            requestService.delete("123456789");
//        });
//
//        // Then
//        verify(requestRepository, times(1)).findById("123456789");
//    }
//
//}
