package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.request.RequestRepository;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentPaymentService {

    private final StudentPaymentRepository studentPaymentRepository;
    private final RequestRepository requestRepository; //getting the SuperFrog appearence requests


    public StudentPaymentService(StudentPaymentRepository studentPaymentRepository, RequestRepository requestRepository) {
        this.studentPaymentRepository = studentPaymentRepository;
        this.requestRepository = requestRepository;
    }

    /**
     * Group the given requests by SuperFrogStudent who has finished this request.
     * The result is a Map<SuperFrogStudent, List<SuperFrogAppearanceRequest>>.
     * For example:
     *  John -> request 5, request 6, request 12
     *  Tim -> request 1
     *  Carl -> request 22
     *  completedRequests is a list of completed requests
     *  it will return A map that connects the student to their requests
     */

    //grouping students with their completed requests
    public Map<Student, List<Request>> groupStudentsWithCompletedRequests(List<Request> completedRequests) {
        List<Request> completedRequestList = this.requestRepository.findByStatusCompleted("Completed"); //list of completed Requests

        //make an empty Hash map. What will eventually be returned
        Map<Student, List<Request>> studentMapWithCompletedRequests = new HashMap<>();

        //using a for loop, iterate list of requests
        for (Request request : completedRequestList) {
            Student student = request.getAssignedStudent();
            //if the key(student) already exists, append the request that's attached to that student
            if (student != null) {
                studentMapWithCompletedRequests.computeIfAbsent(student, k -> new ArrayList<>()).add(request);
            }
        }
        //resulting map will be a unique key-value pair with students and a list of their completed requests
        return studentMapWithCompletedRequests;
    }

    //generate payment forms
    public List<StudentPayment> generateStudentPaymentForm(List<Request> appearanceRequestList, Double studentPaymentPeriod){ //of type Period or Double or Date?
        List<Request> listOfCompletedRequests = this.requestRepository.findByStatusCompleted("Completed");

        // Group completed requests by student
        Map<Student, List<Request>> studentRequestsMap = groupStudentsWithCompletedRequests(listOfCompletedRequests);

        // Create payment forms for each student and collect them into a list
        List<StudentPayment> paymentForms = new ArrayList<>();
        for (Map.Entry<Student, List<Request>> entry : studentRequestsMap.entrySet()) {
            Student student = entry.getKey(); // Get the student
            List<Request> requests = entry.getValue(); // Get the list of completed requests

            // Call the payment calculation method for the student and their completed requests
            // and create a payment form
            //////////////////////////////////////////////////////////
            //UNCOMMENT WHEN DONE:
            // StudentPayment paymentForm = student.calculatePayment(requests, studentPaymentPeriod);
            // Add the payment form to the list
            //paymentForms.add(paymentForm);

        }
        return this.studentPaymentRepository.saveAll(paymentForms); //save them all
    }
}
