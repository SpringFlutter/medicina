package saitel.medicina.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_enfermedad_actual")
@Getter
@Setter
public class EnfermedadActual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enfermedad_actual")
    private Integer idEnfermedadActual;

    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro = LocalDate.now();
}