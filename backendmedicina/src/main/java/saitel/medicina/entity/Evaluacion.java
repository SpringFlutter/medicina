
package saitel.medicina.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_evaluacion", schema = "medicina")
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluacion")
    private Long idEvaluacion;

    @Column(name = "id_empleado", nullable = false)
    private Long idEmpleado;

    @Column(name = "id_formulario", nullable = false)
    private Long idFormulario;

    @Column(name = "tipo_evaluacion", nullable = false, length = 50)
    private String tipoEvaluacion;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_historia_clinica", nullable = false)
    private Integer idHistoriaClinica;
}
