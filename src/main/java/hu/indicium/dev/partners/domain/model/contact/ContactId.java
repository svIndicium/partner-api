package hu.indicium.dev.partners.domain.model.contact;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@NoArgsConstructor
public class ContactId implements Serializable {
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private ContactId(UUID id) {
        this.id = id;
    }

    public static ContactId fromUuid(UUID id) {
        return new ContactId(id);
    }
}