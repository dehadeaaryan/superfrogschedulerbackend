package edu.tcu.cs.superfrogschedulerbackend.request;

import edu.tcu.cs.superfrogschedulerbackend.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Page<Request> findAll(Pageable pageable) {
        return this.requestRepository.findAll(pageable);
    }
}
