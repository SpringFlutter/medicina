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
@Table(name = "tbl_revision_organos_sistemas")
@Getter
@Setter
public class RevisionOrganosSistemas {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_revision")
    private Integer idRevision;
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Column(name = "ojos")
    private String ojos;
    @Column(name = "oidos")
    private String oidos;
    @Column(name = "nariz")
    private String nariz;
    @Column(name = "garganta")
    private String garganta;
    @Column(name = "torax")
    private String torax;
    @Column(name = "abdomen")
    private String abdomen;
    @Column(name = "miembros")
    private String miembros;
    @Column(name = "piel")
    private String piel;
    @Column(name = "neurologico")
    private String neurologico;
}
