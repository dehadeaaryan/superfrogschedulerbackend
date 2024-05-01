package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


public interface StudentPaymentRepository extends JpaRepository<StudentPayment,Integer> {
}
