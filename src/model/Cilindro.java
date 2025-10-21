// src/model/Cilindro.java
package model;

public class Cilindro extends Figura3D {
    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        super("Cilindro");
        validarPositivo(radio, "radio");
        validarPositivo(altura, "altura");
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double calcularVolumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    @Override
    public double calcularSuperficie() {
        return 2 * Math.PI * radio * (radio + altura);
    }

    @Override
    public String toString() {
        return String.format("%s [r=%.2f, h=%.2f]", nombre, radio, altura);
    }
}