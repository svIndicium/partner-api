package hu.indicium.dev.partners.application.query;

import hu.indicium.dev.partners.domain.model.partner.Partner;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;
import hu.indicium.dev.partners.domain.model.partner.PartnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class PartnerQueryServiceImpl implements PartnerQueryService {

    private final PartnerRepository partnerRepository;

    @Override
    public Partner getPartnerByPartnerId(PartnerId partnerId) {
        return partnerRepository.findPartnerById(partnerId);
    }

    @Override
    public Collection<Partner> getAllPartners() {
        return partnerRepository.getAllPartners();
    }
}
