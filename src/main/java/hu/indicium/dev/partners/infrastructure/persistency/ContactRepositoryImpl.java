package hu.indicium.dev.partners.infrastructure.persistency;

import hu.indicium.dev.partners.domain.model.contact.Contact;
import hu.indicium.dev.partners.domain.model.contact.ContactId;
import hu.indicium.dev.partners.domain.model.contact.ContactRepository;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;
import hu.indicium.dev.partners.infrastructure.persistency.jpa.ContactJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class ContactRepositoryImpl implements ContactRepository {

    private final ContactJpaRepository contactJpaRepository;

    @Override
    public ContactId nextIdentity() {
        UUID uuid = UUID.randomUUID();
        ContactId contactId = ContactId.fromUuid(uuid);
        if (contactJpaRepository.existsByContactId(contactId)) {
            return nextIdentity();
        }
        return contactId;
    }

    @Override
    public Contact findContactByContactId(ContactId contactId) {
        return contactJpaRepository.findById(contactId.getId())
                .orElseThrow(() -> new EntityNotFoundException("Contact not found with id " + contactId.getId().toString()));
    }

    @Override
    public Collection<Contact> findContactsByPartnerId(PartnerId partnerId) {
        return contactJpaRepository.findByPartnerPartnerId(partnerId);
    }

    @Override
    public Collection<Contact> getAllContacts() {
        return contactJpaRepository.findAll();
    }

    @Override
    public Contact save(Contact contact) {
        return contactJpaRepository.save(contact);
    }
}
