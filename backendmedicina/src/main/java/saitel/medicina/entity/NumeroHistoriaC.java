package saitel.medicina.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "tbl_historia_clinica")
public class NumeroHistoriaC {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_historia_clinica", nullable = false)
private Integer idHistoriaC;

@Column(name = "id_empleado")
private Integer idEmpleado;

@Column(name = "numero_historia_clinica")
private String numeroHistoriaC;

public Integer getId() { return idHistoriaC; }
public void setId(Integer id) { this.idHistoriaC = id; }

public Integer getIdEmpleado() { return idEmpleado; }
public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = idEmpleado; }

public String getNumeroHistoriaC() { return numeroHistoriaC; }
public void setNumeroHistoriaC(String numeroHistoriaC) { this.numeroHistoriaC = numeroHistoriaC; }
}
