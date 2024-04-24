package com.example.colegioapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity(name = "alumno_grado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoGrado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @Column(name = "seccion", length = 30)
    private String seccion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlumnoGrado that = (AlumnoGrado) o;
        return Objects.equals(id, that.id) && Objects.equals(alumno, that.alumno) && Objects.equals(profesor, that.profesor) && Objects.equals(seccion, that.seccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, alumno, profesor, seccion);
    }

    @Override
    public String toString() {
        return "AlumnoGrado{" +
                "id=" + id +
                ", alumno=" + alumno +
                ", profesor=" + profesor +
                ", seccion='" + seccion + '\'' +
                '}';
    }
}
