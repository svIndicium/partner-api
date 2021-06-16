package hu.indicium.dev.partners.domain.model.partner;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Getter
@NoArgsConstructor
public class PartnerId implements Serializable {
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private PartnerId(UUID id) {
        this.id = id;
    }

    public static PartnerId fromUuid(UUID id) {
        return new PartnerId(id);
    }
}
