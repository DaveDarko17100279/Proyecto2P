package Views;

import BD.usuarioGeneralBD;
import Formatos.*;
import Models.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class CuentaG extends JFrame {
    
    JPanel Botones  = new RoundedPanel(30, new Color(255, 252, 255, 200));
    JPanel Titulo  = new RoundedPanel(90, new Color(255, 252, 255, 250));
    JPanel Borde = new RoundedPanel(0, new Color(255, 252, 255, 200));
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
    JButton Guardar = new Botones("GUARDAR");
    FondoPanel fondo = new FondoPanel();
    JLabel Title = new JLabel("U S U A R I O  G E N E R A L");
    String Empre = "";
    java.sql.Date sqlDate;
    JButton Regresa = new Botones();
    Image photo  = new ImageIcon(this.getClass().getResource("/Imagenes/return1.png")).getImage();
    

     public CuentaG () {
        //titulo de la ventana
        setTitle("Crear");
        //tamaño de la ventana
        setSize(1000,703);
        //Se podra redimencionar
        setResizable(false);
        //Localizacion
        setLocationRelativeTo(null);
        //Salir
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Agregamos Fondo
        this.setContentPane(fondo);
        //Crear la interfaz
        init();
        transparenciaButton();
        
    }
     private void init() {
        // Layout 
        this.setLayout(null);
        BordeRedondo border = new BordeRedondo(40); // radio = 10

        
        Botones.setLayout(null);
        //150, 100, 700, 600
        Botones.setBounds (200, 150, 570, 450);
        Botones.setOpaque(false);
        
        Titulo.setLayout(null);
        Titulo.setBounds(10, 20, 1050, 100);
        Titulo.setOpaque(false);
        
        Title.setBounds(320, 30, 1050, 45);
        Title.setForeground(new Color (12, 8, 12, 100));
        Title.setFont(new java.awt.Font("Segoe UI Light", 1, 25));
        
        //nombre
        nombre.setBounds(20, 9, 300, 30);
        nombre.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombre.setForeground(Color.WHITE);
        Nombre.setBounds(20, 35, 300, 30);
        Nombre.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Botones.add(nombre);
        Botones.add(Nombre);
        //Apellido Pat
        apPa.setBounds(20, 69, 300, 30);
        apPa.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        apPa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        apPa.setForeground(Color.WHITE);
        paterno.setBounds(20, 95, 300, 30);
        paterno.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        paterno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Botones.add(apPa);
        Botones.add(paterno);
        //Apellido Mat
        apMa.setBounds(20, 129, 300, 30);
        apMa.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        apMa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        apMa.setForeground(Color.WHITE);
        materno.setBounds(20, 155, 300, 30);
        materno.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        materno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Botones.add(apMa);
        Botones.add(materno);
        //Fecha Nacimiento
        fechNa.setBounds(20, 189, 300, 30);
        fechNa.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        fechNa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fechNa.setForeground(Color.WHITE);
        nacimiento.setHint("AAAA-MM-DD");
        nacimiento.setBounds(20, 215, 300, 30);
        nacimiento.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        nacimiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Botones.add(fechNa);
        Botones.add(nacimiento);
        //correo
        correo.setBounds(20, 249, 300, 30);
        correo.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        correo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correo.setForeground(Color.WHITE);
        Co.setBounds(20, 275, 300, 30);
        Co.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Co.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Botones.add(correo);
        Botones.add(Co);
        //Telefono
        tel.setBounds(20, 309, 300, 30);
        tel.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        tel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tel.setForeground(Color.WHITE);
        Telefono.setBounds(20, 335, 300, 30);
        Telefono.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Telefono.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Botones.add(tel);
        Botones.add(Telefono);
        //Contraseña
        pass.setBounds(20, 369, 300, 30);
        pass.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        pass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pass.setForeground(Color.WHITE);
        password.setBounds(20, 395, 300, 30);
        password.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Botones.add(pass);
        Botones.add(password);
       
        Regresa.setIcon(new ImageIcon(photo));
        Regresa.setBounds(375, 35, 150, 45);
        Regresa.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Regresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Regresa.setBorder(border);
        Regresa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Regresa.addActionListener ((ActionEvent e) -> {
            dispose();
            new NewElegirUser().setVisible(true);
        });
        Guardar.setBounds(375, 100, 150, 45);
        Guardar.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Guardar.setBorder(border);
        Guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Guardar.addActionListener((ActionEvent evt) -> {
            if( Nombre.getText().length() == 0 ||
                paterno.getText().length() == 0 ||
                materno.getText().length() == 0 ||
                nacimiento.getText().length() == 0 ||
                Co.getText().length() == 0 ||
                Telefono.getText().length() == 0 ||
                password.getText().length() == 0 ) {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos del señor@ " + Nombre.getText());
            }
            else {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    java.util.Date utilDate = format.parse(nacimiento.getText());
                    sqlDate = new java.sql.Date(utilDate.getTime());
                    System.out.println(sqlDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                usuarioGeneral UG = new usuarioGeneral(Nombre.getText(), paterno.getText(), materno.getText(),sqlDate, Co.getText(), Long.parseLong(Telefono.getText(), 10), password.getText(),1);
                new usuarioGeneralBD().crearUsuario(UG);
            }
            dispose();
            new Index().setVisible(true);
        });
        Botones.add(Regresa);
        Botones.add(Guardar);
        Titulo.add(Title);
        getContentPane().add(Botones);
        getContentPane().add(Titulo);
        getContentPane().add(Borde);
    }
     
    class FondoPanel extends JPanel {
        private Image imagen;
         
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/Index1.jpeg")).getImage();
         
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
    
    public void transparenciaButton() {
        
        Regresa.setOpaque(false);
        Regresa.setContentAreaFilled(false);
        Regresa.setBorderPainted(true);
        
        Guardar.setOpaque(false);
        Guardar.setContentAreaFilled(false);
        Guardar.setBorderPainted(true);
    }
    
    class BordeRedondo implements Border {

        private final int radio;  

        BordeRedondo(int radius) {
            this.radio = radius;
        }  

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
        }  

        @Override
        public boolean isBorderOpaque() {
            return true;
        }  

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radio, radio);
        }
    }
}
