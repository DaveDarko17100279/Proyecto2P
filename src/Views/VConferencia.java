package Views;




import BD.conexion;
import BD.conferenciaBD;
import Models.conferencia;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author DaveDarko
 */
public class VConferencia extends JFrame {

    Connection cn = new conexion().getConnection();
    
    int id;
    
    conferenciaBD usuario = new conferenciaBD();
    conferencia[] con;
    
    Object[] fila = new Object[3];
    
    
    private int Posicion;
    
    DefaultTableModel modelo = new DefaultTableModel();
    private JTable tabla = new JTable(modelo);
    private JPanel panelGeneral = new JPanel(); //******************************************************************* PANEL INFORMACIÓN
    private JPanel panelDetalles = new JPanel(); //******************************************************************* PANEL INFORMACIÓN
    private JPanel panelEditar = new JPanel(); //******************************************************************* PANEL INFORMACIÓN

    private JPanel panelBotones = new JPanel(); //******************************************************************* PANEL INFORMACIÓN
    private JPanel contentPane = new JPanel(null); // ********************************************************* PANEL CONTENEDOR

    private JLabel lblName = new JLabel(); //**************************************************************************** Nombre
    private JLabel lblPrecio = new JLabel(); //**************************************************************************** Nombre
    private JLabel lblCupo = new JLabel(); //**************************************************************************** Nombre
    private JLabel lblHoraInicio = new JLabel(); //**************************************************************************** Nombre
    private JLabel lblHoraFinal = new JLabel(); //**************************************************************************** Nombre

    private JTextField txtName = new JTextField(); //**************************************************************************** Nombre
    private JTextField txtPrecio = new JTextField(); //**************************************************************************** Nombre
    private JTextField txtCupo = new JTextField(); //**************************************************************************** Nombre
    private JTextField txtHoraInicio = new JTextField(); //**************************************************************************** Nombre
    private JTextField txtHoraFinal = new JTextField(); //**************************************************************************** Nombre

    JButton btnEditar = new JButton("Editar Conferencia");
    JButton btnEliminar = new JButton("Eliminar Conferencia");

    public VConferencia(int ID) {
        id = ID;
        con = new conferencia[usuario.getConferencias(id).length];
        // CONFIGURAR EL JFRAME
        setTitle("Index");
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(new Color(0x15576B));
        
        

        panelGeneral();
        panelBotones();
        table();
        panelDetalles();
        panelEditar();
        Clicks();

        

        // CONFIGURACIÓN FINAL AL JFRAME
        setContentPane(contentPane);
        add(panelGeneral);
        add(panelBotones);
        add(panelDetalles);
        add(panelEditar);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setVisible(true);
    }
    
    private void panelGeneral(){
        // DECLARACION DE PANELES
        panelGeneral.setLayout(null);
        panelGeneral.setBounds(500,0, 400,800);
        panelGeneral.setBackground(new Color(0x15576B));
        
        JLabel lblBienvenido = new JLabel();
        lblBienvenido.setBounds(50,50,200,200);
        lblBienvenido.setText("Benvenido");
        lblBienvenido.setForeground(new Color(0x08A2C1));
        lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        lblBienvenido.setVerticalAlignment(SwingConstants.CENTER);
        lblBienvenido.setFont(new Font("Agency FB", Font.BOLD, 30));
        
        panelGeneral.add(lblBienvenido);
        
        JLabel lblBienvenido1 = new JLabel();
        lblBienvenido1.setBounds(50,150,200,200);
        lblBienvenido1.setText("A Tus");
        lblBienvenido1.setForeground(new Color(0x08A2C1));
        lblBienvenido1.setHorizontalAlignment(SwingConstants.CENTER);
        lblBienvenido1.setVerticalAlignment(SwingConstants.CENTER);
        lblBienvenido1.setFont(new Font("Agency FB", Font.BOLD, 30));
        
        panelGeneral.add(lblBienvenido1);
        
        JLabel lblBienvenido2 = new JLabel();
        lblBienvenido2.setBounds(50,250,200,200);
        lblBienvenido2.setText("Conferencias");
        lblBienvenido2.setForeground(new Color(0x08A2C1));
        lblBienvenido2.setHorizontalAlignment(SwingConstants.CENTER);
        lblBienvenido2.setVerticalAlignment(SwingConstants.CENTER);
        lblBienvenido2.setFont(new Font("Agency FB", Font.BOLD, 30));
        
        panelGeneral.add(lblBienvenido2);
        
        panelDetalles.setVisible(false);
        panelEditar.setVisible(false);
        panelBotones.setVisible(false);
    }
    
    private void table(){
        // CONFIGURAR LA TABLA
        modelo.addColumn("Nombre Conferencia");
        modelo.addColumn("Precio");
        modelo.addColumn("Cupo");
        
            
            for(int i = 0; i<con.length;i++){
                con[i] = usuario.getConferencias(id)[i];
            }
            
            for(int i = 0; i < con.length; i++){
                fila[0] = con[i].getNombreConferencia();
                fila[1] = String.valueOf(con[i].getPrecio());
                fila[2] = String.valueOf(con[i].getCupoTotal());
                modelo.addRow(fila); // Añade una fila al final
            }

        
        // LLENAR LA TABLA
        
        
        JScrollPane scrollPane = new JScrollPane(tabla); //************************************************ SCROLL PABEL TABLA
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(5, 5, 500, 590);
        contentPane.setPreferredSize(new Dimension(800, 600));
        contentPane.setBackground(new Color(0x15576B));
        contentPane.add(scrollPane);
    }
    
    private void Clicks(){
        // DETECTAR LA POSICIÓN SELECCIONADA
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Posicion = tabla.rowAtPoint(e.getPoint());
                int columna = tabla.columnAtPoint(e.getPoint());
                if ((Posicion > -1) && (columna > -1)) {
                    panelGeneral.setVisible(false);
                    panelEditar.setVisible(false);
                    System.out.println(String.valueOf(fila));
                    lblName.setText((String) modelo.getValueAt(Posicion, 0));
                    lblPrecio.setText((String) modelo.getValueAt(Posicion, 1));
                    lblCupo.setText((String) modelo.getValueAt(Posicion, 2));
                    lblHoraInicio.setText((String) con[Posicion].getHoraInicial().toString());
                    lblHoraFinal.setText((String) con[Posicion].getHoraFinalizacion().toString());
                    panelDetalles.setVisible(true);
                    panelBotones.setVisible(true);
                }
            }
        });
        
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetalles.setVisible(false);
                panelEditar.setVisible(true);
            }
        });
        
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        PreparedStatement eliminarD = cn.prepareStatement("DELETE FROM detalles_conferencia WHERE ID_Conferencia = ?");
                        eliminarD.setInt(1,con[Posicion].getIdConferencia());
                        //guardo el resultado en res
                        eliminarD.executeUpdate();
                        
                        PreparedStatement eliminarC = cn.prepareStatement("DELETE FROM conferencia WHERE ID_Conferencia = ?");
                        eliminarC.setInt(1,con[Posicion].getIdConferencia());
                        //guardo el resultado en res
                        eliminarC.executeUpdate();
                        
                        modelo.removeRow(Posicion);
                        
                        usuario = null;
                        usuario = new conferenciaBD();
                        con = null;
                        con = new conferencia[usuario.getConferencias(id).length];
                        
                        for (int i = 0; i < con.length; i++) {
                            con[i] = usuario.getConferencias(id)[i];
                        }
                        
                        JOptionPane.showMessageDialog(null, "Eliminado con Exito");
                    } catch (SQLException ex) {
                        //verifica que se haya realizado con exito
                        JOptionPane.showMessageDialog(null, "Algo salio mal al guardar los datos");
                    }
                
                panelDetalles.setVisible(false);
                panelEditar.setVisible(false);
                panelBotones.setVisible(false);
                panelGeneral.setVisible(true);
            }
        });
    }
    
    private void panelBotones(){
        panelBotones.setLayout(null);
        panelBotones.setBounds(500,500, 300,100);
        panelBotones.setBackground(Color.red);
        
        
                btnEditar.setBounds(0, 0, 300, 50);

        btnEliminar.setBounds(0, 50, 300, 50);

        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);

    }
    
    private void panelDetalles(){
        panelDetalles.setLayout(null);
        panelDetalles.setBounds(500,0, 300,550);
        panelDetalles.setBackground(new Color(0x15576B));
        
                Mostrar(panelDetalles);

        // ACOMODO DE LABELS
        lblName.setBounds(110,25,200,25);
        lblName.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblName.setForeground(new Color(0x08A2C1));
        panelDetalles.add(lblName);
        
        lblPrecio.setBounds(110,100,200,25);
        lblPrecio.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblPrecio.setForeground(new Color(0x08A2C1));
        panelDetalles.add(lblPrecio);
        
        lblCupo.setBounds(110,175,200,25);
        lblCupo.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblCupo.setForeground(new Color(0x08A2C1));
        panelDetalles.add(lblCupo);
        
        lblHoraInicio.setBounds(110,250,200,25);
        lblHoraInicio.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblHoraInicio.setForeground(new Color(0x08A2C1));
        panelDetalles.add(lblHoraInicio);
        
        lblHoraFinal.setBounds(110,325,200,25);
        lblHoraFinal.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblHoraFinal.setForeground(new Color(0x08A2C1));
        panelDetalles.add(lblHoraFinal);
    }
    
    private void panelEditar(){
        panelEditar.setLayout(null);
        panelEditar.setBounds(500,0, 300,500);
        panelEditar.setBackground(new Color(0x15576B));
        
        // ACOMODO DE LABELS
        Mostrar(panelEditar);
        
        txtName.setBounds(110,20,100,25);
        txtName.setFont(new Font("Javanese Text", Font.BOLD, 20));
        txtName.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtName);
        
        txtPrecio.setBounds(110,95,100,25);
        txtPrecio.setFont(new Font("Javanese Text", Font.BOLD, 20));
        txtPrecio.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtPrecio);
        
        txtCupo.setBounds(110,170,100,25);
        txtCupo.setFont(new Font("Javanese Text", Font.BOLD, 20));
        txtCupo.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtCupo);
        
        txtHoraInicio.setBounds(145,245,145,25);
        txtHoraInicio.setFont(new Font("Javanese Text", Font.BOLD, 20));
        txtHoraInicio.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtHoraInicio);
        
        txtHoraFinal.setBounds(140,320,150,25);
        txtHoraFinal.setFont(new Font("Javanese Text", Font.BOLD, 20));
        txtHoraFinal.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtHoraFinal);
    }
    
    private void Mostrar(JPanel pPanel){
        JLabel lblNameM = new JLabel("Nombre: "); //************************************************************ Mostrar Nombre
        lblNameM.setBounds(25,25,200,25);
        lblNameM.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblNameM.setForeground(new Color(0x08A2C1));
        pPanel.add(lblNameM);
        
        JLabel lblPrecioM = new JLabel("Precio: "); //************************************************************ Mostrar Precio
        lblPrecioM.setBounds(25,100,200,25);
        lblPrecioM.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblPrecioM.setForeground(new Color(0x08A2C1));
        pPanel.add(lblPrecioM);
        
        JLabel lblCupoM = new JLabel("Cupo: "); //************************************************************ Mostrar Cupo
        lblCupoM.setBounds(25,175,200,25);
        lblCupoM.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblCupoM.setForeground(new Color(0x08A2C1));
        pPanel.add(lblCupoM);
        
        
        JLabel lblHoraInicioM = new JLabel("Hora Inicio: "); //************************************************************ Mostrar Cupo
        lblHoraInicioM.setBounds(25,250,200,25);
        lblHoraInicioM.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblHoraInicioM.setForeground(new Color(0x08A2C1));
        pPanel.add(lblHoraInicioM);
        
        
        JLabel lblHoraFinalM = new JLabel("Hora Final: "); //************************************************************ Mostrar Cupo
        lblHoraFinalM.setBounds(25,325,200,25);
        lblHoraFinalM.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblHoraFinalM.setForeground(new Color(0x08A2C1));
        pPanel.add(lblHoraFinalM);
    }
}
