package saitel.medicina.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_antecedentes_familiares")
public class AntecedentesFamiliar {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_antecedente_familiar")
    private Integer idAntecedenteFamiliar;

    @Column(name = "tipo_enfermedad", nullable = false)
    private Integer tipoEnfermedad;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
    public Integer getIdAntecedenteFamiliar() {
        return idAntecedenteFamiliar;
    }

    public void setIdAntecedenteFamiliar(Integer idAntecedenteFamiliar) {
        this.idAntecedenteFamiliar = idAntecedenteFamiliar;
    }
    public Integer getTipoEnfermedad() {
        return tipoEnfermedad;
    }
    public void setTipoEnfermedad(Integer tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
