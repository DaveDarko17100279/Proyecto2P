package Views;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class index extends JFrame {
    
    JPanel Botones  = new JPanel();
    JButton login = new JButton("INICIAR SESION");
    JButton registro = new JButton("REGISTRO");
    FondoPanel fondo = new FondoPanel();
    
    
     public index () {
        //titulo de la ventana
        setTitle("Index");
        //tamaño de la ventana
        setSize(1000,800);
        //Se podra redimencionar
        //setResizable(false);
        //Localizacion
        setLocationRelativeTo(null);
        //Salir
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setContentPane(fondo);
        //Crear la interfaz
        init();
        transparenciaButton();
        //this.getContentPane().setBackground(new java.awt.Color(38, 70, 83));
        
    }
     private void init() {
        // Layout 
        this.setLayout(null);
        
        Botones.setLayout(null);
        Botones.setBounds(300, 220, 400, 300);
        Botones.setBackground(new java.awt.Color(233, 196, 106));
        
        
        login.setBounds(50, 70, 300, 45);
        login.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        registro.setBounds(50, 185, 300, 45);
        registro.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        registro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        Botones.add(login);
        Botones.add(registro);
        getContentPane().add(Botones);
        
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
}
