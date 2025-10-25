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
@Table(name = "tbl_signo_vital")
@Setter
@Getter
public class SignoVital {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_signo_vital")
    private Integer idSignoVital;
    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;
    @Column(name = "presion_arterial_a", nullable = false)
    private Integer presionArterialA;
    @Column(name = "presion_arterial_b", nullable = false)
    private Integer presionArterialB;
    @Column(name = "temperatura")
    private Double temperatura;
    @Column(name = "frecuencia_cardicaca", nullable = false)
    private Integer frecuenciaCardicaca;
    @Column(name = "saturacion_oxg", nullable = false)
    private Integer saturacionOxg;
    @Column(name = "frecuencia_respiratoria")
    private Integer frecuenciaRespiratoria;
    @Column(name = "peso")
    private Double peso;
    @Column(name = "talla")
    private Double talla;
    @Column(name = "masa_corporal")
    private Double masaCorporal;
    @Column(name = "perimetro_abdominal")
    private Double perimetroAbdominal;
}
