package hu.indicium.dev.partners.infrastructure.web.dto;

import hu.indicium.dev.partners.domain.model.contact.ContactDetails;
import hu.indicium.dev.partners.domain.model.contact.Name;

public class ContactDetailsDto {
    private NameDto name;

    private String phoneNumber;

    private String mailAddress;

    public ContactDetailsDto(ContactDetails contactDetails) {
        this.name = new NameDto(contactDetails.getName());
        this.phoneNumber = contactDetails.getPhoneNumber();
        this.mailAddress = contactDetails.getMailAddress();
    }
}
