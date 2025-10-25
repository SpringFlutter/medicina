package saitel.medicina.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "antecedentes_trabajo")
public class AntecedentesTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_antecedente_trabajo")
    private Integer id;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "puesto_trabajo")
    private String puestoTrabajo;
    @Column(name = "actividades")
    private String actividades;
    @Column(name = "tiempo_trabajo_meses")
    private Integer tiempoTrabajoMeses;
    @Column(name = "riesgo_fisico")
    private Boolean riesgoFisico;
    @Column(name = "riesgo_mecanico")
    private Boolean riesgoMecanico;
    @Column(name = "riesgo_quimico")
    private Boolean riesgoQuimico;

    @Column(name = "riesgo_biologico")
    private Boolean riesgoBiologico;
    @Column(name = "riesgo_ergonomico")
    private Boolean riesgoErgonomico;
    @Column(name = "riesgo_psicosocial")
    private Boolean riesgoPsicosocial;
    @Column(name = "observaciones_empleo")
    private String observacionesEmpleo;
    @Column(name = "accidente_descripcion")
    private String accidenteDescripcion;
    @Column(name = "accidente_calificado")
    private Boolean accidenteCalificado;
    @Column(name = "accidente_especificar")
    private String accidenteEspecificar;
    @Column(name = "accidente_fecha")
    private LocalDate accidenteFecha;
    @Column(name = "accidente_observaciones")
    private String accidenteObservaciones;
    @Column(name = "enfermedad_calificada")
    private Boolean enfermedadCalificada;
    @Column(name = "enfermedad_especificar")
    private String enfermedadEspecificar;
    @Column(name = "enfermedad_fecha")
    private LocalDate enfermedadFecha;
    @Column(name = "enfermedad_observaciones")
    private String enfermedadObservaciones;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmpresa() {
        return empresa;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public String getPuestoTrabajo() {
        return puestoTrabajo;
    }
    public void setPuestoTrabajo(String puestoTrabajo) {
        this.puestoTrabajo = puestoTrabajo;
    }
    public String getActividades() {
        return actividades;
    }
    public void setActividades(String actividades) {
        this.actividades = actividades;
    }
    public Integer getTiempoTrabajoMeses() {
        return tiempoTrabajoMeses;
    }
    public void setTiempoTrabajoMeses(Integer tiempoTrabajoMeses) {
        this.tiempoTrabajoMeses = tiempoTrabajoMeses;
    }
    public Boolean getRiesgoFisico() {
        return riesgoFisico;
    }
    public void setRiesgoFisico(Boolean riesgoFisico) {
        this.riesgoFisico = riesgoFisico;
    }
    public Boolean getRiesgoMecanico() {
        return riesgoMecanico;
    }
    public void setRiesgoMecanico(Boolean riesgoMecanico) {
        this.riesgoMecanico = riesgoMecanico;
    }
    public Boolean getRiesgoQuimico() {
        return riesgoQuimico;
    }
    public void setRiesgoQuimico(Boolean riesgoQuimico) {
        this.riesgoQuimico = riesgoQuimico;
    }
    public Boolean getRiesgoBiologico() {
        return riesgoBiologico;
    }
    public void setRiesgoBiologico(Boolean riesgoBiologico) {
        this.riesgoBiologico = riesgoBiologico;
    }
    public Boolean getRiesgoErgonomico() {
        return riesgoErgonomico;
    }
    public void setRiesgoErgonomico(Boolean riesgoErgonomico) {
        this.riesgoErgonomico = riesgoErgonomico;
    }
    public Boolean getRiesgoPsicosocial() {
        return riesgoPsicosocial;
    }
    public void setRiesgoPsicosocial(Boolean riesgoPsicosocial) {
        this.riesgoPsicosocial = riesgoPsicosocial;
    }
    public String getObservacionesEmpleo() {
        return observacionesEmpleo;
    }
    public void setObservacionesEmpleo(String observacionesEmpleo) {
        this.observacionesEmpleo = observacionesEmpleo;
    }
    public String getAccidenteDescripcion() {
        return accidenteDescripcion;
    }
    public void setAccidenteDescripcion(String accidenteDescripcion) {
        this.accidenteDescripcion = accidenteDescripcion;
    }
    public Boolean getAccidenteCalificado() {
        return accidenteCalificado;
    }
    public void setAccidenteCalificado(Boolean accidenteCalificado) {
        this.accidenteCalificado = accidenteCalificado;
    }
    public String getAccidenteEspecificar() {
        return accidenteEspecificar;
    }
    public void setAccidenteEspecificar(String accidenteEspecificar) {
        this.accidenteEspecificar = accidenteEspecificar;
    }
    public LocalDate getAccidenteFecha() {
        return accidenteFecha;
    }
    public void setAccidenteFecha(LocalDate accidenteFecha) {
        this.accidenteFecha = accidenteFecha;
    }
    public String getAccidenteObservaciones() {
        return accidenteObservaciones;
    }
    public void setAccidenteObservaciones(String accidenteObservaciones) {
        this.accidenteObservaciones = accidenteObservaciones;
    }
    public Boolean getEnfermedadCalificada() {
        return enfermedadCalificada;
    }
    public void setEnfermedadCalificada(Boolean enfermedadCalificada) {
        this.enfermedadCalificada = enfermedadCalificada;
    }
    public String getEnfermedadEspecificar() {
        return enfermedadEspecificar;
    }
    public void setEnfermedadEspecificar(String enfermedadEspecificar) {
        this.enfermedadEspecificar = enfermedadEspecificar;
    }
    public LocalDate getEnfermedadFecha() {
        return enfermedadFecha;
    }
    public void setEnfermedadFecha(LocalDate enfermedadFecha) {
        this.enfermedadFecha = enfermedadFecha;
    }
    public String getEnfermedadObservaciones() {
        return enfermedadObservaciones;
    }
    public void setEnfermedadObservaciones(String enfermedadObservaciones) {
        this.enfermedadObservaciones = enfermedadObservaciones;
    }
}
