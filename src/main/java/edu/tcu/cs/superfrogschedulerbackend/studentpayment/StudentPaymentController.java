package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentPaymentController {

    private final StudentPaymentService studentPaymentService;

    public StudentPaymentController(StudentPaymentService studentPaymentService) {
        this.studentPaymentService = studentPaymentService;
    }

    @GetMapping("api/v1/studentPayment/{studentPaymentId}")
    public Result findStudentPaymentById(@PathVariable String studentPaymentId){
       return null;

    }
}
