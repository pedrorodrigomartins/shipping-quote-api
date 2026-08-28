package shipping_quote_api.provider;

import shipping_quote_api.dto.ShippingOptionResponse;
import shipping_quote_api.dto.ShippingQuoteRequest;

public interface ShippingProvider {

    ShippingOptionResponse calculate(ShippingQuoteRequest request);
}
