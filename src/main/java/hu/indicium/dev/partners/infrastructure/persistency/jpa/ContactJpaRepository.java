package hu.indicium.dev.partners.infrastructure.persistency.jpa;

import hu.indicium.dev.partners.domain.model.contact.Contact;
import hu.indicium.dev.partners.domain.model.contact.ContactId;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface ContactJpaRepository extends JpaRepository<Contact, UUID> {
    boolean existsByContactId(ContactId contactId);

    Collection<Contact> findByPartnerPartnerId(PartnerId partnerId);
}
