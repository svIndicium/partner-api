package hu.indicium.dev.partners.application.commands;

import lombok.Data;

@Data
public class CreatePartnerCommand {
    private String name;

    private String description;

    private String logoUrl;

    private String street;

    private String houseNumber;

    private String postalCode;

    private String city;

    private String country;
}
