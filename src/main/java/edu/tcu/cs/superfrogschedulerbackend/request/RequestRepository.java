package edu.tcu.cs.superfrogschedulerbackend.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, String>, JpaSpecificationExecutor<Request> {
}
