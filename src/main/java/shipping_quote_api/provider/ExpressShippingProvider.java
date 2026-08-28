package shipping_quote_api.provider;

import org.springframework.stereotype.Component;
import shipping_quote_api.dto.ShippingOptionResponse;
import shipping_quote_api.dto.ShippingQuoteRequest;

import java.math.BigDecimal;

@Component
public class ExpressShippingProvider implements ShippingProvider{

    private static final BigDecimal BASE_PRICE = BigDecimal.valueOf(18);
    private static final BigDecimal PRICE_PER_KG = BigDecimal.valueOf(4);

    @Override
    public ShippingOptionResponse calculate(ShippingQuoteRequest request) {

        BigDecimal weight = request.weight();

        BigDecimal calculatedPrice = BASE_PRICE.add(weight.multiply(PRICE_PER_KG));

        return new ShippingOptionResponse(
                "EXPRESS",
                calculatedPrice,
                2
        );
    }
}
