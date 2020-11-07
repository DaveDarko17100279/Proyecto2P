package Views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Index extends JFrame {
    // Panels
    JPanel Botones  = new JPanel();
    JPanel Titulo  = new JPanel();
    JPanel Borde = new JPanel();
    
    // Labels
    JLabel Title = new JLabel("CoConferencias");
    
    // Buttons
    JButton login = new JButton("Iniciar sesión");
    JButton registro = new JButton("Crear cuenta");
    
    public Index () {
        super();
        init();
    }
    
    private void init() {
        Font fontTitle = new Font("Segoe UI", 0, 30);
        
        // Ventana
        this.setTitle("CoConferencias");
        this.setSize(600,420);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(new Color(0xACDBE5));

        // Layout 
        this.setLayout(null);
        
        Botones.setLayout(null);
        Botones.setBounds (0, 170, 600, 315);
        Botones.setOpaque(false);
        
        Titulo.setLayout(null);
        Titulo.setBounds(0, 20, 600, 100);
        
        Title.setBounds(200, 30, 600, 45);
        Title.setForeground(new Color (12, 8, 12, 100));
        Title.setFont(fontTitle);
       
        registro.setBounds(70, 10, 450, 55);
        btnConfig(registro);
        registro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        
        login.setBounds(70, 100, 450, 55);
        btnConfig(login);
        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        login.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                       
                       dispose();
                       new Login().setVisible(true);
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
    
    private void btnConfig(JButton btn) {
        btn.setOpaque(false);
        btn.setBackground(new Color(0,0,0,0));
        btn.setFont(new Font("Segoe UI", 0, 18));
    }
}
