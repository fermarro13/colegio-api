package com.example.colegioapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "nombre", length = 200)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grado grado = (Grado) o;
        return Objects.equals(id, grado.id) && Objects.equals(nombre, grado.nombre) && Objects.equals(profesor, grado.profesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, profesor);
    }

    @Override
    public String toString() {
        return "Grado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", profesor=" + profesor +
                '}';
    }
}
