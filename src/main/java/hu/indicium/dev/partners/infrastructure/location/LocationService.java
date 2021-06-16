package hu.indicium.dev.partners.infrastructure.location;

import hu.indicium.dev.partners.domain.model.partner.PartnerId;

public interface LocationService {
    void createLocationForPartner(PartnerId partnerId, CreateLocationRequest createLocationRequest);
}
