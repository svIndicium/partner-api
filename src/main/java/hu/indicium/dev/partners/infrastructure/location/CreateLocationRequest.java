package hu.indicium.dev.partners.infrastructure.location;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateLocationRequest {

    private String street;

    private String houseNumber;

    private String postalCode;

    private String city;

    private String country;
}
