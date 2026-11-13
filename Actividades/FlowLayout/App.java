import java.awt.FlowLayout; // Importa el administrador de esquema FlowLayout
import javax.swing.JButton; // Importa el componente de botón
import javax.swing.JFrame; // Importa la clase que representa una ventana
import javax.swing.JLabel; // Importa el componente que muestra texto
import javax.swing.SwingUtilities; // Permite iniciar la interfaz en el hilo de Swing
public class App { // Declara la clase principal del programa.
    private static final String INTEGRANTES = "MAURICIO JAIR CHÁVEZ CALLE - ELIZABETH RUTH MAYTE LEON MAMANI - ALLISON SAMIRA ROJAS ARCANA"; // Integrantes del grupo
    public static void main(String[] args) { // Método principal desde donde inicia la aplicación
        SwingUtilities.invokeLater(() -> { // Ejecuta la creación de las ventanas de forma segura para Swing
            mostrarFlowLayout(); // Abre la ventana que demuestra FlowLayout
        }); // Finaliza la tarea enviada al hilo de Swing
    } // Finaliza el método principal
    private static void mostrarFlowLayout() { // Crea la ventana de demostración de FlowLayout
        JFrame ventana = new JFrame("FlowLayout | Integrantes: " + INTEGRANTES); // Crea la ventana e incluye los integrantes en el título
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Finaliza el programa cuando se cierre la ventana
        ventana.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15)); // Ordena los componentes de izquierda a derecha y permite que pasen a otra fila
        ventana.add(new JLabel("FlowLayout: los componentes se acomodan en filas.")); // Agrega una explicación en la parte superior del contenido
        for (int i = 1; i <= 8; i++) { // Repite ocho veces para crear varios botones
            ventana.add(new JButton("Botón " + i)); // Crea y agrega cada botón a la ventana
        } // Finaliza el ciclo que agrega los ocho botones
        ventana.setSize(500, 300); // Define el ancho y alto de la ventana
        ventana.setLocation(20, 100); // Ubica la ventana en el lado izquierdo de la pantalla
        ventana.setResizable(true); // Permite cambiar el tamaño para observar cómo se reordenan los botones
        ventana.setVisible(true); // Muestra la ventana en pantalla
    } // Finaliza el método que demuestra FlowLayout
} // Finaliza la clase principal App