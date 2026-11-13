package GridLayout;

import java.awt.GridLayout; // Importa el administrador de esquema GridLayout
import javax.swing.JButton; // Importa el componente de botón
import javax.swing.JFrame; // Importa la clase que representa una ventana
import javax.swing.JLabel; // Importa el componente que muestra texto
import javax.swing.SwingUtilities; // Permite iniciar la interfaz en el hilo de Swing
public class App { // Declara la clase principal del programa
    private static final String INTEGRANTES = "MAURICIO JAIR CHÁVEZ CALLE - ELIZABETH RUTH MAYTE LEON MAMANI - ALLISON SAMIRA ROJAS ARCANA"; // Guarda los nombres de los integrantes
    public static void main(String[] args) { // Método principal del programa
        SwingUtilities.invokeLater(() -> { // Ejecuta la interfaz de forma segura
            mostrarGridLayout(); // Abre la ventana de GridLayout
        }); // Finaliza la tarea del hilo de Swing
    } // Finaliza el método principal
    private static void mostrarGridLayout() { // Crea la ventana de GridLayout
        JFrame ventana = new JFrame("GridLayout | " + INTEGRANTES); // Crea la ventana con los integrantes
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra el programa al cerrar la ventana
        ventana.setLayout(new GridLayout(2, 3, 10, 10)); // Organiza los componentes en dos filas y tres columnas
        ventana.add(new JLabel("GridLayout: cuadrícula", JLabel.CENTER)); // Agrega una explicación
        ventana.add(new JButton("Botón 1")); // Agrega el primer botón
        ventana.add(new JButton("Botón 2")); // Agrega el segundo botón
        ventana.add(new JButton("Botón 3")); // Agrega el tercer botón
        ventana.add(new JButton("Botón 4")); // Agrega el cuarto botón
        ventana.add(new JButton("Botón 5")); // Agrega el quinto botón
        ventana.setSize(600, 350); // Establece el tamaño de la ventana
        ventana.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        ventana.setResizable(true); // Permite cambiar el tamaño de la ventana
        ventana.setVisible(true); // Muestra la ventana
    } // Finaliza el método GridLayout
} // Finaliza la clase App