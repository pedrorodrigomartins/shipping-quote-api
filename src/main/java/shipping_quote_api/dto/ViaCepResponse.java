package shipping_quote_api.dto;

public record ViaCepResponse(

        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        String estado,
        String erro

) {}
