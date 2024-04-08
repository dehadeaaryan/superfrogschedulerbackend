package edu.tcu.cs.superfrogschedulerbackend.studentpayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPaymentRepository extends JpaRepository<StudentPayment, String> {
    //this is giving me an error. Saying it cant access Cannot access org.springframework.data.repository.ListCrudRepository

}
