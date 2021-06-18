package hu.indicium.dev.partners.application.query;

import hu.indicium.dev.partners.domain.model.contact.Contact;
import hu.indicium.dev.partners.domain.model.contact.ContactId;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;

import java.util.Collection;

public interface ContactQueryService {
    Collection<Contact> getAllContacts();

    Collection<Contact> getAllContactsByPartnerId(PartnerId partnerId);

    Contact getContactByContactId(ContactId contactId);
}
