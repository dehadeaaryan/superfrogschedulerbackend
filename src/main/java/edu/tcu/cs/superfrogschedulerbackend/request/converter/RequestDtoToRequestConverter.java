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
        request.setCustomerFirstName(source.customerFirstName());
        request.setCustomerLastName(source.customerLastName());
        request.setPhoneNumber(source.phoneNumber());
        request.setEmail(source.email());
        request.setStartTime(source.startTime());
        request.setDuration(source.duration());
        request.setEventType(source.eventType());
        request.setEventTitle(source.eventTitle());
        request.setOrganizationName(source.organizationName());
        request.setEventAddress(source.eventAddress());
        request.setOnCampus(source.onCampus());
        request.setSpecialInstructions(source.specialInstructions());
        request.setExpensesAndBenefitsToSpiritTeam(source.expensesAndBenefitsToSpiritTeam());
        request.setOtherOutsideOrganizations(source.otherOutsideOrganizations());
        request.setEventDescription(source.eventDescription());
        request.setStatus(source.status());
        request.setApproved(source.approved());
        request.setPaid(source.paid());
        request.setAmount(source.amount());
        return request;
    }
}
