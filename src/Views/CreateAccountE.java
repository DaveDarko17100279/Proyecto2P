package Views;

import Formatos.JTextFieldHint;
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class CreateAccountE extends JFrame {
    
    private JPanel PanelPrincipal;
    private JLabel Titulo = new JLabel("CREA UNA CUENTA");
    private JLabel nombre = new JLabel("Nombre: ");
    private JTextField Nombre = new JTextField();
    private JLabel apPa = new JLabel("Apellido Paterno: ");
    private JTextField paterno = new JTextField();
    private JLabel apMa = new JLabel("Apellido Materno: ");
    private JTextField materno = new JTextField();
    private JLabel fechNa = new JLabel("Fecha de Nacimiento: ");
    private JTextFieldHint nacimiento = new JTextFieldHint();
    private JLabel correo = new JLabel("Correo: ");
    private JTextField Co = new JTextField();
    private JLabel tel = new JLabel("Telefono: ");
    private JTextField Telefono = new JTextField();
    private JLabel pass = new JLabel("Contraseña: ");
    private JTextField password = new JTextField();
    private JLabel empr = new JLabel ("Empresa: ");
    private List list = new ArrayList();
    private FondoPanel fondo = new FondoPanel();
    JButton registro = new JButton();
    
    public CreateAccountE () {
        //titulo de la ventana
        setTitle("Registro");
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
        
        Titulo.setBounds(150, 60, 700, 100);
        Titulo.setFont(new java.awt.Font("Segoe UI Light", Font.BOLD, 64));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Titulo.setForeground(Color.WHITE);
        
        PanelPrincipal = new JPanel();
        PanelPrincipal.setLayout(null);
        PanelPrincipal.setBounds(150, 100, 700, 600);
        PanelPrincipal.setBackground(new java.awt.Color(233, 196, 106, 100));
        //nombre
        nombre.setBounds(20, 15, 300, 30);
        nombre.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombre.setForeground(Color.WHITE);
        Nombre.setBounds(20, 50, 300, 30);
        Nombre.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        PanelPrincipal.add(nombre);
        PanelPrincipal.add(Nombre);
        //Apellido Pat
        apPa.setBounds(20, 85, 300, 30);
        apPa.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        apPa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        apPa.setForeground(Color.WHITE);
        paterno.setBounds(20, 120, 300, 30);
        paterno.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        paterno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        PanelPrincipal.add(apPa);
        PanelPrincipal.add(paterno);
        //Apellido Mat
        apMa.setBounds(20, 155, 300, 30);
        apMa.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        apMa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        apMa.setForeground(Color.WHITE);
        materno.setBounds(20, 190, 300, 30);
        materno.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        materno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        PanelPrincipal.add(apMa);
        PanelPrincipal.add(materno);
        //Fecha Nacimiento
        fechNa.setBounds(20, 225, 300, 30);
        fechNa.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        fechNa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fechNa.setForeground(Color.WHITE);
        nacimiento.setHint("AAAA-MM-DD");
        nacimiento.setBounds(20, 260, 300, 30);
        nacimiento.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        nacimiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        PanelPrincipal.add(fechNa);
        PanelPrincipal.add(nacimiento);
        //correo
        correo.setBounds(20, 295, 300, 30);
        correo.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        correo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correo.setForeground(Color.WHITE);
        Co.setBounds(20, 330, 300, 30);
        Co.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        Co.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        PanelPrincipal.add(correo);
        PanelPrincipal.add(Co);
        //Telefono
        tel.setBounds(20, 365, 300, 30);
        tel.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        tel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tel.setForeground(Color.WHITE);
        Telefono.setBounds(20, 400, 300, 30);
        Telefono.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        Telefono.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        PanelPrincipal.add(tel);
        PanelPrincipal.add(Telefono);
        //Contraseña
        pass.setBounds(20, 435, 300, 30);
        pass.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        pass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pass.setForeground(Color.WHITE);
        password.setBounds(20, 470, 300, 30);
        password.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        //Agregar al JPanel
        PanelPrincipal.add(pass);
        PanelPrincipal.add(password);
        //Empresa
        empr.setBounds(20, 505, 300, 30);
        empr.setFont(new java.awt.Font("Segoe UI Light", 1, 16));
        empr.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        empr.setForeground(Color.WHITE);
        registro.setBounds(370, 30 , 205, 100);
        registro.setFont(new java.awt.Font("Segoe UI Light", 1, 18));
        registro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registro.setBorder(border);
        registro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registro.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                       
                       dispose();
                       new ChooseUser().setVisible(true);
                    }
                }
        );
        PanelPrincipal.add(registro);
        

        
        

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
