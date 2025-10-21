// src/service/CalculadoraService.java
package service;

import model.Figura3D;

public class CalculadoraService {
    public String obtenerDetallesFigura(Figura3D figura) {
        return String.format(
                "%s%n- Volumen: %.2f%n- Superficie: %.2f",
                figura, figura.calcularVolumen(), figura.calcularSuperficie()
        );
    }
}