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
import javax.swing.border.Border;


public class ElegirTipoUser extends JFrame {
    // Panels
    JPanel Botones  = new JPanel();
    
    // Labels
    JLabel Title = new JLabel("Seleccionar tipo de usuario");
    
    // Buttons
    JButton emp = new JButton("Empresarial");
    JButton gen = new JButton("General");
    
    public ElegirTipoUser () {
        super();
        init();
    }
    
    private void init() {
        Font fontTitle = new Font("Segoe UI", 0, 30);
        
        // Ventana
        this.setTitle("Tipo de usuario");
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
        
        Title.setBounds(120, 50, 600, 45);
        Title.setFont(fontTitle);
       
        gen.setBounds(70, 10, 450, 55);
        btnConfig(gen);
        gen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gen.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                       dispose();
                       new RegistrarG().setVisible(true);
                    }
                }
        );
        
        emp.setBounds(70, 100, 450, 55);
        btnConfig(emp);
        emp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        emp.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                       
                       dispose();
                       new RegistrarE().setVisible(true);
                    }
                }
        );
            
        Botones.add(emp);
        Botones.add(gen);
        getContentPane().add(Botones);
        getContentPane().add(Title);
    }
    
    private void btnConfig(JButton btn) {
        btn.setOpaque(false);
        btn.setBackground(new Color(0,0,0,0));
        btn.setFont(new Font("Segoe UI", 0, 18));
    }
    
}
