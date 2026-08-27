package shipping_quote_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ShippingQuoteRequest(

        @NotBlank(message = "Origin zip code is required.")
        @Pattern(regexp = "^[0-9]{8}$", message = "Zip code must contain exactly 8 digits.")
        String originZipCode,

        @NotBlank(message = "Destination zip code is required.")
        @Pattern(regexp = "^[0-9]{8}$", message = "Zip code must contain exactly 8 digits.")
        String destinationZipCode,

        @NotNull(message = "Weight is required.")
        @Positive(message = "Weight must be greater than zero.")
        BigDecimal weight,

        @NotNull(message = "Length is required.")
        @Positive(message = "Length must be greater than zero.")
        BigDecimal length,

        @NotNull(message = "Width is required.")
        @Positive(message = "Width must be greater than zero.")
        BigDecimal width,

        @NotNull(message = "Height is required.")
        @Positive(message = "Height must be greater than zero.")
        BigDecimal height

) {}
