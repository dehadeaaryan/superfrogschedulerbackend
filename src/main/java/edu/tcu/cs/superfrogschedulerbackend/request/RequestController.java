package edu.tcu.cs.superfrogschedulerbackend.request;

import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint.base-url}/requests")
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/{requestId}")
    public Result findRequestById(@PathVariable String requestId) {
        Request foundRequest = requestService.findById(requestId);
        return new Result(true, StatusCode.SUCCESS, "Find One Success", foundRequest);
    }
}
