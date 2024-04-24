package com.example.colegioapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "genero")
    private String genero;

    @Column(name = "fecha_nacimiento")
    private Date fecNac;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(id, alumno.id) && Objects.equals(nombres, alumno.nombres) && Objects.equals(apellidos, alumno.apellidos) && Objects.equals(genero, alumno.genero) && Objects.equals(fecNac, alumno.fecNac);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombres, apellidos, genero, fecNac);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", genero='" + genero + '\'' +
                ", fecNac=" + fecNac +
                '}';
    }
}
