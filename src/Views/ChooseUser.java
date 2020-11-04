package Views;

import Formatos.Botones;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class ChooseUser extends JFrame {
    
    JPanel Botones  = new JPanel();
    JButton General = new Botones("GENERAL");
    JButton Empresarial  = new Botones("EMPRESARIAL");
    FondoPanel fondo = new FondoPanel();
    JLabel Titulo = new JLabel("SELECCIONA");
    JButton back = new JButton("<");
    
     public ChooseUser () {
        //titulo de la ventana
        setTitle("Usuario");
        //tamaño de la ventana
        setSize(1000,800);
        //Se podra redimencionar
        setResizable(false);
        //Localizacion
        setLocationRelativeTo(null);
        //Salir
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Agregamos Fondo con imagen 
        this.setContentPane(fondo);
        //Crear la interfaz
        init();
        //Clase de trasnparencia de botones
        transparenciaButton();
        
    }
     private void init() {
        // Layout 
        this.setLayout(null);
        BordeRedondo border = new BordeRedondo(40); // radio = 10
        
        Titulo.setBounds(145, 60, 700, 100);
        Titulo.setFont(new java.awt.Font("Segoe UI Light", Font.BOLD, 64));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setForeground(Color.WHITE);
        
        back.setBounds(30,80, 100, 70);
        back.setFont(new java.awt.Font("Segoe UI Light", 1, 27));
        back.setForeground(Color.WHITE);
        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setBorder(border);
        back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        back.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                       dispose();
                       new index().setVisible(true);
                    }
                }
        );
        
        Botones.setLayout(null);
        Botones.setBounds (300, 250, 400, 300);
        Botones.setBackground(new java.awt.Color(233, 196, 106, 240));
        
        
        General.setBounds(50, 70, 300, 45);
        General.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        General.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        General.setBorder(border);
        General.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        General.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                       dispose();
                       new CreateAccountG().setVisible(true);
                    }
                }
        );
        
        
        Empresarial.setBounds(50, 185, 300, 45);
        Empresarial.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        Empresarial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Empresarial.setBorder(border);
        Empresarial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Empresarial.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                       
                       dispose();
                       new CreateAccountE().setVisible(true);
                    }
                }
        );
        
        Botones.add(General);
        Botones.add(Empresarial);
        getContentPane().add(Botones);
        getContentPane().add(Titulo);
        getContentPane().add(back);
        
    }
     
    class FondoPanel extends JPanel {
        private Image imagen;
         
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/User.jpeg")).getImage();
         
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
    
    public void transparenciaButton() {
        General.setOpaque(false);
        General.setContentAreaFilled(false);
        General.setBorderPainted(true);
        
        Empresarial.setOpaque(false);
        Empresarial.setContentAreaFilled(false);
        Empresarial.setBorderPainted(true);
        
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(true);
    }
    
    class BordeRedondo implements Border {
        private int radio;  

        BordeRedondo(int radius) {
            this.radio = radius;
        }  

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
        }  

        public boolean isBorderOpaque() {
            return true;
        }  

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radio, radio);
        }
    }
}
