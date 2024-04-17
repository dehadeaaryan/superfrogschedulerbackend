package edu.tcu.cs.superfrogschedulerbackend.request;

import edu.tcu.cs.superfrogschedulerbackend.request.converter.RequestDtoToRequestConverter;
import edu.tcu.cs.superfrogschedulerbackend.request.converter.RequestToRequestDtoConverter;
import edu.tcu.cs.superfrogschedulerbackend.request.dto.RequestDto;
import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.endpoint.base-url}/requests")
public class RequestController {
    private final RequestService requestService;
    private final RequestDtoToRequestConverter requestDtoToRequestConverter;
    private final RequestToRequestDtoConverter requestToRequestDtoConverter;

    public RequestController(RequestService requestService, RequestToRequestDtoConverter requestToRequestDtoConverter, RequestDtoToRequestConverter requestDtoToRequestConverter) {
        this.requestService = requestService;
        this.requestToRequestDtoConverter = requestToRequestDtoConverter;
        this.requestDtoToRequestConverter = requestDtoToRequestConverter;
    }

    @GetMapping("/{requestId}")
    public Result findRequestById(@PathVariable String requestId) {
        Request foundRequest = requestService.findById(requestId);
        return new Result(true, StatusCode.SUCCESS, "Find One Success", foundRequest);
    }

    @GetMapping
    public Result findAllRequests(Pageable pageable) {
        Page<Request> requestPage = this.requestService.findAll(pageable);
        Page<RequestDto> requestDtoPage = requestPage
                .map(this.requestToRequestDtoConverter::convert);
        return new Result(true, StatusCode.SUCCESS, "Find All Success", requestDtoPage);
    }
}
