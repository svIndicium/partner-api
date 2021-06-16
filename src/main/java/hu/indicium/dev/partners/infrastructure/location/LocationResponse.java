package hu.indicium.dev.partners.infrastructure.location;

import lombok.Data;

import java.util.Date;

@Data
public class LocationResponse {
    private Object data;
    private Object error;
    private int status;
    private Date timestamp;
}