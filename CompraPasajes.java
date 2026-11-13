package lab9; 

import javax.swing.*; // Importa componentes de la interfaz gráfica de Swing
import java.awt.*; // Importa las clases para el manejo de diseño y colores 
import java.awt.event.*; // Importa las clases para manejar eventos de usuario 

public class CompraPasajes extends JFrame { // Declara la clase principal que hereda de JFrame para crear la ventana

    // DECLARACION DE COMPONENTES
    // Datos del pasajero
    JLabel lblTitulo, lblNombre, lblDni, lblFecha; // Declara las etiquetas de texto para el título y los datos del pasajero
    JTextField txtNombre, txtDni, txtFecha; // Declara los campos de texto para ingresar nombre, DNI y fecha

    // Datos del viaje
    JLabel lblOrigen, lblDestino; // Declara las etiquetas para la ciudad de origen y destino
    JComboBox<String> cboOrigen, cboDestino; // Declara los menus desplegables para seleccionar las ciudades

    // Piso
    JLabel lblPiso; // Declara la etiqueta para la selección del piso
    JRadioButton rbPrimerPiso, rbSegundoPiso; // Declara los botones de opcion para el piso del autobus
    ButtonGroup grupoPiso; // Declara el grupo para unir los botones de opcion y que solo se seleccione uno

    // Servicios
    JLabel lblServicios; // Declara la etiqueta para los servicios adicionales
    JCheckBox chkAudifonos, chkManta, chkRevistas; // Declara las casillas de verificacion para los servicios

    // Calidad
    JLabel lblCalidad; // Declara la etiqueta para la calidad del servicio
    JList<String> lstCalidad; // Declara una lista para seleccionar la categoria de calidad

    // Botones
    JButton btnRegistrar, btnLimpiar, btnSalir; // Declara los botones de accion del sistema

    public CompraPasajes() { // Constructor de la clase que inicializa la ventana y sus componentes

        setTitle("Sistema de Compra de Pasajes"); // Establece el título de la ventana
        setSize(620, 740); // Define el ancho y alto de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la acción al cerrar la ventana para finalizar el programa
        setLocationRelativeTo(null); // Centra la ventana en el medio de la pantalla
        setResizable(false); // Evita que el usuario pueda cambiar el tamaño de la ventana

        // Panel principal
        JPanel panel = new JPanel(); // Crea un nuevo panel principal contenedor
        panel.setLayout(null); // Desactiva el diseño automático para usar coordenadas absolutas (null layout)
        panel.setBackground(new Color(240, 244, 248)); // Establece un color de fondo personalizado (gris muy claro azulado)

        // Titulo principal
        lblTitulo = new JLabel("SISTEMA DE COMPRA DE PASAJES"); // Inicializa la etiqueta con el texto del título principal
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22)); // Define la fuente, estilo negrita y tamaño del título
        lblTitulo.setForeground(new Color(25, 55, 90)); // Define el color del texto del título
        lblTitulo.setBounds(100, 15, 450, 35); // Establece la posición (x, y) y dimensiones (ancho, alto) del título
        panel.add(lblTitulo); // Agrega la etiqueta del título al panel principal

        //DATOS DEL PASAJERO

        JPanel panelPasajero = new JPanel(); // Crea un panel secundario para agrupar los datos del pasajero
        panelPasajero.setLayout(null); // Establece diseño nulo para posicionar libremente sus elementos internos
        panelPasajero.setBackground(Color.WHITE); // Cambia el fondo del panel a blanco
        panelPasajero.setBorder( // Crea un borde con título alrededor del panel
            BorderFactory.createTitledBorder("Datos del pasajero")
        );
        panelPasajero.setBounds(25, 65, 555, 145); // Define la posicion y tamaño del panel dentro de la ventana
        panel.add(panelPasajero); // Agrega el panel de pasajero al panel principal

        lblNombre = new JLabel("Nombre completo:"); // Inicializa la etiqueta del nombre
        lblNombre.setBounds(20, 30, 130, 25); // Posiciona la etiqueta del nombre
        panelPasajero.add(lblNombre); // Añade la etiqueta al panel de pasajero

        txtNombre = new JTextField(); // Inicializa el campo de texto para el nombre
        txtNombre.setBounds(160, 30, 350, 28); // Posiciona y da tamaño al campo de texto del nombre
        panelPasajero.add(txtNombre); // Añade el campo de texto al panel de pasajero

        lblDni = new JLabel("DNI:"); // Inicializa la etiqueta del DNI
        lblDni.setBounds(20, 70, 130, 25); // Posiciona la etiqueta del DNI
        panelPasajero.add(lblDni); // Añade la etiqueta al panel de pasajero

        txtDni = new JTextField(); // Inicializa el campo de texto para el DNI
        txtDni.setBounds(160, 70, 350, 28); // Posiciona y da tamaño al campo de texto del DNI
        panelPasajero.add(txtDni); // Añade el campo de texto al panel de pasajero

        lblFecha = new JLabel("Fecha de viaje:"); // Inicializa la etiqueta de la fecha de viaje
        lblFecha.setBounds(20, 110, 130, 25); // Posiciona la etiqueta de la fecha
        panelPasajero.add(lblFecha); // Añade la etiqueta al panel de pasajero

        txtFecha = new JTextField(); // Inicializa el campo de texto para la fecha
        txtFecha.setBounds(160, 110, 350, 28); // Posiciona y da tamaño al campo de texto de la fecha
        txtFecha.setToolTipText("Formato: dd/mm/aaaa"); // Muestra una pista emergente con el formato correcto al pasar el cursor
        panelPasajero.add(txtFecha); // Añade el campo de texto al panel de pasajero

        // INFORMACION DEL VIAJE

        JPanel panelViaje = new JPanel(); // Crea un panel secundario para los datos del viaje
        panelViaje.setLayout(null); // Establece diseño nulo para posicionamiento manual
        panelViaje.setBackground(Color.WHITE); // Define el color de fondo como blanco
        panelViaje.setBorder( // Añade un borde con título alusivo a la información del viaje
            BorderFactory.createTitledBorder("Informacion del viaje")
        );
        panelViaje.setBounds(25, 220, 555, 110); // Posiciona el panel de viaje en la ventana
        panel.add(panelViaje); // Añade el panel de viaje al panel principal

        lblOrigen = new JLabel("Ciudad de origen:"); // Inicializa la etiqueta de origen
        lblOrigen.setBounds(20, 30, 130, 25); // Posiciona la etiqueta de origen
        panelViaje.add(lblOrigen); // Añade la etiqueta al panel de viaje

        String[] ciudades = { // Arreglo con los nombres de las ciudades disponibles
            "Arequipa", "Lima", "Cusco", "Puno", "Tacna", "Moquegua"
        };

        cboOrigen = new JComboBox<>(ciudades); // Inicializa el ComboBox con el arreglo de ciudades
        cboOrigen.setBounds(160, 30, 350, 28); // Posiciona el ComboBox de origen
        panelViaje.add(cboOrigen); // Añade el ComboBox al panel de viaje

        lblDestino = new JLabel("Ciudad de destino:"); // Inicializa la etiqueta de destino
        lblDestino.setBounds(20, 70, 130, 25); // Posiciona la etiqueta de destino
        panelViaje.add(lblDestino); // Añade la etiqueta al panel de viaje

        cboDestino = new JComboBox<>(ciudades); // Inicializa el ComboBox de destino con las mismas ciudades
        cboDestino.setBounds(160, 70, 350, 28); // Posiciona el ComboBox de destino
        cboDestino.setSelectedIndex(1); // Selecciona por defecto el segundo elemento del arreglo ("Lima")
        panelViaje.add(cboDestino); // Añade el ComboBox al panel de viaje

        // PISO DEL AUTOBUS

        JPanel panelPiso = new JPanel(); // Crea un panel para seleccionar el piso del autobús
        panelPiso.setLayout(null); // Establece diseño nulo
        panelPiso.setBackground(Color.WHITE); // Cambia el color de fondo a blanco
        panelPiso.setBorder( // Crea un borde titulado para la ubicación del pasajero
            BorderFactory.createTitledBorder("Ubicacion del pasajero")
        );
        panelPiso.setBounds(25, 340, 555, 80); // Posiciona el panel en la ventana
        panel.add(panelPiso); // Agrega el panel al panel principal

        lblPiso = new JLabel("Seleccione el piso:"); // Inicializa la etiqueta del piso
        lblPiso.setBounds(20, 30, 140, 25); // Posiciona la etiqueta del piso
        panelPiso.add(lblPiso); // Añade la etiqueta al panel de piso

        rbPrimerPiso = new JRadioButton("Primer piso"); // Crea el botón de opción para el primer piso
        rbPrimerPiso.setBounds(180, 30, 120, 25); // Posiciona el botón del primer piso
        rbPrimerPiso.setBackground(Color.WHITE); // Establece el fondo del botón en blanco
        panelPiso.add(rbPrimerPiso); // Añade el botón al panel de piso

        rbSegundoPiso = new JRadioButton("Segundo piso"); // Crea el botón de opción para el segundo piso
        rbSegundoPiso.setBounds(320, 30, 140, 25); // Posiciona el botón del segundo piso
        rbSegundoPiso.setBackground(Color.WHITE); // Establece el fondo del botón en blanco
        panelPiso.add(rbSegundoPiso); // Añade el botón al panel de piso

        grupoPiso = new ButtonGroup(); // Crea un grupo de botones para vincular las opciones
        grupoPiso.add(rbPrimerPiso); // Añade el botón de primer piso al grupo lógico
        grupoPiso.add(rbSegundoPiso); // Añade el botón de segundo piso al grupo lógico

        rbPrimerPiso.setSelected(true); // Marca por defecto la opción del primer piso como seleccionada

        // SERVICIOS ADICIONALES

        JPanel panelServicios = new JPanel(); // Crea un panel para los servicios adicionales
        panelServicios.setLayout(null); // Establece diseño nulo
        panelServicios.setBackground(Color.WHITE); // Cambia el fondo a blanco
        panelServicios.setBorder( // Crea un borde titulado para los servicios
            BorderFactory.createTitledBorder("Servicios adicionales")
        );
        panelServicios.setBounds(25, 430, 555, 90); // Posiciona el panel en la ventana
        panel.add(panelServicios); // Agrega el panel al panel principal

        chkAudifonos = new JCheckBox("Audifonos"); // Crea la casilla de verificación para audífonos
        chkAudifonos.setBounds(30, 35, 120, 25); // Posiciona la casilla de audífonos
        chkAudifonos.setBackground(Color.WHITE); // Establece fondo blanco
        panelServicios.add(chkAudifonos); // Añade la casilla al panel de servicios

        chkManta = new JCheckBox("Manta"); // Crea la casilla de verificación para manta
        chkManta.setBounds(190, 35, 100, 25); // Posiciona la casilla de manta
        chkManta.setBackground(Color.WHITE); // Establece fondo blanco
        panelServicios.add(chkManta); // Añade la casilla al panel de servicios

        chkRevistas = new JCheckBox("Revistas"); // Crea la casilla de verificación para revistas
        chkRevistas.setBounds(350, 35, 120, 25); // Posiciona la casilla de revistas
        chkRevistas.setBackground(Color.WHITE); // Establece fondo blanco
        panelServicios.add(chkRevistas); // Añade la casilla al panel de servicios

        //CALIDAD DEL SERVICIO

        JPanel panelCalidad = new JPanel(); // Crea un panel para la calidad del servicio
        panelCalidad.setLayout(null); // Establece diseño nulo
        panelCalidad.setBackground(Color.WHITE); // Cambia el fondo a blanco
        panelCalidad.setBorder( // Crea un borde titulado para la calidad del servicio
            BorderFactory.createTitledBorder("Calidad del servicio")
        );
        panelCalidad.setBounds(25, 530, 555, 90); // Posiciona el panel en la ventana
        panel.add(panelCalidad); // Agrega el panel al panel principal

        lblCalidad = new JLabel("Seleccione una categoria:"); // Inicializa la etiqueta de categoría
        lblCalidad.setBounds(20, 30, 180, 25); // Posiciona la etiqueta de categoría
        panelCalidad.add(lblCalidad); // Añade la etiqueta al panel de calidad

        String[] calidades = { // Arreglo con las opciones de calidad del servicio
            "Economico", "Standard", "VIP"
        };

        lstCalidad = new JList<>(calidades); // Inicializa la lista JList con las opciones de calidad
        lstCalidad.setSelectionMode( // Configura la lista para permitir seleccionar solo un elemento a la vez
            ListSelectionModel.SINGLE_SELECTION
        );
        lstCalidad.setSelectedIndex(0); // Selecciona por defecto el primer elemento ("Economico")

        JScrollPane scroll = new JScrollPane(lstCalidad); // Envuelve la lista en un JScrollPane para 
        //añadir una barra de desplazamiento si es necesario
        scroll.setBounds(210, 20, 250, 60); // Posiciona y da tamaño al componente con scroll
        panelCalidad.add(scroll); // Añade el scroll (con la lista dentro) al panel de calidad

        // BOTONES

        btnRegistrar = new JButton("Registrar"); // Inicializa el botón registrar
        btnRegistrar.setBounds(75, 635, 135, 35); // Posiciona y da tamaño al botón registrar
        btnRegistrar.setBackground(new Color(30, 100, 170)); // Cambia el color de fondo del botón a azul
        btnRegistrar.setForeground(Color.WHITE); // Cambia el color del texto del botón a blanco
        panel.add(btnRegistrar); // Añade el botón al panel principal

        btnLimpiar = new JButton("Limpiar"); // Inicializa el botón limpiar
        btnLimpiar.setBounds(240, 635, 135, 35); // Posiciona y da tamaño al botón limpiar
        panel.add(btnLimpiar); // Añade el botón al panel principal

        btnSalir = new JButton("Salir"); // Inicializa el botón salir
        btnSalir.setBounds(405, 635, 135, 35); // Posiciona y da tamaño al botón salir
        panel.add(btnSalir); // Añade el botón al panel principal

        // EVENTOS DE LOS BOTONES

        btnRegistrar.addActionListener(new ActionListener() { // Añade un escuchador de eventos al botón Registrar
            public void actionPerformed(ActionEvent e) {
                registrarPasaje(); // Llama al método encargado de validar y registrar los datos al hacer clic
            }
        });
        btnLimpiar.addActionListener(new ActionListener() { // Añade un escuchador de eventos al botón Limpiar
            public void actionPerformed(ActionEvent e) {
                limpiarCampos(); // Llama al método para restablecer los campos al hacer clic
            }
        });
        btnSalir.addActionListener(new ActionListener() { // Añade un escuchador de eventos al botón Salir
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog( // Muestra un cuadro de diálogo de confirmación para salir
                    null,
                    "¿Desea salir del sistema?", "Confirmar salida",
                    JOptionPane.YES_NO_OPTION
                );
                if (respuesta == JOptionPane.YES_OPTION) { // Evalúa si el usuario hizo clic en "Sí"
                    System.exit(0); // Cierra completamente la aplicación
                }
            }
        });
        add(panel); // Añade el panel principal a la ventana (JFrame)
        setVisible(true); // Hace visible la ventana en la pantalla
    }

    // METODO PARA REGISTRAR

    public void registrarPasaje() { // Método que procesa la validación y generación del resumen de compra

        String nombre = txtNombre.getText().trim(); // Obtiene el texto del campo nombre y elimina espacios sobrantes
        String dni = txtDni.getText().trim(); // Obtiene el texto del campo DNI y elimina espacios sobrantes
        String fecha = txtFecha.getText().trim(); // Obtiene el texto del campo fecha y elimina espacios sobrantes

        if (nombre.isEmpty() || dni.isEmpty() || fecha.isEmpty()) { // Comprueba si alguno de los campos principales está vacío
            JOptionPane.showMessageDialog( // Muestra una advertencia flotante indicando que faltan datos
                this,
                "Complete todos los datos del pasajero.", "Advertencia",
                JOptionPane.WARNING_MESSAGE
            );
            return; // Detiene la ejecución del método si hay campos vacíos
        }
        // Validar DNI
        if (!dni.matches("[0-9]{8}")) { // Comprueba mediante expresión regular si el DNI tiene exactamente 8 dígitos numéricos
            JOptionPane.showMessageDialog( // Muestra un mensaje de error si el DNI no es válido
                this,
                "El DNI debe contener exactamente 8 digitos.", "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return; 
        }
        // Validar fecha
        if (!fecha.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) { // Valida mediante expresión regular el formato dd/mm/aaaa de la fecha
            JOptionPane.showMessageDialog( // Muestra un mensaje de error si el formato de fecha es incorrecto
                this,
                "Ingrese la fecha en formato dd/mm/aaaa.", "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return; 
        }
        // Validar origen y destino
        String origen = cboOrigen.getSelectedItem().toString(); // Obtiene la ciudad de origen seleccionada
        String destino = cboDestino.getSelectedItem().toString(); // Obtiene la ciudad de destino seleccionada

        if (origen.equals(destino)) { // Comprueba si el origen y el destino son idénticos
            JOptionPane.showMessageDialog( // Muestra un mensaje de error si son iguales
                this,
                "El origen y destino no pueden ser iguales.", "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return; 
        }

        // Obtener piso
        String piso = ""; // Declara una variable para almacenar el piso seleccionado

        if (rbPrimerPiso.isSelected()) { // Verifica si se seleccionó el primer piso
            piso = "Primer piso"; // Asigna el texto correspondiente
        } else {
            piso = "Segundo piso"; // De lo contrario, asigna el segundo piso
        }

        // Obtener servicios
        String servicios = ""; // Declara una cadena vacía para concatenar los servicios adicionales
        if (chkAudifonos.isSelected()) { // Si la casilla de audífonos está marcada
            servicios += "Audifonos, "; // Los añade a la lista de servicios
        }
        if (chkManta.isSelected()) { // Si la casilla de manta está marcada
            servicios += "Manta, "; // Los añade a la lista de servicios
        }
        if (chkRevistas.isSelected()) { // Si la casilla de revistas está marcada
            servicios += "Revistas, "; // Los añade a la lista de servicios
        }

        if (servicios.equals("")) { // Si no se seleccionó ningún servicio
            servicios = "Ninguno"; // Establece el texto como "Ninguno"
        } else {
            servicios = servicios.substring( // Remueve la última coma y espacio sobrantes de la cadena concatenada
                0, servicios.length() - 2
            );
        }

        // Obtener calidad
        String calidad = lstCalidad.getSelectedValue(); // Obtiene el valor seleccionado de la lista de calidad

        if (calidad == null) { // Valida si el usuario no seleccionó ninguna opción de calidad
            JOptionPane.showMessageDialog(
                this,
                "Seleccione una calidad de servicio."
            );
            return; 
        }

        // Construir resumen
        String resumen = // Construye un texto estructurado con toda la información consolidada de la compra
            "========== PASAJE REGISTRADO ==========\n\n" +
            "DATOS DEL PASAJERO\n" +
            "Nombre: " + nombre + "\n" +
            "DNI: " + dni + "\n" +
            "Fecha: " + fecha + "\n\n" +
            "DATOS DEL VIAJE\n" +
            "Origen: " + origen + "\n" +
            "Destino: " + destino + "\n" +
            "Piso: " + piso + "\n\n" +
            "SERVICIOS ADICIONALES\n" +
            servicios + "\n\n" +
            "Calidad: " + calidad + "\n\n" +
            "¡Gracias por viajar con nosotros!";

        JOptionPane.showMessageDialog( // Muestra una ventana emergente informativa con el resumen detallado del pasaje
            this,
            resumen,
            "Resumen de compra",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    // METODO PARA LIMPIAR

    public void limpiarCampos() { // Método para restablecer el formulario a sus valores iniciales

        txtNombre.setText(""); // Vacía el campo de texto del nombre
        txtDni.setText(""); // Vacía el campo de texto del DNI
        txtFecha.setText(""); // Vacía el campo de texto de la fecha

        cboOrigen.setSelectedIndex(0); // Restablece el ComboBox de origen al primer elemento
        cboDestino.setSelectedIndex(1); // Restablece el ComboBox de destino al segundo elemento por defecto

        rbPrimerPiso.setSelected(true); // Selecciona por defecto el botón del primer piso

        chkAudifonos.setSelected(false); // Desmarca la casilla de audífonos
        chkManta.setSelected(false); // Desmarca la casilla de manta
        chkRevistas.setSelected(false); // Desmarca la casilla de revistas

        lstCalidad.setSelectedIndex(0); // Restablece la lista de calidad al primer elemento

        JOptionPane.showMessageDialog( // Muestra un mensaje informando que la limpieza se realizó con éxito
            this,
            "Los campos se han limpiado correctamente.",
            "Sistema de pasajes",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) { // Método principal de ejecución de la aplicación Java
        new CompraPasajes(); // Instancia y lanza la ventana principal del sistema
    }
}
