// src/ui/Calculadora3DFrame.java
package ui;

import javax.swing.*;

public class Calculadora3DFrame extends JFrame {
    private JTabbedPane tabbedPane;

    public Calculadora3DFrame() {
        // Configuración básica de la ventana
        setTitle("Calculadora de Figuras 3D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);  // Tamaño más grande para mejor visualización
        setLocationRelativeTo(null);  // Centrar en pantalla

        // Inicializar componentes
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        tabbedPane = new JTabbedPane();

        // Agregar paneles para cada figura
        tabbedPane.addTab("Caja", new CajaPanel());
        tabbedPane.addTab("Cilindro", new CilindroPanel());
        tabbedPane.addTab("Esfera", new EsferaPanel());

        add(tabbedPane);
    }

    // Eliminar el método main() ya que no es necesario
    // La ejecución comenzará desde Main.java
}
