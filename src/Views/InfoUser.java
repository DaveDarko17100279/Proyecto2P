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
//    private final JLabel labWelcome = new JLabel("");
//    private final JLabel labOwnConfer = new JLabel("MIS CONFERENCIAS");
//    private final JLabel labOutsideConfer = new JLabel("OTRAS CONFERENCIAS");
//    private final JLabel labWelcome = new JLabel("");
//    private final JLabel labOwnConfer = new JLabel("MIS CONFERENCIAS");
//    private final JLabel labOutsideConfer = new JLabel("OTRAS CONFERENCIAS");
//    private final JLabel labWelcome = new JLabel("");
//    private final JLabel labOwnConfer = new JLabel("MIS CONFERENCIAS");
//    private final JLabel labOutsideConfer = new JLabel("OTRAS CONFERENCIAS");
//    private final JLabel labWelcome = new JLabel("");
//    private final JLabel labOwnConfer = new JLabel("MIS CONFERENCIAS");
//    private final JLabel labOutsideConfer = new JLabel("OTRAS CONFERENCIAS");
    
    public InfoUser(int ID) {
        super();
        this.id = ID;
        user = userAdmin.buscar(id);
//        init();
    }
}