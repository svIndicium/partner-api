package hu.indicium.dev.partners.domain.model.contact;

import hu.indicium.dev.partners.domain.model.partner.PartnerId;

import java.util.Collection;

public interface ContactRepository {
    ContactId nextIdentity();

    Contact findContactByContactId(ContactId contactId);

    Collection<Contact> findContactsByPartnerId(PartnerId partnerId);

    Collection<Contact> getAllContacts();

    Contact save(Contact contact);
}
