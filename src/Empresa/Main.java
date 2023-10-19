package Empresa;

import java.util.GregorianCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

// Clase principal que extiende JFrame para la interfaz gráfica
public class Main extends JFrame {
    // Declaración de paneles y variables
    private JPanel general; // Panel general
    private JPanel panel1; // Primer panel
    private JPanel panel2; // Segundo panel
    private Empleado aux; // Variable de tipo Empleado
    Controlador listado = new Controlador(); // Inicialización de un objeto Controlador
    Controlador.Nodo auxiliar = listado.inicial; // Referencia a un nodo en la lista de Controlador
    private boolean mod; // Variable booleana para controlar el estado de modificación
    private boolean fecha;
    // Constructor de la clase Main
    public Main() {
        mod = false; // Establece la bandera de modificación en falso al principio
        fecha = true;
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        this.setSize(700, 400); // Establece el tamaño de la ventana
        this.setTitle("Mi aplicación de mierda 2"); // Establece el título de la ventana
        setLocationRelativeTo(null); // Establece la ubicación de la ventana en el centro de la pantalla
        iniciarComponentes(); // Inicializa los componentes de la interfaz gráfica
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establece la operación de cierre predeterminada
        this.setVisible(true); // Hace que la ventana sea visible
    }

    // Método para inicializar los componentes de la interfaz gráfica
    private void iniciarComponentes() {
        general = new JPanel(new CardLayout()); // Crea un JPanel con un CardLayout
        this.getContentPane().add(general); // Agrega el JPanel al contenido del JFrame
        panel1 = new JPanel(); // Inicializa el primer JPanel
        panel2 = new JPanel(); // Inicializa el segundo JPanel

// CONTENIDO DEL PANEL 1

// Creación de etiquetas
        JLabel nombre = new JLabel("Nombre:");
        JLabel numero = new JLabel("Número:");
        JLabel sueldo = new JLabel("Sueldo:");
        JLabel sueldoMax = new JLabel("Sueldo Máximo:");

// Creación de campos de texto
        TextField nombreField = new TextField();
        TextField numeroField = new TextField();
        TextField sueldoField = new TextField();
        TextField sueldoMaxField = new TextField();

// Creación de botones
        JButton crear = new JButton("Crear");
        JButton lista = new JButton("Lista");

// Configuración del diseño del panel1
        panel1.setLayout(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(5, 2));

// Agregar componentes al panel de formulario
        formPanel.add(nombre);
        formPanel.add(nombreField);
        formPanel.add(numero);
        formPanel.add(numeroField);
        formPanel.add(sueldo);
        formPanel.add(sueldoField);
        formPanel.add(sueldoMax);
        formPanel.add(sueldoMaxField);
        formPanel.add(crear);
        formPanel.add(lista);
        lista.setEnabled(false); // Deshabilita el botón de lista inicialmente

// Agrega el panel de formulario al centro del panel1
        panel1.add(formPanel, BorderLayout.CENTER);


// CONTENIDO DEL PANEL 2
        JLabel empleadoLabel = new JLabel("Empleado");
        empleadoLabel.setHorizontalAlignment(JLabel.CENTER);
        empleadoLabel.setVerticalAlignment(JLabel.TOP);
        empleadoLabel.setFont(new Font("Arial", Font.BOLD, 40)); // Tamaño de fuente grande

// Panel para la información del empleado
        JPanel infoPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST; // Alinea los componentes a la izquierda
        gbc.insets = new Insets(0, 30, 20, 20); // Añade margen izquierdo y vertical
        gbc.weightx = 1.0; // Hace que los componentes se estiren horizontalmente

// Labels para mostrar la información del empleado
        JLabel nombreLabel = new JLabel("Nombre:");
        JLabel numeroLabel = new JLabel("Número:");
        JLabel sueldoLabel = new JLabel("Sueldo:");
        JLabel sueldoMaxLabel = new JLabel("Sueldo Máximo:");

        JLabel nombreEmpleadoLabel = new JLabel("");
        nombreEmpleadoLabel.setHorizontalAlignment(JLabel.LEFT);
        nombreEmpleadoLabel.setVerticalAlignment(JLabel.CENTER);
        nombreEmpleadoLabel.setFont(new Font("Arial", Font.PLAIN, 15)); // Aumenta el tamaño de fuente

        JLabel numeroEmpleadoLabel = new JLabel("");
        numeroEmpleadoLabel.setHorizontalAlignment(JLabel.LEFT);
        numeroEmpleadoLabel.setVerticalAlignment(JLabel.CENTER);
        numeroEmpleadoLabel.setFont(new Font("Arial", Font.PLAIN, 15)); // Aumenta el tamaño de fuente

        JLabel sueldoEmpleadoLabel = new JLabel("");
        sueldoEmpleadoLabel.setHorizontalAlignment(JLabel.LEFT);
        sueldoEmpleadoLabel.setVerticalAlignment(JLabel.CENTER);
        sueldoEmpleadoLabel.setFont(new Font("Arial", Font.PLAIN, 15)); // Aumenta el tamaño de fuente

        JLabel sueldoMaxEmpleadoLabel = new JLabel("");
        sueldoMaxEmpleadoLabel.setHorizontalAlignment(JLabel.LEFT);
        sueldoMaxEmpleadoLabel.setVerticalAlignment(JLabel.CENTER);
        sueldoMaxEmpleadoLabel.setFont(new Font("Arial", Font.PLAIN, 15)); // Aumenta el tamaño de fuente


        gbc.gridx = 0;
        gbc.gridy = 0;
        infoPanel.add(nombreLabel, gbc);
        gbc.gridy++;
        infoPanel.add(numeroLabel, gbc);
        gbc.gridy++;
        infoPanel.add(sueldoLabel, gbc);
        gbc.gridy++;
        infoPanel.add(sueldoMaxLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        infoPanel.add(nombreEmpleadoLabel, gbc);
        gbc.gridy++;
        infoPanel.add(numeroEmpleadoLabel, gbc);
        gbc.gridy++;
        infoPanel.add(sueldoEmpleadoLabel, gbc);
        gbc.gridy++;
        infoPanel.add(sueldoMaxEmpleadoLabel, gbc);


// Panel para los botones
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 20, 0)); // Se cambia de 3 a 5 para agregar los nuevos botones

// Botones con más tamaño en el eje Y
        JButton nuevoButton = new JButton("Nuevo \uD83E\uDD11");
        nuevoButton.setPreferredSize(new Dimension(nuevoButton.getPreferredSize().width, 60));
        String moaiEmoji = "\uD83D\uDDFF";

        JButton modButton = new JButton("Modificar " + moaiEmoji); // Nuevo botón de Modificar
        modButton.setPreferredSize(new Dimension(modButton.getPreferredSize().width, 60));
        String devilEmoji = "\uD83D\uDC7F"; // Representación Unicode del emoji del diablo morado sonriente

        JButton delButton = new JButton("Eliminar "+ devilEmoji); // Nuevo botón de Eliminar
        delButton.setPreferredSize(new Dimension(delButton.getPreferredSize().width, 60));

        JButton antButton = new JButton("Ant");
        antButton.setPreferredSize(new Dimension(antButton.getPreferredSize().width, 60));

        JButton sigButton = new JButton("Sig");
        sigButton.setPreferredSize(new Dimension(sigButton.getPreferredSize().width, 60));

        JButton ordenarPorFechaButton = new JButton("Fecha ↑");
        ordenarPorFechaButton.setPreferredSize(new Dimension(sigButton.getPreferredSize().width, 60));

// Añade los botones al panel
        buttonPanel.add(nuevoButton);
        buttonPanel.add(modButton);
        buttonPanel.add(delButton);
        buttonPanel.add(antButton);
        buttonPanel.add(sigButton);
        buttonPanel.add(ordenarPorFechaButton);

// Añade los componentes al panel2
        panel2.setLayout(new BorderLayout());
        panel2.add(empleadoLabel, BorderLayout.NORTH);
        panel2.add(infoPanel, BorderLayout.CENTER);
        panel2.add(buttonPanel, BorderLayout.SOUTH);
// ActionListener para el botón de Fecha
        ordenarPorFechaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listado.ordenarPorFechaAlta(!fecha);
                Empleado datos = (Empleado) auxiliar.actual;
                nombreEmpleadoLabel.setText(datos.getNombre());
                numeroEmpleadoLabel.setText(String.valueOf(datos.getNumero()));
                sueldoEmpleadoLabel.setText(String.valueOf(datos.getSueldo()));
                sueldoMaxEmpleadoLabel.setText(String.valueOf(datos.getSueldoMaximo()));
                fecha = !fecha;
                if(fecha){
                    ordenarPorFechaButton.setText("Fecha ↑");
                }else {
                    ordenarPorFechaButton.setText("Fecha ↓");
                }
            }
        });

// ActionListener para el botón de Modificar
        // Agrega un ActionListener al botón modButton
        modButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén los detalles del empleado actual
                Empleado cambio = (Empleado) auxiliar.actual;

                // Establece los campos de texto con los valores del empleado actual
                nombreField.setText(cambio.getNombre());
                numeroField.setText(String.valueOf(cambio.getNumero()));
                sueldoField.setText(String.valueOf(cambio.getSueldo()));
                sueldoMaxField.setText(String.valueOf(cambio.getSueldoMaximo()));

                // Establece el estado de modificación en verdadero
                mod = true;

                // Deshabilita el botón de lista
                lista.setEnabled(false);

                // Cambia al panel1
                CardLayout cardLayout = (CardLayout) general.getLayout();
                cardLayout.show(general, "panel1");

                // Cambia el texto del botón crear a "Modificar"
                crear.setText("Modificar");
            }
        });


// ActionListener para el botón de Eliminar
        // Agrega un ActionListener al botón delButton
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la acción de Eliminar
                // Aquí debes implementar la lógica para la acción de Eliminar

                // Verifica si solo hay un empleado y lo elimina
                if(!listado.inicial.tieneSig()){
                    JOptionPane.showMessageDialog(Main.this, "Se ha eliminado el único empleado existente");

                    listado.inicial = null;
                    listado.ultimo = listado.inicial;
                    auxiliar = listado.inicial;
                    nombreEmpleadoLabel.setText("");
                    numeroEmpleadoLabel.setText("");
                    sueldoEmpleadoLabel.setText("");
                    sueldoMaxEmpleadoLabel.setText("");
                    lista.setEnabled(false);
                    CardLayout cardLayout = (CardLayout) general.getLayout();
                    cardLayout.show(general, "panel1"); // Cambia al panel1
                } else {
                    // Mueve el puntero de lista si es el último elemento
                    if(auxiliar == listado.ultimo) {
                        System.out.println("marimba");
                        listado.ultimo = listado.ultimo.getAnt();
                    }

                    // Elimina el nodo actual de la lista si no es nulo y tiene un nodo anterior
                    if(auxiliar != null && auxiliar.tieneAnt()){
                        auxiliar.getAnt().setSig(auxiliar.getSig());
                        if(auxiliar.tieneSig()){
                            auxiliar.getSig().setAnt(auxiliar.getAnt());
                            auxiliar = auxiliar.getAnt();
                        } else {
                            auxiliar = auxiliar.getAnt();
                            auxiliar.setSig(null);
                        }
                    } else {
                        // Actualiza la referencia de la lista si el nodo a eliminar es el primero
                        if(auxiliar == listado.inicial){
                            listado.inicial = listado.inicial.getSig();
                        }
                        if(auxiliar != null){
                            auxiliar = auxiliar.getSig();
                            auxiliar.setAnt(null);
                        }
                    }

                    // Muestra un mensaje de eliminación exitosa
                    JOptionPane.showMessageDialog(Main.this, "Empleado eliminado satisfactoriamente");
                    // Actualiza los campos de texto si el puntero no es nulo
                    if (auxiliar != null){
                        Empleado datos = (Empleado)auxiliar.actual;
                        nombreEmpleadoLabel.setText(datos.getNombre());
                        numeroEmpleadoLabel.setText(String.valueOf(datos.getNumero()));
                        sueldoEmpleadoLabel.setText(String.valueOf(datos.getSueldo()));
                        sueldoMaxEmpleadoLabel.setText(String.valueOf(datos.getSueldoMaximo()));
                    }
                }

                // Habilita o deshabilita los botones de navegación según sea necesario
                sigButton.setEnabled(auxiliar != null && auxiliar.tieneSig());
                antButton.setEnabled(auxiliar != null && auxiliar.tieneAnt());
            }
        });

        // Agrega un ActionListener al botón lista
        lista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambia al panel2
                CardLayout cardLayout = (CardLayout) general.getLayout();
                cardLayout.show(general, "panel2");

                // Deshabilita el botón antButton
                antButton.setEnabled(false);

                // Verifica si la lista está vacía y ajusta la disponibilidad de los botones en consecuencia
                if(listado.inicial == null){
                    modButton.setEnabled(false);
                    delButton.setEnabled(false);
                } else {
                    modButton.setEnabled(true);
                    delButton.setEnabled(true);
                }

                // Habilita o deshabilita el botón sigButton según sea necesario
                sigButton.setEnabled(listado.inicial.tieneSig());

                // Establece el nodo auxiliar al inicio de la lista
                auxiliar = listado.inicial;
            }
        });


        // Agrega un ActionListener al botón crear
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crea un objeto Empleado con valores predeterminados
                    Empleado e1 = new Empleado("", 0, new GregorianCalendar(), 0, 0);

                    // Verifica si el número ingresado supera el límite
                    if (Integer.parseInt(numeroField.getText()) > 9999) {
                        throw new NumberFormatException();
                    } else if (nombreField.getText().length() > 50) {
                        // Verifica la longitud del nombre y muestra un mensaje si excede el límite
                        JOptionPane.showMessageDialog(Main.this, "El nombre no puede tener más de 50 caracteres.");
                    } else if (nombreField.getText().isEmpty()) {
                        // Verifica si el campo de nombre está vacío y muestra un mensaje de error si es así
                        JOptionPane.showMessageDialog(Main.this, "Debe introducir el nombre para continuar.");
                    } else if (nombreField.getText().matches(".*[^a-zA-Z ].*")) {
                        // Verifica si el campo de nombre contiene caracteres no permitidos y muestra un mensaje de error si es así
                        JOptionPane.showMessageDialog(Main.this, "Introduzca un nombre válido para continuar.");
                    } else if (numeroField.getText().isEmpty()) {
                        // Verifica si el campo de número está vacío y muestra un mensaje de error si es así
                        JOptionPane.showMessageDialog(Main.this, "Debe introducir el número de empleado para continuar.");
                    } else if (listado.numRepe(Integer.parseInt(numeroField.getText())) && !mod) {
                        // Verifica si el número de empleado ya existe y muestra un mensaje de error si es así
                        JOptionPane.showMessageDialog(Main.this, "El código de empleado ya existe. Introduzca uno nuevo.");
                    } else if (sueldoField.getText().isEmpty()) {
                        // Verifica si el campo de sueldo está vacío y muestra un mensaje de error si es así
                        JOptionPane.showMessageDialog(Main.this, "Debe introducir el sueldo para continuar.");
                    } else if (sueldoMaxField.getText().isEmpty()) {
                        // Verifica si el campo de sueldo máximo está vacío y muestra un mensaje de error si es así
                        JOptionPane.showMessageDialog(Main.this, "Debe introducir el sueldo máximo para continuar.");
                    } else if (!esNumero(sueldoField.getText())) {
                        // Verifica si el campo de sueldo no es un número y muestra un mensaje de error si es así
                        JOptionPane.showMessageDialog(Main.this, "Debe introducir un dato numérico en el sueldo para continuar.");
                    } else if (!esNumero(sueldoMaxField.getText())) {
                        // Verifica si el campo de sueldo máximo no es un número y muestra un mensaje de error si es así
                        JOptionPane.showMessageDialog(Main.this, "Debe introducir un dato numérico en el sueldo máximo para continuar.");
                    } else if (Double.parseDouble(sueldoField.getText()) > Double.parseDouble(sueldoMaxField.getText())) {
                        // Verifica si el sueldo es mayor que el sueldo máximo y muestra un mensaje de error si es así
                        JOptionPane.showMessageDialog(Main.this, "El sueldo no puede ser mayor que el sueldo máximo.");
                    } else {
                        if (!mod) {
                            // Lógica para crear un empleado si no se está modificando
                            e1.setNombre((nombreField.getText()));
                            e1.setNumero(Integer.parseInt(numeroField.getText()));
                            e1.setSueldo(Double.parseDouble(sueldoField.getText()));
                            e1.setSueldoMaximo(Double.parseDouble(sueldoMaxField.getText()));
                            listado.insertar(e1);
                            lista.setEnabled(!listado.esVacia());
                            JOptionPane.showMessageDialog(Main.this, "Nuevo empleado introducido en la lista.");
                            // Restablece los campos a sus valores predeterminados
                            nombreField.setText("");
                            numeroField.setText("");
                            sueldoField.setText("");
                            sueldoMaxField.setText("");
                        } else {
                            // Lógica para modificar un empleado si se está modificando
                            Empleado origen = (Empleado) auxiliar.actual;
                            Empleado modificado = new Empleado(nombreField.getText(), Integer.parseInt(numeroField.getText()), new GregorianCalendar(), Double.parseDouble(sueldoField.getText()), Double.parseDouble(sueldoMaxField.getText()));
                            if (listado.modifica(origen, modificado)) {
                                JOptionPane.showMessageDialog(Main.this, "Empleado modificado con éxito");
                                // Restablece los campos a sus valores predeterminados
                                crear.setText("Crear");
                                nombreField.setText("");
                                numeroField.setText("");
                                sueldoField.setText("");
                                sueldoMaxField.setText("");
                                auxiliar = listado.inicial;
                                mod = false;
                                lista.setEnabled(true);
                            } else {
                                JOptionPane.showMessageDialog(Main.this, "No se ha podido modificar el empleado");
                            }
                        }
                        // Verifica si la lista inicial no es nula y establece los valores de los empleados
                        if (listado.inicial != null) {
                            Empleado datos = (Empleado) listado.inicial.actual;
                            nombreEmpleadoLabel.setText(datos.getNombre());
                            numeroEmpleadoLabel.setText(String.valueOf(datos.getNumero()));
                            sueldoEmpleadoLabel.setText(String.valueOf(datos.getSueldo()));
                            sueldoMaxEmpleadoLabel.setText(String.valueOf(datos.getSueldoMaximo()));
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Main.this, "El número no puede ser mayor que 9999");
                }
            }

            // Método estático para verificar si una cadena es un número
            public static boolean esNumero(String cadena) {
                try {
                    Double.parseDouble(cadena);
                    // Si no se produce una excepción, la cadena es un número
                    return true;
                } catch (NumberFormatException e) {
                    // Si se produce una excepción, la cadena no es un número
                    return false;
                }
            }
        });


        // Agrega un ActionListener al botón sigButton
        sigButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica si el auxiliar no es nulo y si tiene un siguiente nodo
                if (auxiliar != null && auxiliar.tieneSig()) {
                    // Avanza al siguiente nodo y actualiza los campos de texto con los datos del empleado
                    auxiliar = auxiliar.getSig();
                    Empleado datos = (Empleado) auxiliar.actual;
                    nombreEmpleadoLabel.setText(datos.getNombre());
                    numeroEmpleadoLabel.setText(String.valueOf(datos.getNumero()));
                    sueldoEmpleadoLabel.setText(String.valueOf(datos.getSueldo()));
                    sueldoMaxEmpleadoLabel.setText(String.valueOf(datos.getSueldoMaximo()));
                    // Habilita el botón antButton
                    antButton.setEnabled(true);
                    // Verifica si el auxiliar no tiene un siguiente nodo y deshabilita el botón sigButton si no lo tiene
                    if (!auxiliar.tieneSig()) {
                        sigButton.setEnabled(false);
                    }
                }
            }
        });

        // Agrega un ActionListener al botón antButton
        antButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica si el auxiliar no es nulo y si tiene un nodo anterior
                if (auxiliar != null && auxiliar.tieneAnt()) {
                    // Retrocede al nodo anterior y actualiza los campos de texto con los datos del empleado
                    auxiliar = auxiliar.getAnt();
                    Empleado datos = (Empleado) auxiliar.actual;
                    nombreEmpleadoLabel.setText(datos.getNombre());
                    numeroEmpleadoLabel.setText(String.valueOf(datos.getNumero()));
                    sueldoEmpleadoLabel.setText(String.valueOf(datos.getSueldo()));
                    sueldoMaxEmpleadoLabel.setText(String.valueOf(datos.getSueldoMaximo()));
                    // Habilita el botón sigButton
                    sigButton.setEnabled(true);
                    // Verifica si el auxiliar no tiene un nodo anterior y deshabilita el botón antButton si no lo tiene
                    if (!auxiliar.tieneAnt()) {
                        antButton.setEnabled(false);
                    }
                }
            }
        });

        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crea una instancia de CardLayout y cambia a la vista del "panel1"
                CardLayout cardLayout = (CardLayout) general.getLayout();
                cardLayout.show(general, "panel1"); // Cambia al panel1
            }
        });

        // Agrega los paneles panel1 y panel2 con sus respectivos nombres asociados
        general.add(panel1, "panel1");
        general.add(panel2, "panel2");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
