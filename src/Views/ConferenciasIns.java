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


public class ConferenciasIns extends JFrame {
    
    JPanel Botones  = new RoundedPanel(30, new Color(255, 252, 255, 200));
    JPanel Titulo  = new RoundedPanel(90, new Color(255, 252, 255, 250));
    JPanel Borde = new RoundedPanel(0, new Color(255, 252, 255, 200));
    JButton login = new Botones("MENOS");
    JButton detalles = new Botones("DETALLES");
    JButton Siguiente = new Botones(">");
    JButton Anterior = new Botones("<");
    FondoPanel fondo = new FondoPanel();
    JLabel Title = new JLabel("M I S  C O N F E R E N C I A S");
    JLabel Nombre = new JLabel("CONFERENCIA");
    JLabel Cupo = new JLabel("CUPO TOTAL");
    JLabel Precio  = new JLabel("PRECIO");
    JLabel Fecha  = new JLabel("FECHA");
    JLabel horaInicio  = new JLabel("INICIA");
    JLabel horaFinal  = new JLabel("FINALIZA");

     public ConferenciasIns () {
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
        Botones.setBounds (175, 170, 650, 215);
        Botones.setOpaque(false);
        
        Titulo.setLayout(null);
        Titulo.setBounds(10, 20, 1050, 100);
        Titulo.setOpaque(false);
        
        Title.setBounds(320, 30, 1050, 45);
        Title.setForeground(new Color (12, 8, 12, 100));
        Title.setFont(new java.awt.Font("Segoe UI Light", 1, 25));
       
        
        Nombre.setBounds(50, 20, 150, 45);
        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nombre.setForeground(new Color (12, 8, 12, 100));
        Nombre.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
        
        Cupo.setBounds(200, 20, 150, 45);
        Cupo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cupo.setForeground(new Color (12, 8, 12, 100));
        Cupo.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
        
        Precio.setBounds(350, 20, 150, 45);
        Precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Precio.setForeground(new Color (12, 8, 12, 100));
        Precio.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
        
        detalles.setBounds(430, 100, 150, 45);
        detalles.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        detalles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detalles.setBorder(border);
        detalles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        Anterior.setBounds(200, 145, 100, 45);
        Anterior.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Anterior.setBorder(border);
        Anterior.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        Siguiente.setBounds(300, 145, 100, 45);
        Siguiente.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Siguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Siguiente.setBorder(border);
        Siguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        Botones.add(login);
        Botones.add(detalles);
        Botones.add(Nombre);
        Botones.add(Cupo);
        Botones.add(Precio);
        Botones.add(Anterior);
        Botones.add(Siguiente);
        Titulo.add(Title);
        getContentPane().add(Botones);
        getContentPane().add(Titulo);
        getContentPane().add(Borde);
        
        detalles.addActionListener ((ActionEvent e) -> {
            detalles.setVisible(false);
            
            Botones.setLayout(null);
            Botones.setBounds (175, 170, 650, 315);
            Botones.setOpaque(false);
            
            Fecha.setBounds(450, 20, 150, 45);
            Fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            Fecha.setForeground(new Color (12, 8, 12, 100));
            Fecha.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
            
            horaInicio.setBounds(50, 100, 150, 45);
            horaInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            horaInicio.setForeground(new Color (12, 8, 12, 100));
            horaInicio.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
            
            horaFinal.setBounds(200, 100, 150, 45);
            horaFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            horaFinal.setForeground(new Color (12, 8, 12, 100));
            horaFinal.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
            
            Anterior.setBounds(200, 245, 100, 45);
            Anterior.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
            Anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            Anterior.setBorder(border);
            Anterior.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            Siguiente.setBounds(300, 245, 100, 45);
            Siguiente.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
            Siguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            Siguiente.setBorder(border);
            Siguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            login.setBounds(430, 200, 150, 45);
            login.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
            login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            login.setBorder(border);
            login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            Botones.add(horaInicio);
            Botones.add(horaFinal);
            Botones.add(login);
            Botones.add(Fecha);
        });
        
        
    }
     
     
     
    class FondoPanel extends JPanel {
        private Image imagen;
         
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/Fondo1.jpg")).getImage();
         
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
    
    public void transparenciaButton() {
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setBorderPainted(true);
        
        detalles.setOpaque(false);
        detalles.setContentAreaFilled(false);
        detalles.setBorderPainted(true);
        
        Anterior.setOpaque(false);
        Anterior.setContentAreaFilled(false);
        Anterior.setBorderPainted(true);
        
        Siguiente.setOpaque(false);
        Siguiente.setContentAreaFilled(false);
        Siguiente.setBorderPainted(true);
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
