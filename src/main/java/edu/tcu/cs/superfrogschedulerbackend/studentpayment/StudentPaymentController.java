package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
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
    private Student student;
    private Request request;

    //injecting service via constructor
    public StudentPaymentController(StudentPaymentService studentPaymentService) {
        this.studentPaymentService = studentPaymentService;
    }


    @PostMapping("api/v1/studentpaymentforms")
    public Result generateStudentPaymentForms(@RequestBody String requestId) {
        //is this supposed to return just one ID or a list of them?
        Integer studentIds = student.getId();

        //get the payment period for a student
        Double studentPaymentPeriod = request.getDuration(); //this is the time elapsed for the event

        //generate a payment forms
        List<StudentPayment> paymentForms = this.studentPaymentService.generateStudentPaymentForms(studentIds, studentPaymentPeriod); //continue working on this method.

        return new Result(true, StatusCode.SUCCESS, "Student payment forms generated successfully."); //create StatusCode package

    }
}
