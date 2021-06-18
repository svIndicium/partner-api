package hu.indicium.dev.partners.infrastructure.persistency.jpa;

import hu.indicium.dev.partners.domain.model.partner.Partner;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartnerJpaRepository extends JpaRepository<Partner, UUID> {
    boolean existsByPartnerId(PartnerId partnerId);
}
