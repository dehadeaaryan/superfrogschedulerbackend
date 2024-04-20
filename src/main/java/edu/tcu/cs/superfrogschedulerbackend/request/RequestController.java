package edu.tcu.cs.superfrogschedulerbackend.request;

import edu.tcu.cs.superfrogschedulerbackend.request.converter.RequestDtoToRequestConverter;
import edu.tcu.cs.superfrogschedulerbackend.request.converter.RequestToRequestDtoConverter;
import edu.tcu.cs.superfrogschedulerbackend.request.dto.RequestDto;
import edu.tcu.cs.superfrogschedulerbackend.student.Student;
import edu.tcu.cs.superfrogschedulerbackend.system.Result;
import edu.tcu.cs.superfrogschedulerbackend.system.StatusCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
        Request foundRequest = this.requestService.findById(requestId);
        return new Result(true, StatusCode.SUCCESS, "Find One Success", foundRequest);
    }

//    @GetMapping
//    public Result findAllRequests(Pageable pageable) {
//        Page<Request> requestPage = this.requestService.findAll(pageable);
//        Page<RequestDto> requestDtoPage = requestPage
//                .map(this.requestToRequestDtoConverter::convert);
//        return new Result(true, StatusCode.SUCCESS, "Find All Success", requestDtoPage);
//    }
    @GetMapping
    public Result findAllRequests() {
        List<Request> foundRequests = this.requestService.findAll();
        return new Result(true,200, "Find All Success", foundRequests);
    }

    @PostMapping
    public Result createRequest(@RequestBody RequestDto requestDto) {
        Request newRequest = this.requestDtoToRequestConverter.convert(requestDto);
        assert newRequest != null;
        newRequest.setId(UUID.randomUUID().toString());
        Request savedRequest = this.requestService.save(newRequest);
        RequestDto savedRequestDto = this.requestToRequestDtoConverter.convert(savedRequest);
        return new Result(true, StatusCode.SUCCESS, "Create Success", savedRequestDto);
    }

    @PutMapping("/{requestId}")
    public Result modifyRequest(@PathVariable String requestId, @RequestBody RequestDto requestDto) {
        Request modify = this.requestDtoToRequestConverter.convert(requestDto);
        Request modifiedRequest = this.requestService.modify(requestId, modify);
        RequestDto modifiedRequestDto = this.requestToRequestDtoConverter.convert(modifiedRequest);
        return new Result(true, StatusCode.SUCCESS, "Update Success", modifiedRequestDto);
    }

    @DeleteMapping("/{requestId}")
    public Result deleteArtifact(@PathVariable String requestId) {
        this.requestService.delete(requestId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
}
