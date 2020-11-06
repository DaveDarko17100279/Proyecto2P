package Views;

import BD.ConferenciasInsBD;
import BD.usuarioEmpresarialBD;
import BD.usuarioGeneralBD;
import Formatos.*;
import Models.usuarioGeneral;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class NewLogin extends JFrame {
    
    JPanel Botones  = new RoundedPanel(30, new Color(255, 252, 255, 200));
    JPanel Titulo  = new RoundedPanel(90, new Color(255, 252, 255, 250));
    JPanel Borde = new RoundedPanel(0, new Color(255, 252, 255, 200));
    JLabel correo = new JLabel("Correo: ");
    JTextField Correo = new JTextField();
    JLabel pass = new JLabel("Contraseña: ");
    JPasswordField password = new JPasswordField();
    JButton ingresar = new Botones("INGRESAR");
    JButton Anterior = new Botones("<");
    FondoPanel fondo = new FondoPanel();
    String contraseña;
    String correo2;
    JLabel Title = new JLabel("I N I C I A  S E S I O N");
    
    public NewLogin () {
        //titulo de la ventana
        setTitle("Iniciar Sesion");
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
        Botones.setBounds (245, 170, 550, 385);
        Botones.setOpaque(false);
        
        Titulo.setLayout(null);
        Titulo.setBounds(10, 20, 1050, 100);
        Titulo.setOpaque(false);
        
        Title.setBounds(320, 30, 1050, 45);
        Title.setForeground(new Color (12, 8, 12, 100));
        Title.setFont(new java.awt.Font("Segoe UI Light", 1, 25));
        
        //nombre
        correo.setBounds(50, 100, 450, 30);
        correo.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        correo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correo.setForeground(Color.GRAY);
        Correo.setBounds(50, 135, 450, 30);
        Correo.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        Correo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Botones.add(correo);
        Botones.add(Correo);
        //Apellido Pat
        pass.setBounds(50, 180, 450, 30);
        pass.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        pass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pass.setForeground(Color.GRAY);
        password.setBounds(50, 215, 450, 30);
        password.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        Botones.add(pass);
        Botones.add(password);
       
        ingresar.setBounds(50, 270, 450, 55);
        ingresar.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        ingresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingresar.setBorder(border);
        ingresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ingresar.addActionListener ((ActionEvent e) -> {
            dispose();
            contraseña = password.getText();
            correo2 = Correo.getText(); 
            if (correo2.length() == 0 || contraseña.length() == 0){
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
            else {
              
                usuarioGeneral UG = new usuarioGeneral();
                UG = new usuarioGeneralBD().getUsuario(correo2, contraseña);
                //agregar view de menu con el usuario
                new ConferenciasInsBD().Usuario(UG);
            }
        });
       
        Anterior.setBounds(50, 50, 100, 45);
        Anterior.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Anterior.setBorder(border);
        Anterior.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Anterior.addActionListener ((ActionEvent e) -> {
            dispose();
            new NewIndex().setVisible(true);
        });
 
        Botones.add(ingresar);
        Botones.add(Anterior);
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
        
        ingresar.setOpaque(false);
        ingresar.setContentAreaFilled(false);
        ingresar.setBorderPainted(true);
        
        Anterior.setOpaque(false);
        Anterior.setContentAreaFilled(false);
        Anterior.setBorderPainted(true);
        
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
