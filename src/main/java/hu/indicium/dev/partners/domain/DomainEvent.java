package hu.indicium.dev.partners.domain;

import java.util.Date;

public interface DomainEvent {

    int eventVersion();

    Date occurredOn();
}
