import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame {

    // Componentes de la interfaz gráfica
    private JTextField nombreField;
    private JTextField apellidoPField;
    private JTextField apellidoMField;
    private JComboBox<String> departamentoCombo;
    private JComboBox<String> antiguedadCombo;
    private JTextArea resultadoArea;

    public Principal() {
        // Configuración de la ventana
        setTitle("Calculadora de Vacaciones");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(new BorderLayout(10, 10)); // Bordes con separación de 10 píxeles
        
        // Panel para el formulario
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS)); // Layout en forma de caja vertical
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Añadir margen alrededor del formulario
        
        // Panel para el botón y el área de resultados
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen interno

        // Inicialización de campos
        nombreField = new JTextField(20);
        apellidoPField = new JTextField(20);
        apellidoMField = new JTextField(20);
        
        // Opciones de departamento
        String[] departamentos = {
            "Atención al Cliente",
            "Departamento de Logística",
            "Departamento de Gerencia"
        };
        departamentoCombo = new JComboBox<>(departamentos);
        
        // Opciones de antigüedad
        String[] antiguedades = {
            "1 año de servicio",
            "2 a 6 años de servicio",
            "7 años o más de servicio"
        };
        antiguedadCombo = new JComboBox<>(antiguedades);
        
        // Área de texto para mostrar resultados
        resultadoArea = new JTextArea(8, 40);
        resultadoArea.setEditable(false);
        resultadoArea.setLineWrap(true);
        resultadoArea.setWrapStyleWord(true);
        resultadoArea.setFont(new Font("Serif", Font.PLAIN, 16));

        // Botón para calcular vacaciones
        JButton calcularButton = new JButton("Calcular Vacaciones");
        calcularButton.setPreferredSize(new Dimension(200, 30)); // Tamaño fijo para el botón
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularVacaciones();
            }
        });

        // Estilo personalizado de los componentes
        setComponentStyles();

        // Agregar campos al formulario
        formPanel.add(createLabelledField("Nombre:", nombreField));
        formPanel.add(createLabelledField("Apellido Paterno:", apellidoPField));
        formPanel.add(createLabelledField("Apellido Materno:", apellidoMField));
        formPanel.add(createLabelledField("Departamento:", departamentoCombo));
        formPanel.add(createLabelledField("Antigüedad:", antiguedadCombo));

        // Agregar botón y resultado
        resultPanel.add(calcularButton, BorderLayout.NORTH);
        resultPanel.add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        // Agregar los paneles a la ventana principal
        add(formPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
    }

    private JPanel createLabelledField(String labelText, JComponent field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(150, 25)); // Tamaño fijo para las etiquetas
        panel.add(label, BorderLayout.WEST);
        panel.add(field, BorderLayout.CENTER);
        return panel;
    }

    private void setComponentStyles() {
        Font font = new Font("Arial", Font.PLAIN, 14);
        
        nombreField.setFont(font);
        apellidoPField.setFont(font);
        apellidoMField.setFont(font);
        departamentoCombo.setFont(font);
        antiguedadCombo.setFont(font);
    }

    public static void main(String[] args) {
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setVisible(true); // Hacer visible la ventana
    }

    private void calcularVacaciones() {
        String nombreTrabajador = nombreField.getText();
        String AP = apellidoPField.getText();
        String AM = apellidoMField.getText();
        String departamento = (String) departamentoCombo.getSelectedItem();
        String antiguedad = (String) antiguedadCombo.getSelectedItem();

        String resultado = calcularVacaciones(nombreTrabajador, AP, AM, departamento, antiguedad);
        resultadoArea.setText(resultado); // Mostrar resultado en el área de texto
    }

    public static String calcularVacaciones(String nombre, String AP, String AM, String departamento, String antiguedad) {
        String resultado = "";

        if (departamento.equals("Atención al Cliente")) {
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 6 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 14 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 20 días de vacaciones.";
            }
        } else if (departamento.equals("Departamento de Logística")) {
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 7 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 15 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 22 días de vacaciones.";
            }
        } else if (departamento.equals("Departamento de Gerencia")) {
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 10 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 20 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 30 días de vacaciones.";
            }
        }

        return resultado;
    }
}
