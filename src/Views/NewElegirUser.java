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


public class NewElegirUser extends JFrame {
    
    JPanel Botones  = new RoundedPanel(30, new Color(255, 252, 255, 200));
    JPanel Titulo  = new RoundedPanel(90, new Color(255, 252, 255, 250));
    JPanel Borde = new RoundedPanel(0, new Color(255, 252, 255, 200));
    JButton empresarial = new Botones("USUARIO EMPRESARIAL");
    JButton general = new Botones("USUARIO GENERAL");
    //JButton Siguiente = new Botones(">");
    JButton Anterior = new Botones("<");
    FondoPanel fondo = new FondoPanel();
    JLabel Title = new JLabel("E L I G E   E L   U S U A R I O");
    JButton Regresa = new Botones();
    Image photo  = new ImageIcon(this.getClass().getResource("/Imagenes/return1.png")).getImage();
    

     public NewElegirUser () {
        //titulo de la ventana
        setTitle("Elegir usuario");
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
        Botones.setBounds (245, 170, 550, 415);
        Botones.setOpaque(false);
        
        Titulo.setLayout(null);
        Titulo.setBounds(10, 20, 1050, 100);
        Titulo.setOpaque(false);
        
        Title.setBounds(320, 30, 1050, 45);
        Title.setForeground(new Color (12, 8, 12, 100));
        Title.setFont(new java.awt.Font("Segoe UI Light", 1, 25));
       
        general.setBounds(50, 70, 450, 55);
        general.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        general.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        general.setBorder(border);
        general.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        general.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                       dispose();
                       new RegistrarG().setVisible(true);
                    }
                }
        );
        empresarial.setBounds(50, 190, 450, 55);
        empresarial.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        empresarial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empresarial.setBorder(border);
        empresarial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        empresarial.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                       
                       dispose();
                       new RegistrarE().setVisible(true);
                    }
                }
        );
        
        Regresa.setIcon(new ImageIcon(photo));
        Regresa.setBounds(225, 295, 100, 45);
        Regresa.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Regresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Regresa.setBorder(border);
        Regresa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Regresa.addActionListener ((ActionEvent e) -> {
            dispose();
            new Index().setVisible(true);
        });
        
        Botones.add(empresarial);
        Botones.add(general);
        Botones.add(Regresa);
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
        empresarial.setOpaque(false);
        empresarial.setContentAreaFilled(false);
        empresarial.setBorderPainted(true);
        
        general.setOpaque(false);
        general.setContentAreaFilled(false);
        general.setBorderPainted(true);
        
        Regresa.setOpaque(false);
        Regresa.setContentAreaFilled(false);
        Regresa.setBorderPainted(true);
        
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
