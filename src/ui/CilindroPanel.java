// src/ui/CilindroPanel.java
package ui;

import model.Cilindro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel para el cálculo de las propiedades de un cilindro.
 * Permite al usuario ingresar el radio y la altura para calcular el volumen y superficie.
 */
public class CilindroPanel extends FiguraPanel {
    private JTextField txtRadio, txtAltura;

    public CilindroPanel() {
        // Inicializar campos de texto con tooltips descriptivos
        txtRadio = crearCampoNumerico("Radio");
        txtAltura = crearCampoNumerico("Altura");
        
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
        Action enterAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularYMostrarResultado();
            }
        };
        
        txtRadio.addActionListener(enterAction);
        txtAltura.addActionListener(enterAction);
    }

    @Override
    protected void calcularYMostrarResultado() {
        try {
            // Validar campos vacíos
            if (txtRadio.getText().trim().isEmpty() || 
                txtAltura.getText().trim().isEmpty()) {
                mostrarError("Todos los campos son obligatorios");
                return;
            }

            // Obtener y validar valores
            double radio = Double.parseDouble(txtRadio.getText().trim());
            double altura = Double.parseDouble(txtAltura.getText().trim());

            // Crear cilindro y mostrar resultados
            Cilindro cilindro = new Cilindro(radio, altura);
            resultadoArea.setText(String.format(
                "=== Cilindro ===\n" +
                "Radio: %.2f cm, Altura: %.2f cm\n" +
                "Volumen: %.2f cm³\n" +
                "Superficie: %.2f cm²",
                radio, altura,
                cilindro.calcularVolumen(),
                cilindro.calcularSuperficie()
            ));
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese valores numéricos válidos.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @Override
    protected void limpiarCampos() {
        txtRadio.setText("");
        txtAltura.setText("");
        limpiarAreaResultados();
        txtRadio.requestFocusInWindow();
    }

    @Override
    public String getTitulo() {
        return "Cilindro";
    }
}