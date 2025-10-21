// src/ui/CajaPanel.java
package ui;

import model.Caja;
import javax.swing.*;
import java.awt.*;

/**
 * Panel para el cálculo de las propiedades de una caja rectangular (prisma rectangular).
 * Permite al usuario ingresar las dimensiones y calcular el volumen y superficie.
 */
public class CajaPanel extends FiguraPanel {
    private JTextField txtLongitud, txtAnchura, txtAltura;

    public CajaPanel() {
        // Inicializar campos de texto con tooltips descriptivos
        txtLongitud = crearCampoNumerico("Longitud");
        txtAnchura = crearCampoNumerico("Anchura");
        txtAltura = crearCampoNumerico("Altura");

        // Configurar tecla Enter para calcular
        configurarTeclaEnter();
    }

    /**
     * Crea un campo de texto con configuración común
     */
    private JTextField crearCampoNumerico(String nombre) {
        JTextField campo = new JTextField(5);  // Reduced from 10 to 5 columns
        campo.setToolTipText("Ingrese la " + nombre.toLowerCase() + " en centímetros");
        campo.setPreferredSize(new Dimension(80, 25));  // Set preferred size
        agregarCampo(nombre, campo);
        return campo;
    }

    /**
     * Configura la tecla Enter para activar el cálculo
     */
    private void configurarTeclaEnter() {
        KeyStroke enter = KeyStroke.getKeyStroke("ENTER");
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(enter, "calcular");
        getActionMap().put("calcular", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                calcularYMostrarResultado();
            }
        });
    }

    @Override
    protected void calcularYMostrarResultado() {
        try {
            // Validar campos vacíos
            if (txtLongitud.getText().trim().isEmpty() || 
                txtAnchura.getText().trim().isEmpty() || 
                txtAltura.getText().trim().isEmpty()) {
                mostrarError("Todos los campos son obligatorios");
                return;
            }

            // Obtener y validar valores
            double longitud = Double.parseDouble(txtLongitud.getText().trim());
            double anchura = Double.parseDouble(txtAnchura.getText().trim());
            double altura = Double.parseDouble(txtAltura.getText().trim());

            // Crear caja y mostrar resultados
            Caja caja = new Caja(longitud, anchura, altura);
            resultadoArea.setText(String.format(
                "=== Caja Rectangular ===\n" +
                "Dimensiones: %.2f x %.2f x %.2f cm\n" +
                "Volumen: %.2f cm³\n" +
                "Superficie: %.2f cm²",
                longitud, anchura, altura,
                caja.calcularVolumen(),
                caja.calcularSuperficie()
            ));
        } catch (NumberFormatException e) {
            mostrarError("Por favor, ingrese valores numéricos válidos.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @Override
    protected void limpiarCampos() {
        txtLongitud.setText("");
        txtAnchura.setText("");
        txtAltura.setText("");
        limpiarAreaResultados();
        txtLongitud.requestFocusInWindow();
    }

    @Override
    public String getTitulo() {
        return "Caja Rectangular";
    }
}