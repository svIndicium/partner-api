package hu.indicium.dev.partners.domain.model.partner;

import hu.indicium.dev.partners.domain.AssertionConcern;
import hu.indicium.dev.partners.domain.model.contact.Contact;
import hu.indicium.dev.partners.domain.model.contact.ContactDetails;
import hu.indicium.dev.partners.domain.model.contact.ContactId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public class Partner extends AssertionConcern {
    @EmbeddedId
    private PartnerId partnerId;

    private String name;

    private String description;

    private String logoUrl;

    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Contact> contacts;

    public Partner(PartnerId partnerId, String name, String description, String logoUrl) {
        this.partnerId = partnerId;
        this.name = name;
        this.description = description;
        this.logoUrl = logoUrl;
        this.contacts = new HashSet<>();
    }

    public void addContact(ContactId contactId, ContactDetails contactDetails) {
        this.contacts.add(new Contact(contactId, contactDetails, this));
    }
}
