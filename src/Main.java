// src/Main.java
import ui.Calculadora3DFrame;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Asegurarse de que la interfaz gráfica se ejecute en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            try {
                // Establecer el aspecto de la interfaz según el sistema operativo
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                // Crear y mostrar la ventana principal
                Calculadora3DFrame frame = new Calculadora3DFrame();
                frame.setVisible(true);

            } catch (Exception e) {
                // Manejar cualquier error inesperado
                JOptionPane.showMessageDialog(
                        null,
                        "Error al iniciar la aplicación: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                e.printStackTrace();
            }
        });
    }
}