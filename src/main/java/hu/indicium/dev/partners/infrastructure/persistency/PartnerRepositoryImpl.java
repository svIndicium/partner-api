package hu.indicium.dev.partners.infrastructure.persistency;

import hu.indicium.dev.partners.domain.model.contact.ContactId;
import hu.indicium.dev.partners.domain.model.partner.Partner;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;
import hu.indicium.dev.partners.domain.model.partner.PartnerRepository;
import hu.indicium.dev.partners.infrastructure.persistency.jpa.PartnerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class PartnerRepositoryImpl implements PartnerRepository {

    private final PartnerJpaRepository partnerJpaRepository;

    @Override
    public PartnerId nextIdentity() {
        UUID uuid = UUID.randomUUID();
        PartnerId partnerId = PartnerId.fromUuid(uuid);
        if (partnerJpaRepository.existsByPartnerId(partnerId)) {
            return nextIdentity();
        }
        return partnerId;
    }

    @Override
    public Partner findPartnerById(PartnerId partnerId) {
        return partnerJpaRepository.findById(partnerId.getId())
                .orElseThrow(() -> new EntityNotFoundException("Partner not found with id " + partnerId.getId().toString()));
    }

    @Override
    public Collection<Partner> getAllPartners() {
        return partnerJpaRepository.findAll();
    }

    @Override
    public Partner save(Partner partner) {
        return partnerJpaRepository.save(partner);
    }
}
