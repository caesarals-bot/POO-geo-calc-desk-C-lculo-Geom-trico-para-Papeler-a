// src/ui/EsferaPanel.java
package ui;

import model.Esfera;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel para el cálculo de las propiedades de una esfera.
 * Permite al usuario ingresar el radio para calcular el volumen y superficie.
 */
public class EsferaPanel extends FiguraPanel {
    private JTextField txtRadio;

    public EsferaPanel() {
        // Inicializar campo de texto con tooltip descriptivo
        txtRadio = crearCampoNumerico("Radio");
        
        // Configurar tecla Enter para calcular
        configurarTeclaEnter();
    }

    /**
     * Crea un campo de texto con configuración común
     */
    private JTextField crearCampoNumerico(String nombre) {
        JTextField campo = new JTextField(5);  // Reduced from 10 to 5 columns
        campo.setToolTipText("Ingrese el " + nombre.toLowerCase() + " en centímetros");
        campo.setPreferredSize(new Dimension(80, 25));  // Set preferred size
        agregarCampo(nombre, campo);
        return campo;
    }

    /**
     * Configura la tecla Enter para activar el cálculo
     */
    private void configurarTeclaEnter() {
        txtRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularYMostrarResultado();
            }
        });
    }

    @Override
    protected void calcularYMostrarResultado() {
        try {
            // Validar campo vacío
            if (txtRadio.getText().trim().isEmpty()) {
                mostrarError("El campo radio es obligatorio");
                return;
            }

            // Obtener y validar valor
            double radio = Double.parseDouble(txtRadio.getText().trim());

            // Crear esfera y mostrar resultados
            Esfera esfera = new Esfera(radio);
            resultadoArea.setText(String.format(
                "=== Esfera ===\n" +
                "Radio: %.2f cm\n" +
                "Volumen: %.2f cm³\n" +
                "Superficie: %.2f cm²",
                radio,
                esfera.calcularVolumen(),
                esfera.calcularSuperficie()
            ));
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese un valor numérico válido.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @Override
    protected void limpiarCampos() {
        txtRadio.setText("");
        limpiarAreaResultados();
        txtRadio.requestFocusInWindow();
    }

    @Override
    public String getTitulo() {
        return "Esfera";
    }
}