
package saitel.medicina.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_inmunizaciones", schema = "medicina")
public class Inmunizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inmunizaciones")
    private Integer idInmunizaciones;

    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;

    @Column(name = "vacuna", nullable = false, length = 100)
    private String vacuna;

    @Column(name = "dosis", nullable = false, length = 20)
    private String dosis;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "lote", length = 50)
    private String lote;

    @Column(name = "esquema_completo")
    private Boolean esquemaCompleto;

    @Column(name = "responsable_vacunacion", length = 150)
    private String responsableVacunacion;

    @Column(name = "establecimiento_salud", length = 150)
    private String establecimientoSalud;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "tipo_inmunizacion", length = 100)
    private String tipoInmunizacion;

}
