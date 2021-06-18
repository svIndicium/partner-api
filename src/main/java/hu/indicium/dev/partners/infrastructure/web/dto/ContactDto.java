package hu.indicium.dev.partners.infrastructure.web.dto;

import hu.indicium.dev.partners.domain.model.contact.Contact;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ContactDto {
    private UUID contactId;

    private ContactDetailsDto details;

    private UUID partnerId;

    public ContactDto(Contact contact) {
        this.contactId = contact.getContactId().getId();
        this.details = new ContactDetailsDto(contact.getDetails());
        this.partnerId = contact.getPartner().getPartnerId().getId();
    }
}
