package hu.indicium.dev.partners.domain.model.contact;

import hu.indicium.dev.partners.domain.AssertionConcern;
import hu.indicium.dev.partners.domain.model.partner.Partner;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
public class Contact extends AssertionConcern {
    @EmbeddedId
    private ContactId contactId;

    @Embedded
    private ContactDetails details;

    @ManyToOne
    private Partner partner;

    public Contact(ContactId contactId, ContactDetails details, Partner partner) {
        this.contactId = contactId;
        this.details = details;
        this.partner = partner;
    }
}
