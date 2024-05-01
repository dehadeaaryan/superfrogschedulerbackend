package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.request.RequestRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

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
}
