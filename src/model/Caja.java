// src/model/Caja.java
package model;

public class Caja extends Figura3D {
    private double longitud;
    private double anchura;
    private double altura;

    public Caja(double longitud, double anchura, double altura) {
        super("Caja");
        validarPositivo(longitud, "longitud");
        validarPositivo(anchura, "anchura");
        validarPositivo(altura, "altura");
        this.longitud = longitud;
        this.anchura = anchura;
        this.altura = altura;
    }

    @Override
    public double calcularVolumen() {
        return longitud * anchura * altura;
    }

    @Override
    public double calcularSuperficie() {
        return 2 * (longitud * anchura + longitud * altura + anchura * altura);
    }

    @Override
    public String toString() {
        return String.format("%s [%.2f x %.2f x %.2f]",
                nombre, longitud, anchura, altura);
    }
}