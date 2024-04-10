package edu.tcu.cs.superfrogschedulerbackend.request;

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
        return this.requestRepository.findById(requestId).orElseThrow(() -> new RequestNotFoundException(requestId));
    }
}
