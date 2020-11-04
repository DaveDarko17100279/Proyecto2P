/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Formatos.Botones;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author DaveDarko
 */
public class VConferencia extends JFrame {
    JPanel Botones  = new JPanel();
    JButton login = new Botones("LOGIN");
    JButton registro = new Botones("CREATE ACCOUNT");
    FondoPanel fondo = new FondoPanel();
    
    
     public VConferencia () {
        //titulo de la ventana
        setTitle("Mis Conferencias");
        //tamaño de la ventana
        setSize(1000,800);
        //Se podra redimencionar
        setResizable(false);
        //Localizacion
        setLocationRelativeTo(null);
        //Salir
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
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
        Botones.setBounds(300, 250, 400, 300);
        Botones.setBackground(new java.awt.Color(233, 196, 106));
        
        
        login.setBounds(50, 70, 300, 45);
        login.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setBorder(border);
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        registro.setBounds(50, 185, 300, 45);
        registro.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        registro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registro.setBorder(border);
        registro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        Botones.add(login);
        Botones.add(registro);
        getContentPane().add(Botones);
        
    }
     
    class FondoPanel extends JPanel {
        private Image imagen;
         
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/Conferencias.jpg")).getImage();
         
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
