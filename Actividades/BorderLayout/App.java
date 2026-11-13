package BorderLayout;

import java.awt.BorderLayout; // Importa el administrador de esquema BorderLayout
import javax.swing.JButton; // Importa el componente de botón
import javax.swing.JFrame; // Importa la clase que representa una ventana
import javax.swing.JLabel; // Importa el componente que muestra texto
import javax.swing.SwingUtilities; // Permite iniciar la interfaz en el hilo de Swing
public class App { // Declara la clase principal del programa
    private static final String INTEGRANTES = "MAURICIO JAIR CHÁVEZ CALLE - ELIZABETH RUTH MAYTE LEON MAMANI - ALLISON SAMIRA ROJAS ARCANA"; // Guarda los nombres de los integrantes
    public static void main(String[] args) { // Método principal del programa
        SwingUtilities.invokeLater(() -> { // Ejecuta la interfaz de forma segura
            mostrarBorderLayout(); // Abre la ventana de BorderLayout
        }); // Finaliza la tarea del hilo de Swing
    } // Finaliza el método principal
    private static void mostrarBorderLayout() { // Crea la ventana de BorderLayout
        JFrame ventana = new JFrame("BorderLayout | " + INTEGRANTES); // Crea la ventana con los integrantes
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra el programa al cerrar la ventana
        ventana.setLayout(new BorderLayout(10, 10)); // Divide la ventana en cinco regiones con espacios
        ventana.add(new JLabel("NORTH - Parte superior", JLabel.CENTER), BorderLayout.NORTH); // Agrega un texto en la región norte
        ventana.add(new JButton("SOUTH"), BorderLayout.SOUTH); // Agrega un botón en la región sur
        ventana.add(new JButton("EAST"), BorderLayout.EAST); // Agrega un botón en la región este
        ventana.add(new JButton("WEST"), BorderLayout.WEST); // Agrega un botón en la región oeste
        ventana.add(new JButton("CENTER"), BorderLayout.CENTER); // Agrega un botón en la región central
        ventana.setSize(650, 400); // Establece el tamaño de la ventana
        ventana.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        ventana.setVisible(true); // Muestra la ventana
    } // Finaliza el método BorderLayout
} // Finaliza la clase App