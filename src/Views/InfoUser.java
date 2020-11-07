package Views;

import Admin.usuarioGeneralAdmin;
import Models.usuarioGeneral;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

public class InfoUser extends JFrame{
    // Data
    private final int id;
    private usuarioGeneral user;
    private usuarioGeneralAdmin userAdmin;
    
    // Text display
    private final JLabel labInfo = new JLabel("Información de usuario");
    private final JLabel labxName = new JLabel("Nombre:");
    private final JLabel labName = new JLabel("");
    private final JLabel labPLast = new JLabel("");
    private final JLabel labMLast = new JLabel("");
    private final JLabel labxBirth = new JLabel("Fecha de Nacimiento: ");
    private final JLabel labBirth = new JLabel("");
    private final JLabel labxEmail = new JLabel("Correo Electrónico: ");
    private final JLabel labEmail = new JLabel("");
    private final JLabel labxTel = new JLabel("Telefono: ");
    private final JLabel labTel = new JLabel("");
    private final JLabel labxType = new JLabel("Tipo de usuario: ");
    private final JLabel labType = new JLabel("");
    
    public InfoUser(int ID) {
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
        this.setTitle("Información del usuario");
        this.setSize(500, 350);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(new Color(0xACDBE5));
        
        // Layout
        GroupLayout info = new GroupLayout(getContentPane());
        getContentPane().setLayout(info);
        
        // Spaces between elements
        info.setAutoCreateContainerGaps(true);
        info.setAutoCreateGaps(true);
        
        // Set fonts
        labInfo.setFont(fontTitle);
        labxName.setFont(fontSubtitle);
        labxBirth.setFont(fontSubtitle);
        labxEmail.setFont(fontSubtitle);
        labxTel.setFont(fontSubtitle);
        labxType.setFont(fontSubtitle);
        labName.setFont(fontText);
        labPLast.setFont(fontText);
        labMLast.setFont(fontText);
        labBirth.setFont(fontText);
        labEmail.setFont(fontText);
        labTel.setFont(fontText);
        labType.setFont(fontText);
        
        // Config labels
        labName.setText(user.getNombre());
        labPLast.setText(user.getApellidoPaterno());
        labMLast.setText(user.getApellidoMaterno());
        labBirth.setText(user.getFechaNacimiento().toString());
        labEmail.setText(user.getCorreo());
        labTel.setText(String.valueOf(user.getTelefono()));
        if(user.getTipo() == 1) {
            labType.setText("General");
        }
        else {
            labType.setText("Empresarial");
        }
        
        info.setVerticalGroup(
            info.createSequentialGroup()
                .addGap(20)
                .addGroup(
                info.createSequentialGroup()
                    .addComponent(labInfo)
                    .addGap(30)
                )
                .addGroup(
                    info.createParallelGroup()
                        .addComponent(labxName)
                        .addComponent(labName)
                        .addComponent(labPLast)
                        .addComponent(labMLast)
                        .addGap(40)
                )
                .addGroup(
                    info.createParallelGroup()
                        .addComponent(labxBirth)
                        .addComponent(labBirth)
                        .addGap(40)
                )
                .addGroup(
                    info.createParallelGroup()
                        .addComponent(labxEmail)
                        .addComponent(labEmail)
                        .addGap(40)
                )
                .addGroup(
                    info.createParallelGroup()
                        .addComponent(labxTel)
                        .addComponent(labTel)
                        .addGap(40)
                )
                .addGroup(
                    info.createParallelGroup()
                        .addComponent(labxType)
                        .addComponent(labType)
                        .addGap(40)
                )
        );
        
        info.setHorizontalGroup(
            info.createParallelGroup()
                .addGap(20)
                .addGroup(
                    info.createParallelGroup()
                        .addComponent(labInfo)
                )
                .addGroup(
                    info.createSequentialGroup()
                        .addComponent(labxName)
                        .addComponent(labName)
                        .addComponent(labPLast)
                        .addComponent(labMLast)
                        .addGap(40)
                )
                .addGroup(
                    info.createSequentialGroup()
                        .addComponent(labxBirth)
                        .addComponent(labBirth)
                        .addGap(40)
                )
                .addGroup(
                    info.createSequentialGroup()
                        .addComponent(labxEmail)
                        .addComponent(labEmail)
                        .addGap(40)
                )
                .addGroup(
                    info.createSequentialGroup()
                        .addComponent(labxTel)
                        .addComponent(labTel)
                        .addGap(40)
                )
                .addGroup(
                    info.createSequentialGroup()
                        .addComponent(labxType)
                        .addComponent(labType)
                        .addGap(40)
                )
        );
    }
}