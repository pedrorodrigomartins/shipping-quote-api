package shipping_quote_api.service;

import org.springframework.stereotype.Service;
import shipping_quote_api.client.AddressClient;
import shipping_quote_api.dto.ShippingQuoteRequest;
import shipping_quote_api.dto.ViaCepResponse;

@Service
public class ShippingService {

    private final AddressClient addressClient;

    public ShippingService(AddressClient addressClient) {
        this.addressClient = addressClient;
    }

    public Void quote(ShippingQuoteRequest request) {

        ViaCepResponse origin =
                addressClient.findAddressByZipCode(request.originZipCode());

        ViaCepResponse destination =
                addressClient.findAddressByZipCode(request.destinationZipCode());


    }
}
