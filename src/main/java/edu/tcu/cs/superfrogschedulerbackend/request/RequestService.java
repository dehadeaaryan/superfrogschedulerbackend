package edu.tcu.cs.superfrogschedulerbackend.request;

import edu.tcu.cs.superfrogschedulerbackend.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Request findById(String requestId) {
        return this.requestRepository.findById(requestId).orElseThrow(() -> new ObjectNotFoundException("request", requestId));
    }
}
