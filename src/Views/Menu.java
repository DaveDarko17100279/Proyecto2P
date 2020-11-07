package Views;

import Models.usuarioGeneral;
import Administracion.usuarioGeneralAdmin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Menu extends JFrame {
    // Data
    private final int id;
    private usuarioGeneral user;
    private usuarioGeneralAdmin userAdmin;
    
    // Text display
    private final JLabel labWelcome = new JLabel("");
    private final JLabel labOwnConfer = new JLabel("MIS CONFERENCIAS");
    private final JLabel labOutsideConfer = new JLabel("OTRAS CONFERENCIAS");
    
    // Buttons
    private final JButton btnInfo = new JButton("Ver mi información");
    private final JButton btnCreate = new JButton("Crear nueva conferencia");
    private final JButton btnManage = new JButton("Gestionar conferencias existentes");
    private final JButton btnToAssist = new JButton("Conferencias a las que estoy inscrito");
    private final JButton btnSignUp = new JButton("Inscribirme a una conferencia");
    
    public Menu(int ID) {
        super();
        this.id = ID;
        user = userAdmin.buscar(id);
        init();
    }

    private void init() {
        Font fontTitle = new Font("Segoe UI", 0, 30);
        Font fontSubtitle = new Font("Segoe UI Light", 1, 20);
        Font fontText = new Font("Segoe UI Light", 0, 18);
                
        // Ventana
        this.setTitle("CoConferences");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(new Color(0xACDBE5));
        
        // Layout
        GroupLayout menu = new GroupLayout(getContentPane());
        getContentPane().setLayout(menu);
        
        // Spaces between elements
        menu.setAutoCreateContainerGaps(true);
        menu.setAutoCreateGaps(true);
        
        // Buttons config
        btnConfig(btnInfo);
        btnInfo.addActionListener((ActionEvent e) -> {
            new InfoUser(id).setVisible(true);
        });
        
        btnConfig(btnCreate);
        btnCreate.addActionListener((ActionEvent e) -> {
            new CrearConferencia(id).setVisible(true);
        });
        
        btnConfig(btnToAssist);
        btnToAssist.addActionListener((ActionEvent e) -> {
           //dispose();
           new ConferenciasIns(id).setVisible(true);
        });

        btnConfig(btnManage);
        btnManage.addActionListener((ActionEvent e) -> {
            // Llamada a administrar mis conferencias ****************************************
            new VConferencia(id).setVisible(true);
        });
        
        btnConfig(btnSignUp);
        btnSignUp.addActionListener((ActionEvent e) -> {
           new DetallesConferenciaAjena(id).setVisible(true);
        });
        
        // Labels config
        labWelcome.setFont(fontTitle);
        labWelcome.setText("Bienvenido " + user.getNombre());
        labOwnConfer.setFont(fontSubtitle);
        labOutsideConfer.setFont(fontSubtitle);
        
        menu.setVerticalGroup(
            menu.createSequentialGroup()
                .addGap(50)
                .addGroup(
                    menu.createParallelGroup()
                        .addComponent(labWelcome)
                        .addComponent(btnInfo)
                        .addGap(80)
                )
                .addGroup(
                    menu.createSequentialGroup()
                        .addComponent(labOwnConfer)
                        .addComponent(btnCreate)
                        .addComponent(btnManage)
                        .addGap(40)
                )
                .addGroup(
                    menu.createSequentialGroup()
                        .addComponent(labOutsideConfer)
                        .addComponent(btnToAssist)
                        .addComponent(btnSignUp)
                )
        );
        
        menu.setHorizontalGroup(
            menu.createSequentialGroup()
                .addGap(90)
                .addGroup(
                    menu.createParallelGroup()
                        .addComponent(labWelcome, 500, 500, 500)
                        .addComponent(labOwnConfer)
                        .addComponent(btnCreate)
                        .addComponent(btnManage)
                        .addComponent(labOutsideConfer)
                        .addComponent(btnToAssist)
                        .addComponent(btnSignUp)
                )
                .addComponent(btnInfo)
        );
    }
    
    
    private void btnConfig(JButton btn) {
        btn.setOpaque(false);
        btn.setBackground(new Color(0,0,0,0));
        btn.setFont(new Font("Segoe UI", 0, 18));
    }
}
