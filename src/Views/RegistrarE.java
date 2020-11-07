/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import BD.usuarioEmpresarialBD;
import Formatos.JTextFieldHint;
import Models.usuarioEmpresarial;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



/**
 *
 * @author DaveDarko
 */
public class RegistrarE extends JFrame {

    JLabel nombre = new JLabel("Nombre: ");
    JTextField Nombre = new JTextField();
    JLabel apPa = new JLabel("Apellido Paterno: ");
    JTextField paterno = new JTextField();
    JLabel apMa = new JLabel("Apellido Materno: ");
    JTextField materno = new JTextField();
    JLabel fechNa = new JLabel("Fecha de Nacimiento: ");
    JTextFieldHint nacimiento = new JTextFieldHint();
    JLabel correo = new JLabel("Correo: ");
    JTextField Co = new JTextField();
    JLabel tel = new JLabel("Telefono: ");
    JTextField Telefono = new JTextField();
    JLabel pass = new JLabel("Contraseña: ");
    JPasswordField password = new JPasswordField();
    JLabel empr = new JLabel("Empresa: ");
    JComboBox empresa = new JComboBox();
    
    String Empre = "";
    int empF = 0;
    
    java.sql.Date sqlDate;
    JButton Registrar = new JButton("Registrarse");

    public RegistrarE() {
        setTitle("Crear");
        //tamaño de la ventana
        setSize(1000, 703);
        setBackground(new Color(0x255664));
        //Se podra redimencionar
        setResizable(false);
        //Localizacion
        setLocationRelativeTo(null);
        //Salir
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Design();
        //Agregamos Fondo
        //this.setContentPane();
        //Crear la interfaz
    }

    private void Design() {
        JPanel Fondo = new JPanel();
        Fondo.setLayout(null);
        Fondo.setBackground(new Color(0x7B9AAC));
        add(Fondo);

        JPanel Datos = new JPanel();
        Datos.setLayout(null);
        Datos.setBounds(50, 80, 900, 500);
        Datos.setBackground(new Color(0xB1C4CF));
        Fondo.add(Datos);
        
        JPanel TituloP = new JPanel();
        TituloP.setLayout(null);
        TituloP.setBounds(50,20,900, 70);
        Fondo.add(TituloP);
        
        JLabel Titulo = new JLabel("USUARIO EMPRESARIAL");
        Titulo.setBounds(250,10,400,50);
        Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Titulo.setBackground(Color.red);
        Titulo.setFont(new Font("Segoe UI Light", 1, 30));
        TituloP.add(Titulo);
        //nombre
        nombre.setBounds(200, 7, 300, 30);
        nombre.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombre.setForeground(Color.GRAY);
        
        Nombre.setBounds(200, 35, 500, 30);
        Nombre.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Datos.add(nombre);
        Datos.add(Nombre);
        //Apellido Pat
        apPa.setBounds(200, 67, 300, 30);
        apPa.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        apPa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        apPa.setForeground(Color.GRAY);
        paterno.setBounds(200, 95, 500, 30);
        paterno.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        paterno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Datos.add(apPa);
        Datos.add(paterno);
        //Apellido Mat
        apMa.setBounds(200, 127, 300, 30);
        apMa.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        apMa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        apMa.setForeground(Color.GRAY);
        materno.setBounds(200, 155, 500, 30);
        materno.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        materno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Datos.add(apMa);
        Datos.add(materno);
        //Fecha Nacimiento
        fechNa.setBounds(200, 187, 300, 30);
        fechNa.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        fechNa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fechNa.setForeground(Color.GRAY);
        nacimiento.setHint("AAAA-MM-DD");
        nacimiento.setBounds(200, 215, 500, 30);
        nacimiento.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        nacimiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Datos.add(fechNa);
        Datos.add(nacimiento);
        //correo
        correo.setBounds(200, 247, 300, 30);
        correo.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        correo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correo.setForeground(Color.GRAY);
        Co.setBounds(200, 275, 500, 30);
        Co.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        Co.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Datos.add(correo);
        Datos.add(Co);
        //Telefono
        tel.setBounds(200, 307, 300, 30);
        tel.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        tel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tel.setForeground(Color.GRAY);
        Telefono.setBounds(200, 335, 500, 30);
        Telefono.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        Telefono.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Datos.add(tel);
        Datos.add(Telefono);
        //Contraseña
        pass.setBounds(200, 367, 300, 30);
        pass.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        pass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pass.setForeground(Color.GRAY);
        password.setBounds(200, 395, 500, 30);
        password.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Datos.add(pass);
        Datos.add(password);
        //Empresa
        empr.setBounds(200, 427, 300, 30);
        empr.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        empr.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        empr.setForeground(Color.GRAY);

        // Creacion del JComboBox y añadir los items.
        empresa.setBounds(200, 455, 500, 30);
        empresa.setFont(new java.awt.Font("Segoe UI Light", 1, 20));
        //empresa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        empresa.setForeground(Color.black);
        empresa.addItem("Seleccionar");
        empresa.addItem("IBU");
        empresa.addItem("Timbo");
        empresa.addItem("CETI Colomos");
        empresa.addItem("Tierra y Armonia");
        empresa.addItem("Marzan");
        empresa.addItem("Maria Pasteleria");
        empresa.addItem("TEC Milenio");
        empresa.addItem("CODE");
        empresa.addItem("Medicinas Rosario");
        empresa.addItem("Microsoft México");
        empresa.addItem("Google México");
        empresa.addActionListener((ActionEvent e) -> {
            Empre = empresa.getSelectedItem().toString();
            if ("IBM".equals(Empre)) {empF = 3;}
            if ("Bimbo".equals(Empre)) {empF = 4;}
            if ("CETI Colomos".equals(Empre)) {empF = 5;}
            if ("Tierra y Armonia".equals(Empre)) {empF = 6;}
            if ("Marzan".equals(Empre)) {empF = 7;}
            if ("Maria Pasteleria".equals(Empre)) {empF = 8;}
            if ("TEC Milenio".equals(Empre)) {empF = 9;}
            if ("CODE".equals(Empre)) {empF = 10;}
            if ("Medicinas Rosario".equals(Empre)) {empF = 11;}
            if ("Microsoft México".equals(Empre)) {empF = 12;}
            if ("Google México".equals(Empre)) {empF = 13;}
            
        });

        Datos.add(empr);
        Datos.add(empresa);
        
        Registrar.setBounds(250, 600, 500, 45);
        Registrar.setBackground(new Color(0x1F3C4D));
        Registrar.setForeground(new Color(0xB8CCD7));
        Registrar.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Registrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //Guardar.setBorder(border);
        Registrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Registrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(Nombre.getText().length() == 0 ||
                   paterno.getText().length() == 0 || 
                   materno.getText().length() == 0 || 
                   nacimiento.getText().length() == 0 ||
                   Co.getText().length() == 0 ||
                   Telefono.getText().length() == 0 ||
                   password.getText().length() == 0 ||
                   Empre.length() == 0) { 
                   JOptionPane.showMessageDialog(null, "Rellene todos los campos del señor@ " + Nombre.getText());
                }
                else{
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                    try {
                        java.util.Date utilDate = format.parse(nacimiento.getText());
                        sqlDate = new java.sql.Date(utilDate.getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    usuarioEmpresarial UE = new usuarioEmpresarial(empF,Nombre.getText(), paterno.getText(), materno.getText(),sqlDate, Co.getText(), Long.parseLong(Telefono.getText(), 10), password.getText(),2);
                    new usuarioEmpresarialBD().crearUsuario(UE);
                    
                    dispose();
                    new NewIndex().setVisible(true);
                }
            }
        });
        Fondo.add(Registrar);

    }
}
