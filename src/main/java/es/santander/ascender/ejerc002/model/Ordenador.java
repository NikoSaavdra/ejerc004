package es.santander.ascender.ejerc002.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "ordenador")
public class Ordenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0, message = "El peso no puede ser negativo")
    private double peso;

    @Pattern(
        regexp = "^(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9]),(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9]),(25[0-5]|2[0-4][0-9]|1?[0-9]?[0-9])$",
        message = "El color debe ser un código RGB en formato 'R,G,B' con valores entre 0 y 255"
    )
    private String color;

    @Min(value = 0, message = "El número de teclas no puede ser negativo")
    private int numeroTeclas;

    public Ordenador() {}

    public Ordenador(Long id, double peso, String color, int numeroTeclas) {
        this.id = id;
        this.peso = peso;
        this.color = color;
        this.numeroTeclas = numeroTeclas;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getNumeroTeclas() { return numeroTeclas; }
    public void setNumeroTeclas(int numeroTeclas) { this.numeroTeclas = numeroTeclas; }
}
