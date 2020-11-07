package Views;




import Administracion.conferenciaAdmin;
import BD.conexion;
import BD.conferenciaBD;
import Models.conferencia;
import Models.usuarioGeneral;
import java.awt.Color;
import Formatos.JTextFieldHint;
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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author DaveDarko
 */
public class VConferencia extends JFrame {

    private Connection cn = new conexion().getConnection();
    
    private int id;
    
    private conferenciaBD usuario = new conferenciaBD();
    private conferencia[] con;
    
    private Object[] fila = new Object[3];
    
    private conferencia confer;
    private usuarioGeneral user;
    
    private int cantidad;
    private int Posicion;
    
    private DefaultTableModel modelo = new DefaultTableModel();
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
    private JLabel lblFecha = new JLabel(); //**************************************************************************** Nombre

    private JTextField txtName = new JTextField(); //**************************************************************************** Nombre
    private JTextFieldHint txtPrecio = new JTextFieldHint(); //**************************************************************************** Nombre
    private JTextField txtCupo = new JTextField(); //**************************************************************************** Nombre
    private JTextFieldHint txtHourStart = new JTextFieldHint(); //**************************************************************************** Nombre
    private JTextFieldHint txtHourFinish = new JTextFieldHint(); //**************************************************************************** Nombre
    private JTextFieldHint txtMinStart = new JTextFieldHint(); //**************************************************************************** Nombre
    private JTextFieldHint txtMinFinish = new JTextFieldHint(); //**************************************************************************** Nombre
    private JTextFieldHint txtYear = new JTextFieldHint(); //**************************************************************************** Nombre
    private JTextFieldHint txtMonth = new JTextFieldHint(); //**************************************************************************** Nombre
    private JTextFieldHint txtDay = new JTextFieldHint(); //**************************************************************************** Nombre

    private JButton btnEditar = new JButton("Editar Conferencia");
    private JButton btnEliminar = new JButton("Eliminar Conferencia");
    private JButton btnUpdate = new JButton("Confirmar");

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
        
            cantidad = con.length;
            for(int i = 0; i < cantidad; i++){
                con[i] = usuario.getConferencias(id)[i];
            }
            
            

        
        // LLENAR LA TABLA
        llenarTabla();
        
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
                    lblFecha.setText((String) con[Posicion].getFechaPresentacion().toString());
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
                if (usuario.eliminarConferencias(con[Posicion].getIdConferencia())) {
                    modelo.removeRow(Posicion);
                    actualizarTabla();
                }
                panelDetalles.setVisible(false);
                panelEditar.setVisible(false);
                panelBotones.setVisible(false);
                panelGeneral.setVisible(true);
            }
        });
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validDatos()) {
                    clean();
                }
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
        
        lblFecha.setBounds(110,400,200,25);
        lblFecha.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblFecha.setForeground(new Color(0x08A2C1));
        panelDetalles.add(lblFecha);
    }
    
    private void panelEditar(){
        panelEditar.setLayout(null);
        panelEditar.setBounds(500,0, 300,500);
        panelEditar.setBackground(new Color(0x15576B));
        
        // ACOMODO DE LABELS
        Mostrar(panelEditar);
        
        // Hints config
        txtYear.setHint("AAAA");
        txtMonth.setHint("MM");
        txtDay.setHint("DD");
        txtHourStart.setHint("HH");
        txtMinStart.setHint("MM");
        txtHourFinish.setHint("HH");
        txtMinFinish.setHint("MM");
        
        Font fontText = new Font("Segoe UI Light", 1, 16);
        
        txtName.setBounds(110,20,180,25);
        txtName.setFont(fontText);
        txtName.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtName);
        
        txtPrecio.setBounds(110,95,180,25);
        txtPrecio.setFont(fontText);
        txtPrecio.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtPrecio);
        
        txtCupo.setBounds(110,170,180,25);
        txtCupo.setFont(fontText);
        txtCupo.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtCupo);
        
        txtHourStart.setBounds(110,245,85,25);
        txtHourStart.setFont(fontText);
        txtHourStart.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtHourStart);
        
        txtMinStart.setBounds(205,245,85,25);
        txtMinStart.setFont(fontText);
        txtMinStart.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtMinStart);
        
        txtMinFinish.setBounds(110,320,85,25);
        txtMinFinish.setFont(fontText);
        txtMinFinish.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtMinFinish);
        
        txtHourFinish.setBounds(205,320,85,25);
        txtHourFinish.setFont(fontText);
        txtHourFinish.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtHourFinish);
        
        txtYear.setBounds(110,395,55,25);
        txtYear.setFont(fontText);
        txtYear.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtYear);
        
        txtMonth.setBounds(173,395,55,25);
        txtMonth.setFont(fontText);
        txtMonth.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtMonth);
        
        txtDay.setBounds(235,395,55,25);
        txtDay.setFont(fontText);
        txtDay.setForeground(new Color(0x08A2C1));
        panelEditar.add(txtDay);
        
        btnUpdate.setBounds(25, 440, 265, 30);
        panelEditar.add(btnUpdate);
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
        
        
        JLabel lblHoraInicioM = new JLabel("Inicio: "); //************************************************************ Mostrar Cupo
        lblHoraInicioM.setBounds(25,250,200,25);
        lblHoraInicioM.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblHoraInicioM.setForeground(new Color(0x08A2C1));
        pPanel.add(lblHoraInicioM);
        
        
        JLabel lblHoraFinalM = new JLabel("Final: "); //************************************************************ Mostrar Cupo
        lblHoraFinalM.setBounds(25,325,200,25);
        lblHoraFinalM.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblHoraFinalM.setForeground(new Color(0x08A2C1));
        pPanel.add(lblHoraFinalM);
        
        JLabel lblFechaM = new JLabel("Fecha: "); //************************************************************ Mostrar Cupo
        lblFechaM.setBounds(25,400,300,25);
        lblFechaM.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblFechaM.setForeground(new Color(0x08A2C1));
        pPanel.add(lblFechaM);
    }
    
    private boolean validDatos() {
        String name;
        int cupo;
        int price;
        boolean costo;
        String strDate;
        Date date;
        String strTimeStart;
        Time timeStart;
        String strTimeFinish;
        Time timeFinish;
        int year;
        int month;
        int day;
        int hourStart;
        int minStart;
        int hourFinish;
        int minFinish;
        
        if(
                txtName.getText().isEmpty() || 
                txtCupo.getText().isEmpty() || 
                txtPrecio.getText().isEmpty() ||
                txtYear.getText().isEmpty() ||
                txtMonth.getText().isEmpty() ||
                txtDay.getText().isEmpty() ||
                txtHourStart.getText().isEmpty() ||
                txtMinStart.getText().isEmpty() ||
                txtHourFinish.getText().isEmpty() ||
                txtMinFinish.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            return false;
        }
        
        name = txtName.getText();
        
        try{
            cupo = Integer.parseInt(txtCupo.getText());
            price = Integer.parseInt(txtPrecio.getText());
            year = Integer.parseInt(txtYear.getText());
            month = Integer.parseInt(txtMonth.getText());
            day = Integer.parseInt(txtDay.getText());
            hourStart = Integer.parseInt(txtHourStart.getText());
            minStart = Integer.parseInt(txtMinStart.getText());
            hourFinish = Integer.parseInt(txtHourFinish.getText());
            minFinish = Integer.parseInt(txtMinFinish.getText());
        } catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Datos numericos invalidos");
            return false; 
        }
        
        if(cupo <= 0) {
            JOptionPane.showMessageDialog(null, "Cupo debe ser mayor a 0");
            return false;
        }
        
        if(price < 0) {
            JOptionPane.showMessageDialog(null, "Precio debe ser igual o mayor a 0");
            return false;
        }
        
        costo = price != 0;
        
        if(year < 2020) {
            JOptionPane.showMessageDialog(null, "Imposible viajar en el tiempo");
            return false;
        }
        
        if(month > 12 || month == 0) {
            JOptionPane.showMessageDialog(null, "Formato de mes invalido");
            return false;
        }
        
        if(day > 30 || day == 0) {
            JOptionPane.showMessageDialog(null, "Formato de dia invalido");
            return false;
        }
        
        strDate = Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day);
        
        date = Date.valueOf(strDate);
        
        if(hourStart > 23 || hourStart < 0 || minStart > 59|| minStart < 0) {
            JOptionPane.showMessageDialog(null, "Formato de hora de inicio invalido");
            return false;
        }
        
        if(hourFinish > 23 || minFinish > 59) {
            JOptionPane.showMessageDialog(null, "Formato de hora de finalización invalido");
            return false;
        }
        
        strTimeStart = Integer.toString(hourStart) + ":" + Integer.toString(minStart) + ":00";
        strTimeFinish = Integer.toString(hourFinish) + ":" + Integer.toString(minFinish) + ":00";
        
        timeStart = Time.valueOf(strTimeStart);
        timeFinish = Time.valueOf(strTimeFinish);
        
        System.out.println(date + " " + timeStart + " " + timeFinish);
        
        confer = new conferencia(con[Posicion].getIdConferencia(), name, cupo, price, costo, date, timeStart, timeFinish);

        if(usuario.actualizarConferencia(confer)){
            // Eliminar Registros
            while(cantidad != 0){
                modelo.removeRow(cantidad - 1);
                cantidad -= 1;
            }
            
            actualizarTabla();
            llenarTabla();
        }

        
        return true;
    }
    
    private void clean() {
        txtName.setText("");
        txtCupo.setText("");
        txtPrecio.setText("");
        txtYear.setText("");
        txtMonth.setText("");
        txtDay.setText("");
        txtHourStart.setText("");
        txtMinStart.setText("");
        txtHourFinish.setText("");
        txtMinFinish.setText("");
    }

    
    private void actualizarTabla(){
        usuario = null;
        usuario = new conferenciaBD();
        con = null;
        con = new conferencia[usuario.getConferencias(id).length];
        cantidad = con.length;
        for (int i = 0; i < con.length; i++) {
            con[i] = usuario.getConferencias(id)[i];
        }
    }
    
    private void llenarTabla(){
        for(int i = 0; i < con.length; i++){
                fila[0] = con[i].getNombreConferencia();
                fila[1] = String.valueOf(con[i].getPrecio());
                fila[2] = String.valueOf(con[i].getCupoTotal());
                modelo.addRow(fila); // Añade una fila al final
            }
    }
}


