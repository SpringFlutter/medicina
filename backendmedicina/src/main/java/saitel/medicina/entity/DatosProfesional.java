package saitel.medicina.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "tbl_datos_profesional")
@Getter
@Setter
public class DatosProfesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fecha;
    private LocalTime hora;

    @Column(name = "nombres_apellidos", length = 150)
    private String nombresApellidos;

    @Column(name = "codigo_profesional", length = 50)
    private String codigoProfesional;

@Column(name = "firma_sello")
    private Boolean firmaSello;
}
