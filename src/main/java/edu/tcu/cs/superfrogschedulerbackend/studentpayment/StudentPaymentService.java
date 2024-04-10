package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentPaymentService {

    private final StudentPaymentRepository studentPaymentRepository;

    public StudentPaymentService(StudentPaymentRepository studentPaymentRepository) {
        this.studentPaymentRepository = studentPaymentRepository;
    }

    public StudentPayment findById(String studentPaymentId){
        return null;
    }
}
