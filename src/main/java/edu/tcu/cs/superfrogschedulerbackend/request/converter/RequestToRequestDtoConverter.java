package edu.tcu.cs.superfrogschedulerbackend.request.converter;

import edu.tcu.cs.superfrogschedulerbackend.request.Request;
import edu.tcu.cs.superfrogschedulerbackend.request.dto.RequestDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RequestToRequestDtoConverter implements Converter<Request, RequestDto> {
    @Override
    public RequestDto convert(Request source) {
        return new RequestDto(
                source.getId(),
                source.getCustomerFirstName(),
                source.getCustomerLastName(),
                source.getPhoneNumber(),
                source.getEmail(),
                source.getStartTime(),
                source.getDuration(),
                source.getEventType(),
                source.getEventTitle(),
                source.getOrganizationName(),
                source.getEventAddress(),
                source.getOnCampus(),
                source.getSpecialInstructions(),
                source.getExpensesAndBenefitsToSpiritTeam(),
                source.getOtherOutsideOrganizations(),
                source.getEventDescription(),
                source.getStatus(),
                source.getApproved(),
                source.getPaid(),
                source.getAmount()
        );
    }
}
