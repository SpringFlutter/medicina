package saitel.medicina.entity;

import java.sql.Date;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Immutable // <-- Esto marca la entidad como de solo lectura
@Table(name = "f_vta_empleado")
public class DatosE {
    @Id
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "sucursal")
    private String sucursal;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "primer_apellido")
    private String apellido;

    @Column(name = "primer_nombre")
    private String nombre;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "tipo_sangre")
    private String tipoSangre;

    @Column(name = "etnia")
    private String etnia;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "discapacidad")
    private String discapacidad;

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Transient
    @JsonProperty("primerNombre")
    public String getPrimerNombre() {
        if (nombre != null && nombre.contains(" ")) {
            return nombre.split(" ")[0];
        }
        return nombre;
    }

    @Transient
    @JsonProperty("segundoNombre")
    public String getSegundoNombre() {
        if (nombre != null && nombre.contains(" ")) {
            String[] partes = nombre.split(" ");
            return partes.length > 1 ? partes[1] : "";
        }
        return "";
    }

    @Transient
    @JsonProperty("primerApellido")
    public String getPrimerApellido() {
        if (apellido != null && apellido.contains(" ")) {
            return apellido.split(" ")[0];
        }
        return apellido;
    }

    @Transient
    @JsonProperty("segundoApellido")
    public String getSegundoApellido() {
        if (apellido != null && apellido.contains(" ")) {
            String[] partes = apellido.split(" ");
            return partes.length > 1 ? partes[1] : "";
        }
        return "";
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }
}
