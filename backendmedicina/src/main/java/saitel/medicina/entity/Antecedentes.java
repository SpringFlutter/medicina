package saitel.medicina.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tbl_antecedentes")
public class Antecedentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_antecedente")
    private Long idAntecedente;

    @Column(name = "id_historia_clinica")
    private Integer idHistoriaClinica;

    @Column(name = "antecedentes_clinicos_quirurgicos")
    private String antecedentesClinicosQuirurgicos;

    @Column(name = "antecedentes_gineco_obstetricos")
    private String antecedentesGinecoObstetricos;

    @Column(name = "menarquia_ciclos")
    private String menarquiaCiclos;

    @Column(name = "fecha_ultima_menstruacion")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaMenstruacion;

    @Column(name = "gestas")
    private Integer gestas;

    @Column(name = "partos")
    private Integer partos;

    @Column(name = "cesareas")
    private Integer cesareas;

    @Column(name = "abortos")
    private Integer abortos;

    @Column(name = "hijos_vivos")
    private Integer hijosVivos;

    @Column(name = "hijos_muertos")
    private Integer hijosMuertos;

    @Column(name = "vida_sexual_activa")
    private Boolean vidaSexualActiva;

    @Column(name = "metodo_planificacion_tipo")
    private String metodoPlanificacionTipo;

    @Column(name = "papanicolaou_tiempo_anios")
    private Integer papanicolaouTiempoAnios;

    @Column(name = "papanicolaou_resultado")
    private String papanicolaouResultado;

    @Column(name = "colposcopia_tiempo_anios")
    private Integer colposcopiaTiempoAnios;

    @Column(name = "colposcopia_resultado")
    private String colposcopiaResultado;

    @Column(name = "ant_reproductivos_masculinos")
    private Boolean antReproductivosMasculinos;

    @Column(name = "metodo_planificacion_masculino")
    private String metodoPlanificacionMasculino;

    @Column(name = "hijos_masculino_vivos")
    private Integer hijosMasculinoVivos;

    @Column(name = "hijos_masculino_muertos")
    private Integer hijosMasculinoMuertos;

    @Column(name = "antigeno_prostatico_tiempo_anios")
    private Integer antigenoProstaticoTiempoAnios;

    @Column(name = "antigeno_prostatico_resultado")
    private String antigenoProstaticoResultado;

    @Column(name = "eco_prostatico_tiempo_anios")
    private Integer ecoProstaticoTiempoAnios;

    @Column(name = "eco_prostatico_resultado")
    private String ecoProstaticoResultado;

    @Column(name = "tabaco_tiempo_meses")
    private Integer tabacoTiempoMeses;

    @Column(name = "tabaco_cantidad")
    private String tabacoCantidad;

    @Column(name = "tabaco_ex_consumidor")
    private Boolean tabacoExConsumidor;

    @Column(name = "tabaco_abstinencia_meses")
    private Integer tabacoAbstinenciaMeses;

    @Column(name = "alcohol_tiempo_meses")
    private Integer alcoholTiempoMeses;

    @Column(name = "alcohol_cantidad")
    private String alcoholCantidad;

    @Column(name = "alcohol_ex_consumidor")
    private Boolean alcoholExConsumidor;

    @Column(name = "alcohol_abstinencia_meses")
    private Integer alcoholAbstinenciaMeses;

    @Column(name = "otras_drogas")
    private String otrasDrogas;

    @Column(name = "otras_drogas_cantidad")
    private String otrasDrogasCantidad;

    @Column(name = "actividad_fisica_dias_semana")
    private Integer actividadFisicaDiasSemana;

    @Column(name = "estilo_vida")
    private String estiloVida;

    @Column(name = "estilo_vida_tiempo")
    private String estiloVidaTiempo;

    @Column(name = "medicacion_habitual")
    private String medicacionHabitual;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;


    public Long getIdAntecedente() {return idAntecedente;}
    public void setIdAntecedente(Long idAntecedente) {this.idAntecedente = idAntecedente;}

    public Integer getIdHistoriaClinica() {return idHistoriaClinica;}
    public void setIdHistoriaClinica(Integer idHistoriaClinica) {this.idHistoriaClinica = idHistoriaClinica;}

    public String getAntecedentesClinicosQuirurgicos() {return antecedentesClinicosQuirurgicos;}
    public void setAntecedentesClinicosQuirurgicos(String antecedentesClinicosQuirurgicos) {this.antecedentesClinicosQuirurgicos = antecedentesClinicosQuirurgicos;}

    public String getAntecedentesGinecoObstetricos() {return antecedentesGinecoObstetricos;}
    public void setAntecedentesGinecoObstetricos(String antecedentesGinecoObstetricos) {this.antecedentesGinecoObstetricos = antecedentesGinecoObstetricos;}

    public String getMenarquiaCiclos() {return menarquiaCiclos;}
    public void setMenarquiaCiclos(String menarquiaCiclos) {this.menarquiaCiclos = menarquiaCiclos;}

    public Date getFechaUltimaMenstruacion() {return fechaUltimaMenstruacion;}
    public void setFechaUltimaMenstruacion(Date fechaUltimaMenstruacion) {this.fechaUltimaMenstruacion = fechaUltimaMenstruacion;}

    public Integer getGestas() {return gestas;}
    public void setGestas(Integer gestas) {this.gestas = gestas;}

    public Integer getPartos() {return partos;}
    public void setPartos(Integer partos) {this.partos = partos;}

    public Integer getCesareas() {return cesareas;}
    public void setCesareas(Integer cesareas) {this.cesareas = cesareas;}

    public Integer getAbortos() {return abortos;}
    public void setAbortos(Integer abortos) {this.abortos = abortos;}

    public Integer getHijosVivos() {return hijosVivos;}
    public void setHijosVivos(Integer hijosVivos) {this.hijosVivos = hijosVivos;}

    public Integer getHijosMuertos() { return hijosMuertos;}
    public void setHijosMuertos(Integer hijosMuertos) {this.hijosMuertos = hijosMuertos;}

    public Boolean getVidaSexualActiva() {return vidaSexualActiva;}
    public void setVidaSexualActiva(Boolean vidaSexualActiva) {this.vidaSexualActiva = vidaSexualActiva;}

    public String getMetodoPlanificacionTipo() {return metodoPlanificacionTipo;}
    public void setMetodoPlanificacionTipo(String metodoPlanificacionTipo) {this.metodoPlanificacionTipo = metodoPlanificacionTipo;}

    public Integer getPapanicolaouTiempoAnios() {return papanicolaouTiempoAnios;}
    public void setPapanicolaouTiempoAnios(Integer papanicolaouTiempoAnios) {this.papanicolaouTiempoAnios = papanicolaouTiempoAnios;}

    public String getPapanicolaouResultado() {return papanicolaouResultado;}
    public void setPapanicolaouResultado(String papanicolaouResultado) {this.papanicolaouResultado = papanicolaouResultado;}

    public Integer getColposcopiaTiempoAnios() {return colposcopiaTiempoAnios;}
    public void setColposcopiaTiempoAnios(Integer colposcopiaTiempoAnios) {this.colposcopiaTiempoAnios = colposcopiaTiempoAnios;}

    public String getColposcopiaResultado() {return colposcopiaResultado;}
    public void setColposcopiaResultado(String colposcopiaResultado) {this.colposcopiaResultado = colposcopiaResultado;}

    public Boolean getAntReproductivosMasculinos() {return antReproductivosMasculinos;}
    public void setAntReproductivosMasculinos(Boolean antReproductivosMasculinos) {this.antReproductivosMasculinos = antReproductivosMasculinos;}

    public String getMetodoPlanificacionMasculino() {return metodoPlanificacionMasculino;}
    public void setMetodoPlanificacionMasculino(String metodoPlanificacionMasculino) {this.metodoPlanificacionMasculino = metodoPlanificacionMasculino;}

    public Integer getHijosMasculinoVivos() {return hijosMasculinoVivos;}
    public void setHijosMasculinoVivos(Integer hijosMasculinoVivos) {this.hijosMasculinoVivos = hijosMasculinoVivos;}

    public Integer getHijosMasculinoMuertos() {return hijosMasculinoMuertos;}
    public void setHijosMasculinoMuertos(Integer hijosMasculinoMuertos) {this.hijosMasculinoMuertos = hijosMasculinoMuertos;}

    public Integer getAntigenoProstaticoTiempoAnios() {return antigenoProstaticoTiempoAnios;}
    public void setAntigenoProstaticoTiempoAnios(Integer antigenoProstaticoTiempoAnios) {this.antigenoProstaticoTiempoAnios = antigenoProstaticoTiempoAnios;}

    public String getAntigenoProstaticoResultado() {return antigenoProstaticoResultado;}
    public void setAntigenoProstaticoResultado(String antigenoProstaticoResultado) {this.antigenoProstaticoResultado = antigenoProstaticoResultado;}

    public Integer getEcoProstaticoTiempoAnios() {return ecoProstaticoTiempoAnios;}
    public void setEcoProstaticoTiempoAnios(Integer ecoProstaticoTiempoAnios) {this.ecoProstaticoTiempoAnios = ecoProstaticoTiempoAnios;}

    public String getEcoProstaticoResultado() {return ecoProstaticoResultado;}
    public void setEcoProstaticoResultado(String ecoProstaticoResultado) {this.ecoProstaticoResultado = ecoProstaticoResultado;}

    public Integer getTabacoTiempoMeses() {return tabacoTiempoMeses;}
    public void setTabacoTiempoMeses(Integer tabacoTiempoMeses) {this.tabacoTiempoMeses = tabacoTiempoMeses;}

    public String getTabacoCantidad() {return tabacoCantidad;}
    public void setTabacoCantidad(String tabacoCantidad) {this.tabacoCantidad = tabacoCantidad;}

    public Boolean getTabacoExConsumidor() {return tabacoExConsumidor;}
    public void setTabacoExConsumidor(Boolean tabacoExConsumidor) {this.tabacoExConsumidor = tabacoExConsumidor;}

    public Integer getTabacoAbstinenciaMeses() {return tabacoAbstinenciaMeses;}
    public void setTabacoAbstinenciaMeses(Integer tabacoAbstinenciaMeses) {this.tabacoAbstinenciaMeses = tabacoAbstinenciaMeses;}

    public Integer getAlcoholTiempoMeses() {return alcoholTiempoMeses;}
    public void setAlcoholTiempoMeses(Integer alcoholTiempoMeses) {this.alcoholTiempoMeses = alcoholTiempoMeses;}

    public String getAlcoholCantidad() {return alcoholCantidad;}
    public void setAlcoholCantidad(String alcoholCantidad) {this.alcoholCantidad = alcoholCantidad;}

    public Boolean getAlcoholExConsumidor() {return alcoholExConsumidor;}
    public void setAlcoholExConsumidor(Boolean alcoholExConsumidor) {this.alcoholExConsumidor = alcoholExConsumidor;}

    public Integer getAlcoholAbstinenciaMeses() {return alcoholAbstinenciaMeses;}
    public void setAlcoholAbstinenciaMeses(Integer alcoholAbstinenciaMeses) {this.alcoholAbstinenciaMeses = alcoholAbstinenciaMeses;}

    public String getOtrasDrogas() {return otrasDrogas;}
    public void setOtrasDrogas(String otrasDrogas) {this.otrasDrogas = otrasDrogas;}

    public String getOtrasDrogasCantidad() {return otrasDrogasCantidad;}
    public void setOtrasDrogasCantidad(String otrasDrogasCantidad) {this.otrasDrogasCantidad = otrasDrogasCantidad;}

    public Integer getActividadFisicaDiasSemana() {return actividadFisicaDiasSemana;}
    public void setActividadFisicaDiasSemana(Integer actividadFisicaDiasSemana) {this.actividadFisicaDiasSemana = actividadFisicaDiasSemana;}

    public String getEstiloVida() {return estiloVida;}
    public void setEstiloVida(String estiloVida) {this.estiloVida = estiloVida;}

    public String getEstiloVidaTiempo() {return estiloVidaTiempo;}
    public void setEstiloVidaTiempo(String estiloVidaTiempo) {this.estiloVidaTiempo = estiloVidaTiempo;}

    public String getMedicacionHabitual() {return medicacionHabitual;}
    public void setMedicacionHabitual(String medicacionHabitual) {this.medicacionHabitual = medicacionHabitual;}

    public LocalDateTime getFechaRegistro() {return fechaRegistro;}
    public void setFechaRegistro(LocalDateTime fechaRegistro) {this.fechaRegistro = fechaRegistro;}
}
