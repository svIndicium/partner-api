package hu.indicium.dev.partners.infrastructure.web.dto;

import hu.indicium.dev.partners.domain.model.contact.Name;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class NameDto {
    private String firstName;

    private String middleName;

    private String lastName;

    public NameDto(Name name) {
        this.firstName = name.getFirstName();
        this.middleName = name.getMiddleName();
        this.lastName = name.getLastName();
    }
}
