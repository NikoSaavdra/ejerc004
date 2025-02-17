package es.santander.ascender.ejerc002.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Boligrafo")
public class Boligrafo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nombre;
    private String color;
    private boolean escribe;

    public Boligrafo(Object object, String string, String string2, boolean b) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEscribe() {
        return escribe;
    }

    public void setEscribe(boolean escribe) {
        this.escribe = escribe;
    }

}
