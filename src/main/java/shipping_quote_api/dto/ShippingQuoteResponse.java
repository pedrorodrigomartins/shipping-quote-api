package shipping_quote_api.dto;

import java.util.List;

public record ShippingQuoteResponse(

        String origin,
        String destination,
        List<ShippingOptionResponse> options

) {}
