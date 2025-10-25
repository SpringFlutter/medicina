package saitel.medicina.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import saitel.medicina.util.FirmarDocumento;

@Service
public class FirmaDigitalService {
    private final String API_URL = "https://api.saitelapp.ec:32086/documento/firmar2";

    public byte[] firmarDocumento(FirmarDocumento firmarDocumento) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FirmarDocumento> request = new HttpEntity<>(firmarDocumento, headers);
        ResponseEntity<byte[]> response = restTemplate.exchange(
                API_URL,
                HttpMethod.PUT,
                request,
                byte[].class
        );
        return response.getBody();
    }
}
