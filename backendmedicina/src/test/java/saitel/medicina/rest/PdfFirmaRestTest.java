package saitel.medicina.rest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import saitel.medicina.service.FirmaDigitalService;
import saitel.medicina.util.FirmarDocumento;
import saitel.medicina.util.PdfEntityGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class PdfFirmaRestTest {
    @Mock
    private FirmaDigitalService firmaDigitalService;

    @InjectMocks
    private PdfFirmaRest pdfFirmaRest;

    @Test
    void testGetPdfEntidadesFirmado() throws Exception {
        // Simula el PDF generado y firmado
        String pdfBase64 = "dGVzdA=="; // "test" en base64
        byte[] pdfFirmado = new byte[]{1,2,3};

        // Mock estático para PdfEntityGenerator
        Mockito.mockStatic(PdfEntityGenerator.class).when(PdfEntityGenerator::generarPdfEntidadesBase64).thenReturn(pdfBase64);
        when(firmaDigitalService.firmarDocumento(any(FirmarDocumento.class))).thenReturn(pdfFirmado);

        ResponseEntity<byte[]> response = pdfFirmaRest.getPdfEntidadesFirmado();
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertArrayEquals(pdfFirmado, response.getBody());
        String contentDisposition = response.getHeaders().getFirst("Content-Disposition");
        assertNotNull(contentDisposition);
        assertTrue(contentDisposition.contains("documento_digital_firmado.pdf"));
    }
}
