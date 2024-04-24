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
        return this.requestRepository.findById(requestId)
                .orElseThrow(() -> new ObjectNotFoundException("request", requestId));
    }

//    public Page<Request> findAll(Pageable pageable) {
//        return this.requestRepository.findAll(pageable);
//    }

    public List<Request> findAll() {
        return this.requestRepository.findAll();
    }

    public Request save(Request newRequest) {
        return this.requestRepository.save(newRequest);
    }

    public Request modify(String requestId, Request modify) {
        return this.requestRepository.findById(requestId)
                .map(oldRequest -> {
                    oldRequest.setCustomerFirstName(modify.getCustomerFirstName());
                    oldRequest.setCustomerLastName(modify.getCustomerLastName());
                    oldRequest.setPhoneNumber(modify.getPhoneNumber());
                    oldRequest.setEmail(modify.getEmail());
                    oldRequest.setStartTime(modify.getStartTime());
                    oldRequest.setDuration(modify.getDuration());
                    oldRequest.setEventType(modify.getEventType());
                    oldRequest.setEventTitle(modify.getEventTitle());
                    oldRequest.setOrganizationName(modify.getOrganizationName());
                    oldRequest.setEventAddress(modify.getEventAddress());
                    oldRequest.setOnCampus(modify.getOnCampus());
                    oldRequest.setSpecialInstructions(modify.getSpecialInstructions());
                    oldRequest.setExpensesAndBenefitsToSpiritTeam(modify.getExpensesAndBenefitsToSpiritTeam());
                    oldRequest.setOtherOutsideOrganizations(modify.getOtherOutsideOrganizations());
                    oldRequest.setEventDescription(modify.getEventDescription());
                    oldRequest.setStatus(modify.getStatus());
                    return this.requestRepository.save(oldRequest);
                }).orElseThrow(() -> new ObjectNotFoundException("request", requestId));
    }

    public void delete(String requestId) {
        this.requestRepository.findById(requestId)
                .orElseThrow(() -> new ObjectNotFoundException("artifact", requestId));
        this.requestRepository.deleteById(requestId);
    }
}
