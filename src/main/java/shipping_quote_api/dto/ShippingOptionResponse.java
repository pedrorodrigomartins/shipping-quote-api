package shipping_quote_api.dto;

import java.math.BigDecimal;

public record ShippingOptionResponse(

        String type,
        BigDecimal price,
        Integer estimatedDays

) {}
