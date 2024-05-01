package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class StudentPaymentController {

    private final StudentPaymentService studentPaymentService;

    //injecting service via constructor
    public StudentPaymentController(StudentPaymentService studentPaymentService) {
        this.studentPaymentService = studentPaymentService;
    }


    @PostMapping("api/v1/studentpaymentforms")
    public Result generateStudentPaymentForms(@RequestBody String requestId) {
        //get a list of studentIds using getId() method
        List<Integer> studentIds = student.getId();

        //get the payment period for each student
        Date studentPaymentPeriod = request.getStartTime; //should this and the Request one be changed to Period?

        //generate the payment forms (calculate final costs)
        List<StudentPayment> paymentForms = this.studentPaymentService.generateStudentPaymentForms(studentIds, studentPaymentPeriod); //we need to decide on a type: Date or Period?

        return new Result(true, HttpStatusCode.SUCCESS, "Student payment forms generated successfully."); //create StatusCode package

    }
}
