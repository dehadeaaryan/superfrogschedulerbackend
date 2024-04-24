package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.request.RequestRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
//@Transactional  i dont think this is needed.
public class StudentPaymentService {

    private final StudentPaymentRepository studentPaymentRepository;

    private final RequestRepository requestRepository; //getting the SuperFrog appearence request

    public StudentPaymentService(StudentPaymentRepository studentPaymentRepository, RequestRepository requestRepository) {
        this.studentPaymentRepository = studentPaymentRepository;
        this.requestRepository = requestRepository;
    }

    //create a list of appearances and a list of payment forms
}
