package Views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.border.Border;


public class Login extends JFrame {
    
    private JPanel PanelPrincipal;
    private JLabel nombre = new JLabel("Nombre:");
    private JTextField Nombre = new JTextField();
    private JLabel pass = new JLabel("Contraseña:");
    private JTextField password = new JTextField();
    private FondoPanel fondo = new FondoPanel();
    private JLabel Titulo = new JLabel("Inicia Sesion");
    JButton back = new JButton("<");
    
    public Login () {
        //titulo de la ventana
        setTitle("Ingresa");
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
        BordeRedondo border = new BordeRedondo(40); // radio = 10
        
        Titulo.setBounds(158, 60, 700, 100);
        Titulo.setFont(new java.awt.Font("Segoe UI Light", Font.BOLD, 64));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setForeground(Color.WHITE);
        
        back.setBounds(30,80, 100, 70);
        back.setFont(new java.awt.Font("Segoe UI Light", 1, 27));
        back.setForeground(Color.WHITE);
        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setBorder(border);
        back.setBackground(new Color(0,0,0,0));
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
        
        PanelPrincipal = new JPanel();
        PanelPrincipal.setLayout(null);
        PanelPrincipal.setBounds(300, 250, 400, 300);
        PanelPrincipal.setBackground(new java.awt.Color(233, 196, 106, 100));
        
        nombre.setBounds(20, 15, 300, 40);
        nombre.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombre.setForeground(Color.WHITE);
        
        Nombre.setBounds(20, 70, 300, 40);
        Nombre.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        
        pass.setBounds(20, 125, 300, 40);
        pass.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        pass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pass.setForeground(Color.WHITE);
        
        password.setBounds(20,180 , 300, 40);
        password.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        
        PanelPrincipal.add(nombre);
        PanelPrincipal.add(Nombre);
        PanelPrincipal.add(pass);
        PanelPrincipal.add(password);
        
        getContentPane().add(back);
        getContentPane().add(Titulo);
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
    public void transparenciaButton() {

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

