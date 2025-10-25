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
@Table(name = "tbl_recomendaciones_tratamiento", schema = "medicina")
@Getter
@Setter
public class RecomendacionTratamiento {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecomendacion;

    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
}
