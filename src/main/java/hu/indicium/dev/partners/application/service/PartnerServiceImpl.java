package hu.indicium.dev.partners.application.service;

import hu.indicium.dev.partners.application.commands.CreatePartnerCommand;
import hu.indicium.dev.partners.domain.model.partner.Partner;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;
import hu.indicium.dev.partners.domain.model.partner.PartnerRepository;
import hu.indicium.dev.partners.infrastructure.location.CreateLocationRequest;
import hu.indicium.dev.partners.infrastructure.location.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository partnerRepository;

    private final LocationService locationService;

    @Override
    @Transactional
    public PartnerId createPartner(CreatePartnerCommand createPartnerCommand) {
        PartnerId partnerId = partnerRepository.nextIdentity();

        Partner partner = new Partner(partnerId, createPartnerCommand.getName(), createPartnerCommand.getDescription(), createPartnerCommand.getLogoUrl());

        partnerRepository.save(partner);

        CreateLocationRequest createLocationRequest = CreateLocationRequest.builder()
                .street(createPartnerCommand.getStreet())
                .houseNumber(createPartnerCommand.getHouseNumber())
                .postalCode(createPartnerCommand.getPostalCode())
                .city(createPartnerCommand.getCity())
                .country(createPartnerCommand.getCountry())
                .build();

        locationService.createLocationForPartner(partnerId, createLocationRequest);

        return partnerId;
    }
}
