// src/model/Figura3D.java
package model;

public abstract class Figura3D {  // Añadido 'abstract'
    protected String nombre;

    public Figura3D(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularVolumen();
    public abstract double calcularSuperficie();

    protected void validarPositivo(double valor, String nombreParametro) {
        if (valor <= 0) {
            throw new IllegalArgumentException(
                    String.format("El valor de %s debe ser mayor que cero", nombreParametro)
            );
        }
    }

    @Override
    public String toString() {
        return String.format("%s [Volumen=%.2f, Superficie=%.2f]",
                nombre, calcularVolumen(), calcularSuperficie());
    }
}