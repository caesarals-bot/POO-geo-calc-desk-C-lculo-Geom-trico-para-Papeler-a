// src/ui/FiguraPanel.java
package ui;

import model.Figura3D;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Clase abstracta que sirve como base para todos los paneles de figuras 3D.
 * Define la estructura común y comportamiento para los paneles de entrada de datos.
 */
public abstract class FiguraPanel extends JPanel {
    protected JTextArea resultadoArea;
    protected JPanel camposPanel;
    protected JButton calcularBtn;
    protected DecimalFormat df;
    private static final Color COLOR_FONDO = new Color(245, 245, 245);

    public FiguraPanel() {
        // Configuración inicial del panel
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(COLOR_FONDO);
        
        // Inicializar componentes
        df = new DecimalFormat("#.##");
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Panel de campos de entrada
        camposPanel = new JPanel();
        camposPanel.setLayout(new GridLayout(0, 2, 5, 3));  // Reducido el espaciado
        camposPanel.setBackground(COLOR_FONDO);
        camposPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));  // Márgenes más pequeños

        // Área de resultados
        resultadoArea = new JTextArea(3, 15);  // Reducido el tamaño
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Monospaced", Font.PLAIN, 11));  // Fuente más pequeña
        resultadoArea.setBackground(Color.WHITE);
        resultadoArea.setMargin(new Insets(2, 2, 2, 2));  // Márgenes internos más pequeños
        resultadoArea.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(2, 2, 2, 2)  // Borde interno más pequeño
        ));

        // Botones
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        botonesPanel.setBackground(COLOR_FONDO);

        calcularBtn = new JButton("Calcular");
        calcularBtn.setFont(calcularBtn.getFont().deriveFont(Font.PLAIN, 11));
        calcularBtn.setBackground(new Color(79, 129, 189));  // Azul
        calcularBtn.setForeground(Color.WHITE);
        calcularBtn.setFocusPainted(false);
        calcularBtn.setBorderPainted(false);
        calcularBtn.setOpaque(true);
        calcularBtn.addActionListener(e -> calcularYMostrarResultado());
        botonesPanel.add(calcularBtn);

        JButton limpiarBtn = new JButton("Limpiar");
        limpiarBtn.setFont(limpiarBtn.getFont().deriveFont(Font.PLAIN, 11));
        limpiarBtn.setBackground(new Color(192, 80, 77));  // Rojo
        limpiarBtn.setForeground(Color.WHITE);
        limpiarBtn.setFocusPainted(false);
        limpiarBtn.setBorderPainted(false);
        limpiarBtn.setOpaque(true);
        limpiarBtn.addActionListener(e -> limpiarCampos());
        botonesPanel.add(limpiarBtn);

        // Crear un panel para agrupar la entrada de datos
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1), 
            "Ingrese los datos de la figura:",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 11),
            new Color(70, 70, 70)
        ));
        inputPanel.setBackground(COLOR_FONDO);
        inputPanel.add(camposPanel, BorderLayout.CENTER);
        
        // Panel para los resultados
        JPanel resultPanel = new JPanel(new BorderLayout(5, 5));
        resultPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1), 
            "Resultados:",
            TitledBorder.LEFT,
            TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 11),
            new Color(70, 70, 70)
        ));
        resultPanel.setBackground(COLOR_FONDO);
        resultPanel.add(new JScrollPane(resultadoArea), BorderLayout.CENTER);
        
        // Panel principal con los componentes
        JPanel centerPanel = new JPanel(new BorderLayout(5, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        centerPanel.setBackground(COLOR_FONDO);
        centerPanel.add(inputPanel, BorderLayout.NORTH);
        centerPanel.add(resultPanel, BorderLayout.CENTER);
        centerPanel.add(botonesPanel, BorderLayout.SOUTH);
        
        // Agregar todo al panel principal
        add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * Agrega un campo de entrada con su etiqueta al panel de campos
     */
    protected void agregarCampo(String etiqueta, JComponent campo) {
        JLabel label = new JLabel(etiqueta + ":");
        label.setFont(label.getFont().deriveFont(Font.PLAIN, 11));
        
        // Configurar el campo de texto
        if (campo instanceof JTextField) {
            JTextField textField = (JTextField) campo;
            textField.setColumns(5);  // Ancho basado en el contenido
            textField.setMaximumSize(new Dimension(80, 22));  // Tamaño máximo
        }
        
        // Configurar el panel del campo
        JPanel fieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        fieldPanel.setBackground(COLOR_FONDO);
        fieldPanel.add(campo);
        
        // Agregar al panel de campos
        camposPanel.add(label);
        camposPanel.add(fieldPanel);
        campo.setToolTipText(String.format("Ingrese el valor de %s en centímetros", etiqueta.toLowerCase()));
    }

    /**
     * Limpia el área de resultados
     */
    protected void limpiarAreaResultados() {
        resultadoArea.setText("");
    }

    /**
     * Muestra un mensaje de error al usuario
     */
    protected void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método abstracto que debe ser implementado por las subclases
     * para limpiar los campos de entrada específicos de cada figura
     */
    protected abstract void limpiarCampos();

    /**
     * Método abstracto que debe ser implementado por las subclases
     * para realizar los cálculos específicos de cada figura
     */
    protected abstract void calcularYMostrarResultado();

    /**
     * @return El título que se mostrará en la pestaña del panel
     */
    public abstract String getTitulo();
}