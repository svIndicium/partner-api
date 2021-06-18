package hu.indicium.dev.partners.infrastructure.web.controllers;

import hu.indicium.dev.partners.application.query.ContactQueryService;
import hu.indicium.dev.partners.domain.model.contact.Contact;
import hu.indicium.dev.partners.domain.model.contact.ContactId;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;
import hu.indicium.dev.partners.infrastructure.web.dto.ContactDto;
import hu.indicium.dev.partners.util.Response;
import hu.indicium.dev.partners.util.ResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import static hu.indicium.dev.partners.util.BaseUrl.API_V1;

@RestController
@AllArgsConstructor
@RequestMapping(API_V1)
public class ContactController {

    private final ContactQueryService contactQueryService;

    @GetMapping("/contacts")
    @ResponseStatus(HttpStatus.OK)
    public Response<Collection<ContactDto>> getAllContacts() {
        Collection<Contact> contacts = contactQueryService.getAllContacts();
        Collection<ContactDto> contactDtos = contacts.stream()
                .map(ContactDto::new)
                .collect(Collectors.toSet());
        return ResponseBuilder.ok()
                .data(contactDtos)
                .build();
    }

    @GetMapping("/partners/{partnerUuid}/contacts")
    @ResponseStatus(HttpStatus.OK)
    public Response<Collection<ContactDto>> getContactsByPartnerId(@PathVariable UUID partnerUuid) {
        PartnerId partnerId = PartnerId.fromUuid(partnerUuid);
        Collection<Contact> contacts = contactQueryService.getAllContactsByPartnerId(partnerId);
        Collection<ContactDto> contactDtos = contacts.stream()
                .map(ContactDto::new)
                .collect(Collectors.toSet());
        return ResponseBuilder.ok()
                .data(contactDtos)
                .build();
    }

    @GetMapping("/contacts/{contactUuid}")
    @ResponseStatus(HttpStatus.OK)
    public Response<ContactDto> getContactById(@PathVariable UUID contactUuid) {
        ContactId contactId = ContactId.fromUuid(contactUuid);
        Contact contact = contactQueryService.getContactByContactId(contactId);
        ContactDto contactDto = new ContactDto(contact);
        return ResponseBuilder.ok()
                .data(contactDto)
                .build();
    }
}
