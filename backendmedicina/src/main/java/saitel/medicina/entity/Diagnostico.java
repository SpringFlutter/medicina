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
@Table(name = "tbl_diagnostico")
@Getter
@Setter
public class Diagnostico {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDiagnostico;

    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "cie")
    private String cie;

    @Column(name = "es_presuntivo")
    private Boolean esPresuntivo = false;

    @Column(name = "es_definitivo")
    private Boolean esDefinitivo = false;
}
