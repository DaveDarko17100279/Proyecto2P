package Views;

import Formatos.*;
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
import javax.swing.JPanel;
import javax.swing.border.Border;


public class NewIndex extends JFrame {
    
    JPanel Botones  = new RoundedPanel(30, new Color(255, 252, 255, 200));
    JPanel Titulo  = new RoundedPanel(90, new Color(255, 252, 255, 250));
    JPanel Borde = new RoundedPanel(0, new Color(255, 252, 255, 200));
    JButton login = new Botones("INICIAR SESION");
    JButton registro = new Botones("REGISTRARSE");
    FondoPanel fondo = new FondoPanel();
    JLabel Title = new JLabel("S A V A L A   C O N F E R E N Z E S");
    

     public NewIndex () {
        //titulo de la ventana
        setTitle("Index");
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
        Botones.setBounds (245, 170, 550, 315);
        Botones.setOpaque(false);
        
        Titulo.setLayout(null);
        Titulo.setBounds(10, 20, 1050, 100);
        Titulo.setOpaque(false);
        
        Title.setBounds(320, 30, 1050, 45);
        Title.setForeground(new Color (12, 8, 12, 100));
        Title.setFont(new java.awt.Font("Segoe UI Light", 1, 25));
       
        registro.setBounds(50, 70, 450, 55);
        registro.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        registro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registro.setBorder(border);
        registro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registro.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                       
                       dispose();
                       new NewElegirUser().setVisible(true);
                    }
                }
        );
        
        login.setBounds(50, 190, 450, 55);
        login.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setBorder(border);
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        login.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                       
                       dispose();
                       new NewLogin().setVisible(true);
                    }
                }
        );
            
        Botones.add(login);
        Botones.add(registro);
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
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setBorderPainted(true);
        
        registro.setOpaque(false);
        registro.setContentAreaFilled(false);
        registro.setBorderPainted(true);
        
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