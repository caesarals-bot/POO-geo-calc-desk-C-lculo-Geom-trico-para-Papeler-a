// src/model/Esfera.java
package model;

public class Esfera extends Figura3D {
    private double radio;

    public Esfera(double radio) {
        super("Esfera");
        validarPositivo(radio, "radio");
        this.radio = radio;
    }

    @Override
    public double calcularVolumen() {
        return (4.0 / 3) * Math.PI * Math.pow(radio, 3);
    }

    @Override
    public double calcularSuperficie() {
        return 4 * Math.PI * Math.pow(radio, 2);
    }

    @Override
    public String toString() {
        return String.format("%s [r=%.2f]", nombre, radio);
    }
}