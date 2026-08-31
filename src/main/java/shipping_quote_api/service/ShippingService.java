package shipping_quote_api.service;

import org.springframework.stereotype.Service;
import shipping_quote_api.client.AddressClient;
import shipping_quote_api.dto.ShippingOptionResponse;
import shipping_quote_api.dto.ShippingQuoteRequest;
import shipping_quote_api.dto.ShippingQuoteResponse;
import shipping_quote_api.dto.ViaCepResponse;
import shipping_quote_api.provider.ShippingProvider;

import java.util.List;

@Service
public class ShippingService {

    private final AddressClient addressClient;
    private final List<ShippingProvider> shippingProviders;

    public ShippingService(AddressClient addressClient, List<ShippingProvider> shippingProviders) {
        this.addressClient = addressClient;
        this.shippingProviders = shippingProviders;
    }

    public ShippingQuoteResponse quote(ShippingQuoteRequest request) {

        ViaCepResponse origin =
                addressClient.findAddressByZipCode(request.originZipCode());

        ViaCepResponse destination =
                addressClient.findAddressByZipCode(request.destinationZipCode());

        List<ShippingOptionResponse> options = shippingProviders
                .stream()
                .map(provider -> provider.calculate(request))
                .toList();

        String originDescription = origin.localidade() + " - " + origin.uf();

        String destinationDescription = destination.localidade() + " - " + destination.uf();

        return new ShippingQuoteResponse(
                originDescription,
                destinationDescription,
                options
        );
    }
}
