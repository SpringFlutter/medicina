package saitel.medicina.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ftbl_sucursal")
public class Sucursal {
    @Id
    
    @Column(name="id_sucursal")
    private Long idSucursal;

    @Column(name="sucursal")
    private String sucursal;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "estado")
    private Boolean estado;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "eliminado")
    private Boolean eliminado;

    public Long getIdSucursal(){return idSucursal;}
    public void setIdSucursal(Long idSucursal){this.idSucursal=idSucursal;}

    public String getSucursal(){return sucursal;}
    public void setSucursal(String sucursal){this.sucursal=sucursal;}

    public Boolean getEstado() { return estado; }
    public void setEstado(Boolean estado) { this.estado = estado; }

    public Boolean getEliminado() { return eliminado; }
    public void setEliminado(Boolean eliminado) { this.eliminado = eliminado; }
}

