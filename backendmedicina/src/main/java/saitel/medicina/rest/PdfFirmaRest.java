package saitel.medicina.rest;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saitel.medicina.service.FirmaDigitalService;
import saitel.medicina.util.FirmarDocumento;
import saitel.medicina.util.PdfEntityGenerator;

import java.io.IOException;

@RestController
@RequestMapping("/api/pdf")
public class PdfFirmaRest {

    @Autowired
    private FirmaDigitalService firmaDigitalService;

    @GetMapping
    public ResponseEntity<byte[]> getPdfEntidadesFirmado() throws IOException, DocumentException {
        String pdfBase64 = PdfEntityGenerator.generarPdfEntidadesBase64();
        FirmarDocumento firmarDocumento = new FirmarDocumento();
        firmarDocumento.setDocumento(pdfBase64);
        firmarDocumento.setClave("CLAVE_FIRMA"); 
        firmarDocumento.setEtiqueta("FIRMA_DOCTORA");
        firmarDocumento.setIdEmpleado(1L); 
        firmarDocumento.setQrDimension(25);
        firmarDocumento.setNombreDocumento("documento_digital.pdf");
        firmarDocumento.setUbicarFirma(false);
        firmarDocumento.setPagina(0);
        firmarDocumento.setCordX(0f);
        firmarDocumento.setCordY(0f);
        firmarDocumento.setOrden(0);

        byte[] pdfFirmado = firmaDigitalService.firmarDocumento(firmarDocumento);
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=documento_digital_firmado.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfFirmado);
    }
}
