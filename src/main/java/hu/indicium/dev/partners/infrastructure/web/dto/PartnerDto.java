package hu.indicium.dev.partners.infrastructure.web.dto;

import hu.indicium.dev.partners.domain.model.partner.Partner;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PartnerDto {

    private UUID partnerId;

    private String name;

    private String description;

    private String logoUrl;

    public PartnerDto(Partner partner) {
        this.partnerId = partner.getPartnerId().getId();
        this.name = partner.getName();
        this.description = partner.getDescription();
        this.logoUrl = partner.getLogoUrl();
    }
}
