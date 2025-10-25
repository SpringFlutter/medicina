package saitel.medicina.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tbl_aptitud_medica")
@Getter
@Setter
public class AptitudMedica {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAptitud;

    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;

    @Column(name = "apto")
    private Boolean apto = false;

    @Column(name = "apto_en_observacion")
    private Boolean aptoEnObservacion = false;

    @Column(name = "apto_con_limitaciones")
    private Boolean aptoConLimitaciones = false;

    @Column(name = "no_apto")
    private Boolean noApto = false;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "limitacion")
    private String limitacion;

}
