package saitel.medicina.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_formulario")
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secFormulario")
    @SequenceGenerator(name = "secFormulario", sequenceName = "sec_formulario", allocationSize = 1)
    @Column(name="id_formulario")
    private Long idFormulario;
    @Column (name = "id_area")
    private Long idArea;
    @Column(name="formulario")
    private String formulario;

    public Formulario(){}

    public Formulario(Long idFormulario, Long idArea, String formulario){
        this.idFormulario = idFormulario;
        this.idArea = idArea;
        this.formulario = formulario;
    }
    public Long getIdFormulario(){
        return this.idFormulario;
    }
    public void setIdFormulario(Long idFormulario){
        this.idFormulario = idFormulario;
    }
    public Long getIdArea(){
        return this.idArea;
    }
    public void setIdArea(Long idArea){
        this.idArea = idArea;
    }
    public String getFormulario(){
        return this.formulario;
    }
    public void setFormulario(String formulario){
        this.formulario = formulario;
    }
}
