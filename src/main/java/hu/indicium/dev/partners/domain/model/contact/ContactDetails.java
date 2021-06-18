package hu.indicium.dev.partners.domain.model.contact;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContactDetails implements Serializable {

    @Embedded
    private Name name;

    private String phoneNumber;

    private String mailAddress;

    public ContactDetails(Name name, String phoneNumber, String mailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mailAddress = mailAddress;
    }
}
