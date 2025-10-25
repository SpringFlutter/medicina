package saitel.medicina.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "tbl_examenes")
public class Examen {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExamen;

    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;

    @Column(name = "nombre_examen", nullable = false)
    private String nombreExamen;

    @Column(name = "fecha_examen", nullable = false)
    private Date fechaExamen;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "observaciones")
    private String observaciones;
}
