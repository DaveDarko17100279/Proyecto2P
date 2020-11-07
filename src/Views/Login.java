package Views;
import BD.usuarioGeneralBD;
import Models.usuarioGeneral;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame {
    // Panels
    JPanel formulario  = new JPanel();
    JPanel Titulo  = new JPanel();
    
    // Labels
    JLabel correo = new JLabel("Correo: ");
    JLabel pass = new JLabel("Contraseña: ");
    JLabel Title = new JLabel("Iniciar sesión");
    
    // Text fields
    JTextField Correo = new JTextField();
    JPasswordField password = new JPasswordField();
    
    // 
    JButton ingresar = new JButton("Ingresar");
    
    // Strings
    String contraseña;
    String correo2;
    
    public Login () {
        super();
        init();
        
    }
     private void init() {
        // Fuentes
        Font fontTitle = new Font("Segoe UI", 0, 30);
        Font fontText = new Font("Segoe UI Light", 0, 18);
        
        // Ventana
        this.setTitle("CoConferencias");
        this.setSize(570,470);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(new Color(0xACDBE5));

        // Layout 
        this.setLayout(null);
        
        formulario.setLayout(null);
        formulario.setBounds (0, 20, 570, 385);
        formulario.setOpaque(false);
        
        Titulo.setLayout(null);
        Titulo.setBounds(0, 20, 570, 80);
        Titulo.setOpaque(false);
        
        Title.setBounds(0, 30, 570, 45);
        Title.setFont(fontTitle);
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        correo.setBounds(50, 100, 450, 30);
        correo.setFont(fontText);
        correo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        correo.setForeground(Color.GRAY);
        Correo.setBounds(50, 135, 450, 30);
        Correo.setFont(fontText);
        Correo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        
        formulario.add(correo);
        formulario.add(Correo);
        
        pass.setBounds(50, 180, 450, 30);
        pass.setFont(fontText);
        pass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pass.setForeground(Color.GRAY);
        password.setBounds(50, 215, 450, 30);
        password.setFont(fontText);
        password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        
        formulario.add(pass);
        formulario.add(password);
       
        ingresar.setBounds(50, 300, 450, 55);
        btnConfig(ingresar);
        ingresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ingresar.addActionListener ((ActionEvent e) -> {
            dispose();
            contraseña = password.getText();
            correo2 = Correo.getText(); 
            if (correo2.length() == 0 || contraseña.length() == 0){
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
                new Login().setVisible(true);
            }
            else {
                usuarioGeneral UG = new usuarioGeneral();
                UG = new usuarioGeneralBD().getUsuario(correo2, contraseña);
                    try {
                        if (UG.equals(null)){
                        JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                    }
                    else {
                        //agregar view de menu con el usuario
                        new Menu(UG.getId()).setVisible(true);
                    }
                }
                catch(java.lang.NullPointerException ex){
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias" );
                }
            }
        });
       
        formulario.add(ingresar);
        Titulo.add(Title);
        getContentPane().add(formulario);
        getContentPane().add(Titulo);
        
    }
    
    private void btnConfig(JButton btn) {
        btn.setOpaque(false);
        btn.setBackground(new Color(0,0,0,0));
        btn.setFont(new Font("Segoe UI", 0, 18));
    }
}
