package Views;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Login extends JFrame {
    
    JPanel PanelPrincipal;
    JLabel nombre = new JLabel();
    JTextField Nombre = new JTextField();
    FondoPanel fondo = new FondoPanel();
    
    public Login () {
        //titulo de la ventana
        setTitle("Login");
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
        
            
    }
    private void init() {
        // Layout 
        this.setLayout(null);
        
        PanelPrincipal = new JPanel();
        PanelPrincipal.setLayout(null);
        PanelPrincipal.setBounds(150, 150, 400, 300);
        PanelPrincipal.setBackground(new java.awt.Color(233, 196, 106));
        
        
        Nombre.setBounds(20, 50, 300, 40);
        Nombre.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        
        PanelPrincipal.add(Nombre);
        getContentPane().add(PanelPrincipal);
    }
    class FondoPanel extends JPanel {
        private Image imagen;
         
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/login.jpeg")).getImage();
         
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
}
