package saitel.medicina.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_recetas_enviadas")
@Getter
@Setter
public class Receta {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReceta;

    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;

    @Column(name = "numero_receta", nullable = false)
    private String numeroReceta;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "doctor_a", nullable = false)
    private String doctorA;

    @Column(name = "diagnostico")
    private String diagnostico;

    @Column(name = "receta", nullable = false)
    private String receta;
    
}
