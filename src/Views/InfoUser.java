package Views;

import Administracion.usuarioGeneralAdmin;
import Models.usuarioGeneral;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author fabian_rodriguez
 */

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
//        init();
    }
}