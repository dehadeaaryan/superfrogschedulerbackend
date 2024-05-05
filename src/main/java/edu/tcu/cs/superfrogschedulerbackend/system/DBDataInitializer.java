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


        Student s1 = new Student();
        s1.setId(1);
        s1.setFirstName("John");
        s1.setLastName("Smith");
        s1.setAddress("123 Main St");
        s1.setEmail("john.smith@gmail.com");

        Student s2 = new Student();
        s2.setId(2);
        s2.setFirstName("Michael");
        s2.setLastName("Nguyen");
        s2.setAddress("456 Main St");
        s2.setEmail("michael.nguyen@gmail.com");

        Student s3 = new Student();
        s3.setId(3);
        s3.setFirstName("Charlie");
        s3.setLastName("Green");
        s3.setAddress("789 Main St");
        s3.setEmail("charlie.green@gmail.com");

        StudentTimes st1 = createStudentTimes(DayOfWeek.MONDAY, "11:00", s1);
        StudentTimes st2 = createStudentTimes(DayOfWeek.TUESDAY, "6:00", s2);
        //create more random studenttimes object
        StudentTimes st3 = createStudentTimes(DayOfWeek.TUESDAY, "7:00", s3);
        StudentTimes st4 = createStudentTimes(DayOfWeek.THURSDAY, "12:00", s1);
        StudentTimes st5 = createStudentTimes(DayOfWeek.TUESDAY, "16:00", s2);
        StudentTimes st6 = createStudentTimes(DayOfWeek.SATURDAY, "17:00", s3);
        StudentTimes st7 = createStudentTimes(DayOfWeek.SUNDAY, "18:00", s1);
        StudentTimes st8 = createStudentTimes(DayOfWeek.WEDNESDAY, "20:00", s2);
        StudentTimes st9 = createStudentTimes(DayOfWeek.THURSDAY, "13:00", s3);
        StudentTimes st10 = createStudentTimes(DayOfWeek.TUESDAY, "19:00", s1);
        StudentTimes st11 = createStudentTimes(DayOfWeek.MONDAY, "14:00", s2);
        StudentTimes st12 = createStudentTimes(DayOfWeek.FRIDAY, "16:00", s3);
        StudentTimes st13 = createStudentTimes(DayOfWeek.WEDNESDAY, "11:00", s1);
        StudentTimes st14 = createStudentTimes(DayOfWeek.THURSDAY, "9:00", s2);
        StudentTimes st15 = createStudentTimes(DayOfWeek.TUESDAY, "13:00", s3);





        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);

        st1.setStudent(s1);
        st2.setStudent(s2);
        st3.setStudent(s3);
        st4.setStudent(s1);
        st5.setStudent(s2);
        st6.setStudent(s3);
        st7.setStudent(s1);
        st8.setStudent(s2);
        st9.setStudent(s3);
        st10.setStudent(s1);
        st11.setStudent(s2);
        st12.setStudent(s3);
        st13.setStudent(s1);
        st14.setStudent(s2);
        st15.setStudent(s3);


        r1.setAssignedStudent(s1);
        r2.setAssignedStudent(s1);

        studentTimesRepository.save(st1);
        studentTimesRepository.save(st2);
        studentTimesRepository.save(st3);
        studentTimesRepository.save(st4);
        studentTimesRepository.save(st5);
        studentTimesRepository.save(st6);
        studentTimesRepository.save(st7);
        studentTimesRepository.save(st8);
        studentTimesRepository.save(st9);
        studentTimesRepository.save(st10);
        studentTimesRepository.save(st11);
        studentTimesRepository.save(st12);
        studentTimesRepository.save(st13);
        studentTimesRepository.save(st14);
        studentTimesRepository.save(st15);



        requestRepository.save(r1);
        requestRepository.save(r2);



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

    private StudentTimes createStudentTimes(DayOfWeek event_day, String time, Student student) {
        StudentTimes studentTimes = new StudentTimes();
        studentTimes.setId(UUID.randomUUID().toString());
        studentTimes.setEvent_day(event_day);
        studentTimes.setTime(time);
        studentTimes.setStudent(student);
        return studentTimes;
    }
}
