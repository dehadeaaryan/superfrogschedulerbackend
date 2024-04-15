package edu.tcu.cs.superfrogschedulerbackend.spiritdirector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpiritDirectorRepository extends JpaRepository<SpiritDirector, Long>{

}
