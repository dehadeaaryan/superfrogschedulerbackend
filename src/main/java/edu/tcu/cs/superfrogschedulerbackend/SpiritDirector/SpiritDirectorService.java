package edu.tcu.cs.superfrogschedulerbackend.spiritdirector;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SpiritDirectorService {
    private final SpiritDirectorRepository spiritDirectorRepository;

        public SpiritDirectorService(SpiritDirectorRepository spiritDirectorRepository){
            this.spiritDirectorRepository = spiritDirectorRepository; 
        }

        public SpiritDirector findById(String spiritDirectorId){
            return null; 
        }
    
}