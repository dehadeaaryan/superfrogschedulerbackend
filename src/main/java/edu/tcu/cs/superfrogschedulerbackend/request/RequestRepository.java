package edu.tcu.cs.superfrogschedulerbackend.request;


import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, String>, JpaSpecificationExecutor<Request> {
    //define a query method that will return completed Requests.

    List<Request> findByStatusCompleted(String status);
    List<Request> findByStatusAndStudent(Request status, Student student);
    List<Request> findByRequestNumber(Request id);
}
