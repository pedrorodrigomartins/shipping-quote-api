package shipping_quote_api.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import shipping_quote_api.dto.ViaCepResponse;
import shipping_quote_api.exception.ZipCodeNotFoundException;

@Component
public class AddressClient {

    private final RestClient restClient;

    public AddressClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public ViaCepResponse findAddressByZipCode(String zipCode) {

        ViaCepResponse response = restClient.get()
                .uri("/{zipCode}/json/", zipCode)
                .retrieve()
                .body(ViaCepResponse.class);

        if (response != null && "true".equals(response.erro())) {
            throw new ZipCodeNotFoundException(
                    "Zip code not found: " + zipCode
            );
        }

        return response;
    }

}
