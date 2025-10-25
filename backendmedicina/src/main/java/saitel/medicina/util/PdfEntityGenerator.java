package saitel.medicina.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class PdfEntityGenerator {

    private static final List<Class<?>> ENTITY_CLASSES = Arrays.asList(
        saitel.medicina.entity.Sucursal.class,
        saitel.medicina.entity.SignoVital.class,
        saitel.medicina.entity.RevisionOrganosSistemas.class,
        saitel.medicina.entity.RecomendacionTratamiento.class,
        saitel.medicina.entity.Receta.class,
        saitel.medicina.entity.NumeroHistoriaC.class,
        saitel.medicina.entity.MotivoCM.class,
        saitel.medicina.entity.Formulario.class,
        saitel.medicina.entity.FactoresRiesgoTrabajo.class,
        saitel.medicina.entity.ExamenFisico.class,
        saitel.medicina.entity.Examen.class,
        saitel.medicina.entity.EnfermedadActual.class,
        saitel.medicina.entity.Empleado.class,
        saitel.medicina.entity.Diagnostico.class,
        saitel.medicina.entity.DatosProfesional.class,
        saitel.medicina.entity.DatosE.class,
        saitel.medicina.entity.AptitudMedica.class,
        saitel.medicina.entity.AntecedentesTrabajo.class,
        saitel.medicina.entity.AntecedentesFamiliar.class,
        saitel.medicina.entity.Antecedentes.class
    );

    public static void generarPdfEntidades(String rutaArchivo) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
        document.open();
        document.add(new Paragraph("Listado de Entidades y sus Campos"));
        document.add(new Paragraph("----------------------------------"));
        for (Class<?> clazz : ENTITY_CLASSES) {
            document.add(new Paragraph("\nEntidad: " + clazz.getSimpleName()));
            for (Field field : clazz.getDeclaredFields()) {
                document.add(new Paragraph("    - " + field.getType().getSimpleName() + " " + field.getName()));
            }
        }
        document.close();
    }

    public static String generarPdfEntidadesBase64() throws IOException, DocumentException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        document.open();
        document.add(new Paragraph("Listado de Entidades y sus Campos"));
        document.add(new Paragraph("----------------------------------"));
        for (Class<?> clazz : ENTITY_CLASSES) {
            document.add(new Paragraph("\nEntidad: " + clazz.getSimpleName()));
            for (Field field : clazz.getDeclaredFields()) {
                document.add(new Paragraph("    - " + field.getType().getSimpleName() + " " + field.getName()));
            }
        }
        document.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}
