package hu.indicium.dev.partners.application.service;

import hu.indicium.dev.partners.application.commands.CreatePartnerCommand;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;

public interface PartnerService {
    PartnerId createPartner(CreatePartnerCommand createPartnerCommand);
}
