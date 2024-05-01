package edu.tcu.cs.superfrogschedulerbackend.system;

import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.request.RequestRepository;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.student.StudentRepository;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.StudentTimes;
import edu.tcu.cs.superfrogschedulerbackend.studenttimes.StudentTimesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DBDataInitializer implements CommandLineRunner {
    private final RequestRepository requestRepository;
    private final StudentRepository studentRepository;
    private final StudentTimesRepository studentTimesRepository;

    public DBDataInitializer(StudentRepository studentRepository, RequestRepository requestRepository, StudentTimesRepository studentTimesRepository) {
        this.requestRepository = requestRepository;
        this.studentRepository = studentRepository;
        this.studentTimesRepository = studentTimesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add Requests
        Request r1 = createRequest(
                "John",
                "Doe",
                "phoneNumber",
                "eventType",
                "eventTitle",
                "organizationName",
                "eventAddress",
                false,
                "specialInstructions",
                "expensesAndBenefitsToSpiritTeam",
                "otherOutsideOrganizations",
                "eventDescription",
                "status",
                true,
                false,
                100.0
        );
        Request r2 = createRequest(
                "Alice",
                "Smith",
                "555-1234",
                "Birthday Party",
                "Alice's Birthday",
                "ABC Events",
                "123 Main St",
                true,
                "Please bring balloons",
                "Covering travel expenses",
                "None",
                "A birthday celebration for Alice",
                "pending",
                false,
                false,
                0.0
        );
        requestRepository.save(r1);
        requestRepository.save(r2);

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

        StudentTimes st1 = new StudentTimes();
        st1.setId("1");
        st1.setEvent_day(DayOfWeek.MONDAY);
        st1.setTime("10:00");

        StudentTimes st2 = new StudentTimes();
        st2.setId("2");
        st2.setEvent_day(DayOfWeek.FRIDAY);
        st2.setTime("11:00");
        // changed this



        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);

        st1.setStudent(s1);
        st2.setStudent(s2);

        studentTimesRepository.save(st1);
        studentTimesRepository.save(st2);




    }

    private Request createRequest(String firstName, String lastName, String phoneNumber, String eventType, String eventTitle, String organizationName, String eventAddress, Boolean onCampus, String specialInstructions, String expensesAndBenefitsToSpiritTeam, String otherOutsideOrganizations, String eventDescription, String status, Boolean approved, Boolean paid, Double amount) {
        Request request = new Request();
        request.setId(UUID.randomUUID().toString());
        request.setCustomerFirstName(firstName);
        request.setCustomerLastName(lastName);
        request.setPhoneNumber(phoneNumber);
        request.setEventType(eventType);
        request.setEventTitle(eventTitle);
        request.setOrganizationName(organizationName);
        request.setEventAddress(eventAddress);
        request.setOnCampus(onCampus);
        request.setSpecialInstructions(specialInstructions);
        request.setExpensesAndBenefitsToSpiritTeam(expensesAndBenefitsToSpiritTeam);
        request.setOtherOutsideOrganizations(otherOutsideOrganizations);
        request.setEventDescription(eventDescription);
        request.setStatus(status);
        request.setApproved(approved);
        request.setPaid(paid);
        request.setAmount(amount);
        return request;
    }
}
