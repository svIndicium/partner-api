package hu.indicium.dev.partners.application.query;

import hu.indicium.dev.partners.domain.model.partner.Partner;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;

import java.util.Collection;

public interface PartnerQueryService {
    Partner getPartnerByPartnerId(PartnerId partnerId);

    Collection<Partner> getAllPartners();
}
