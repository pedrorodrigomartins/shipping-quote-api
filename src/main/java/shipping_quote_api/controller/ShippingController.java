package shipping_quote_api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import shipping_quote_api.dto.ShippingQuoteRequest;
import shipping_quote_api.dto.ShippingQuoteResponse;
import shipping_quote_api.service.ShippingService;

@RestController
@RequestMapping("/api/shipping/quote")
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @PostMapping
    public ShippingQuoteResponse createQuote(
            @Valid @RequestBody ShippingQuoteRequest request
    ) {
        return shippingService.quote(request);
    }
}
