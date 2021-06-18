package hu.indicium.dev.partners.domain.model.partner;

import java.util.Collection;

public interface PartnerRepository {
    PartnerId nextIdentity();

    Partner findPartnerById(PartnerId partnerId);

    Collection<Partner> getAllPartners();

    Partner save(Partner partner);
}
