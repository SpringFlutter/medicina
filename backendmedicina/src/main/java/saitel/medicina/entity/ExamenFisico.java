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
@Table(name = "tbl_examen_fisico")
@Getter
@Setter
public class ExamenFisico {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examen_fisico")
    private Integer idExamenFisico;
    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "resultados")
    private String resultados;
    @Column(name = "cicatrices")
    private Boolean cicatrices;
    @Column(name = "tatuajes")
    private Boolean tatuajes;
    @Column(name = "piel_faneras")
    private String pielFaneras;
    @Column(name = "parpados")
    private String parpados;
    @Column(name = "conjuntivas")
    private String conjuntivas;
    @Column(name = "pupilas")
    private String pupilas;
    @Column(name = "cornea")
    private String cornea;
    @Column(name = "motilidad_ocular")
    private String motilidadOcular;
    @Column(name = "conducto_auditivo_externo")
    private String conductoAuditivoExterno;
    @Column(name = "pabellon")
    private String pabellon;
    @Column(name = "timpanos")
    private String timpanos;
    @Column(name = "labios")
    private String labios;
    @Column(name = "lengua")
    private String lengua;
    @Column(name = "faringe")
    private String faringe;
    @Column(name = "amigdalas")
    private String amigdalas;
    @Column(name = "dentadura")
    private String dentadura;
    @Column(name = "tabique")
    private String tabique;
    @Column(name = "cornetes")
    private String cornetes;
    @Column(name = "mucosas")
    private String mucosas;
    @Column(name = "senos_paranasales")
    private String senosParanasales;
    @Column(name = "tiroides_masas")
    private String tiroidesMasas;
    @Column(name = "movilidad_cuello")
    private String movilidadCuello;
    @Column(name = "mamas")
    private String mamas;
    @Column(name = "corazon")
    private String corazon;
    @Column(name = "pulmones")
    private String pulmones;
    @Column(name = "parrilla_costal")
    private String parrillaCostal;
    @Column(name = "visceras")
    private String visceras;
    @Column(name = "pared_abdominal")
    private String paredAbdominal;
    @Column(name = "flexibilidad")
    private String flexibilidad;
    @Column(name = "desviacion")
    private String desviacion;
    @Column(name = "dolor")
    private String dolor;
    @Column(name = "pelvis")
    private String pelvis;
    @Column(name = "genitales")
    private String genitales;
    @Column(name = "vascular")
    private String vascular;
    @Column(name = "miembros_superiores")
    private String miembrosSuperiores;
    @Column(name = "miembros_inferiores")
    private String miembrosInferiores;
    @Column(name = "fuerza")
    private String fuerza;
    @Column(name = "sensibilidad")
    private String sensibilidad;
    @Column(name = "marcha")
    private String marcha;
    @Column(name = "reflejos")
    private String reflejos;
    @Column(name = "observaciones")
    private String observaciones;
}


