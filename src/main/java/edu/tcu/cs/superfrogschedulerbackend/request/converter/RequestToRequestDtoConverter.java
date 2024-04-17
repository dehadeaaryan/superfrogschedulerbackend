package edu.tcu.cs.superfrogschedulerbackend.request.converter;

import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.request.dto.RequestDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestToRequestDtoConverter implements Converter<Request, RequestDto> {
    @Override
    public RequestDto convert(Request source) {
        return new RequestDto(
                source.getId()
        );
    }
}
