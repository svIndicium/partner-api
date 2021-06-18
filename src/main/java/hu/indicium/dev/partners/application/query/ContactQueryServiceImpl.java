package hu.indicium.dev.partners.application.query;

import hu.indicium.dev.partners.domain.model.contact.Contact;
import hu.indicium.dev.partners.domain.model.contact.ContactId;
import hu.indicium.dev.partners.domain.model.contact.ContactRepository;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ContactQueryServiceImpl implements ContactQueryService {

    private final ContactRepository contactRepository;

    @Override
    public Collection<Contact> getAllContacts() {
        return contactRepository.getAllContacts();
    }

    @Override
    public Collection<Contact> getAllContactsByPartnerId(PartnerId partnerId) {
        return contactRepository.findContactsByPartnerId(partnerId);
    }

    @Override
    public Contact getContactByContactId(ContactId contactId) {
        return contactRepository.findContactByContactId(contactId);
    }
}
