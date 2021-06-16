package hu.indicium.dev.partners.infrastructure.location;

import hu.indicium.dev.partners.domain.model.partner.PartnerId;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    @Value("${INDICIUM_LOCATION}")
    private String locationUrl;

    private final WebClient webClient;

    @Override
    public void createLocationForPartner(PartnerId partnerId, CreateLocationRequest createLocationRequest) {
        LocationResponse locationResponse = webClient.post()
                .uri(locationUrl + "/partners/" + partnerId.getId().toString() + "/locations")
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .body(Mono.just(createLocationRequest), CreateLocationRequest.class)
                .retrieve()
                .bodyToMono(LocationResponse.class)
                .block();
        if (locationResponse != null && locationResponse.getStatus() != 201) {
            throw new RuntimeException("Could not create location");
        }
    }
}
