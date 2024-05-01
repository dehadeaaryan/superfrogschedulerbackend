package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.request.RequestRepository;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentPaymentService {

    private final StudentPaymentRepository studentPaymentRepository;

    private final RequestRepository requestRepository; //getting the SuperFrog appearence requests

    public StudentPaymentService(StudentPaymentRepository studentPaymentRepository, RequestRepository requestRepository) {
        this.studentPaymentRepository = studentPaymentRepository;
        this.requestRepository = requestRepository;
    }

    //retrieving students from Request
    //make an empty map
    //using a for loop, iterate list of requests and put them in according to the students thethered the requests (students as keys)
    //resulting map will be a key-value pair with unique students and a list of their completed requests
    //iterate through the list and calculate price
    //result will be a map with key-value pairs of students and how much to pay them

    //generating student payment forms
    public List<StudentPayment> generateStudentPaymentForms(List<Integer> completedRequestList, Double studentPaymentPeriod) {
        //receiving completed Requests
        List<Request> completedRequests = this.requestRepository.findByStatusCompleted(listOfCompletedRequests);

        Map<Student, List<Request>> studentRequestMap = groupRequestsByStudent(completedRequests);

        // For each Student, generate a student payment form then put them into a list.
        List<StudentPayment> paymentForms = studentRequestsMap.entrySet().stream()
                .map(entry -> entry.getKey().generateStudentPayment(entry.getValue(), studentPaymentPeriod))
                .collect(Collectors.toList());

        // iterate over each element and save them each iteration
        return this.studentPaymentRepository.saveAll(paymentForms);
    }

    private Map<Student, List<Request>> groupRequestsBySuperFrogStudent(List<Request> selectedRequests) {
        Map<Student, List<Request>> studentRequestsMap = selectedRequests.stream()
                .collect(Collectors.groupingBy(Request::getStudent));
        return studentRequestsMap;
    }

}
