package saitel.medicina.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_empleado")
public class Empleado {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secEmpleado")
@SequenceGenerator(name = "secEmpleado", sequenceName = "sec_empleado", allocationSize = 1)
@Column(name = "id_empleado")
private Long idEmpleado;
@Column(name = "dni")
private String dni;
@Column(name = "nombre")
private String nombre;
@Column(name = "apellido")
private String apellido;

public Empleado() {}

public Empleado(Long idEmpleado, String dni, String nombre, String apellido) {
    this.idEmpleado = idEmpleado;
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
}
public Long getIdEmpleado() {
return this.idEmpleado;
}
public void setIdEmpleado(Long idEmpleado) {
this.idEmpleado = idEmpleado;
}
public String getDni() {
    return this.dni;
    }
    public void setDni(String dni) {
    this.dni = dni;
    }
public String getNombre() {
return this.nombre;
}
public void setNombre(String nombre) {
this.nombre = nombre;
}
public String getApellido() {
return this.apellido;
}
public void setApellido(String apellido) {
this.apellido = apellido;
}
}