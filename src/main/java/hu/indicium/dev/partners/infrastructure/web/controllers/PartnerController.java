package hu.indicium.dev.partners.infrastructure.web.controllers;

import hu.indicium.dev.partners.application.commands.CreatePartnerCommand;
import hu.indicium.dev.partners.application.query.PartnerQueryService;
import hu.indicium.dev.partners.application.service.PartnerService;
import hu.indicium.dev.partners.domain.model.partner.Partner;
import hu.indicium.dev.partners.domain.model.partner.PartnerId;
import hu.indicium.dev.partners.infrastructure.web.dto.PartnerDto;
import hu.indicium.dev.partners.util.Response;
import hu.indicium.dev.partners.util.ResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

import static hu.indicium.dev.partners.util.BaseUrl.API_V1;

@RestController
@AllArgsConstructor
@RequestMapping(API_V1)
public class PartnerController {

    private final PartnerService partnerService;

    private final PartnerQueryService partnerQueryService;

    @GetMapping("/partners")
    @ResponseStatus(HttpStatus.OK)
    public Response<Collection<PartnerDto>> getAllPartners() {
        Collection<Partner> partners = partnerQueryService.getAllPartners();
        Collection<PartnerDto> partnerDtos = partners.stream()
                .map(PartnerDto::new)
                .collect(Collectors.toSet());
        return ResponseBuilder.ok()
                .data(partnerDtos)
                .build();
    }

    @GetMapping("/partners/{partnerUuid}")
    @ResponseStatus(HttpStatus.OK)
    public Response<PartnerDto> getPartnerById(@PathVariable UUID partnerUuid) {
        PartnerId partnerId = PartnerId.fromUuid(partnerUuid);
        Partner partner = partnerQueryService.getPartnerByPartnerId(partnerId);
        PartnerDto partnerDto = new PartnerDto(partner);
        return ResponseBuilder.ok()
                .data(partnerDto)
                .build();
    }

    @PostMapping("/partners")
    @ResponseStatus(HttpStatus.CREATED)
    public Response<PartnerDto> createPartner(@RequestBody CreatePartnerCommand createPartnerCommand) {
        PartnerId partnerId = partnerService.createPartner(createPartnerCommand);
        Partner partner = partnerQueryService.getPartnerByPartnerId(partnerId);
        PartnerDto partnerDto = new PartnerDto(partner);
        return ResponseBuilder.created()
                .data(partnerDto)
                .build();
    }

}
