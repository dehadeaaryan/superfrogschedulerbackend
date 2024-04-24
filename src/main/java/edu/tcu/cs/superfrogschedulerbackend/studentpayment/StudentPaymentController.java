package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;

@RestController
public class StudentPaymentController {

    private final StudentPaymentService studentPaymentService;

    public StudentPaymentController(StudentPaymentService studentPaymentService) {
        this.studentPaymentService = studentPaymentService;
    }

    @PostMapping("api/v1/studentpayment/{studentPaymentId}")
    public Result generateStudentPaymentForms(@PathVariable String studentPaymentId) {
        Student student = new Student();
        return null;

        //get a list of studentIds using getId() method

        //get the payment period for each student

        //send an all good message if it goes through

    }
}
