package edu.tcu.cs.superfrogschedulerbackend.request.converter;

import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.request.dto.RequestDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestDtoToRequestConverter implements Converter<RequestDto, Request> {
    @Override
    public Request convert(RequestDto source) {
        Request request = new Request();
        request.setId(source.requestId());
        return request;
    }
}