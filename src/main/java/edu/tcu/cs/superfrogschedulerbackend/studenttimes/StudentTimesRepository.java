package edu.tcu.cs.superfrogschedulerbackend.studenttimes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTimesRepository extends JpaRepository<StudentTimes, String> {
}
