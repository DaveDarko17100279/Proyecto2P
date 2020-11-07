package Views;

import DB.ConferenciasInsBD;
import Models.conferencia;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.DISPOSE_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConferenciasIns extends JFrame {
    
     int ID_u;
    private JTable jTableEjemplo = new JTable();
    
    public ConferenciasIns (int ID_u) {
        this.ID_u = ID_u;
        init();
    }
    
     private void init() {
     
        // CONFIGURAR EL JFRAME
        setTitle("Conferencias en las que estoy inscrito");
        setResizable(false);
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // CONFIGURAR LA TABLA
        DefaultTableModel modelo = new DefaultTableModel();
        JTable tabla = new JTable(modelo);
        
       // tabla.setEnabled(false);
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre Conferencia");
        modelo.addColumn("Fecha");
        modelo.addColumn("Precio");
        
        // DECLARACION DE PANELES
        JPanel panel = new JPanel(); //******************************************************************* PANEL INFORMACIÓN
        panel.setLayout(null);
        panel.setBounds(500,0, 400,800);
        panel.setBackground(new Color(0x15576B));
        
        JScrollPane scrollPane = new JScrollPane(tabla); //************************************************ SCROLL PANEL TABLA
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 500, 600);
        
        JPanel contentPane = new JPanel(null); // ********************************************************* PANEL CONTENEDOR
        contentPane.setPreferredSize(new Dimension(800, 600));
        contentPane.add(scrollPane);

        // LLENAR LA TABLA
        Object[] fila = new Object[4]; //Columnas
        
        ConferenciasInsBD confe = new ConferenciasInsBD(ID_u);
        ArrayList<conferencia> conferencias = confe.getConferenciasIns();
     
        for(conferencia conferencia:conferencias) {//Debera ser el largo del arreglo del modelo.
           //Mostrar de la BD 
            System.out.print(String.valueOf(conferencia.getIdConferencia()));
           
           fila[0] = String.valueOf(conferencia.getIdConferencia());      //ID
           fila[1] = String.valueOf(conferencia.getNombreConferencia());  //Nombre
           fila[2] = String.valueOf(conferencia.getFechaPresentacion());  //Fecha 
           fila[3] = String.valueOf(conferencia.getPrecio());             //precio
            modelo.addRow(fila); // Añade una fila al final
        }
        
        // ACOMODO DE LABELS
        
        JLabel lblSe = new JLabel(); //**************************************************************************** Selección
        lblSe.setBounds(30,50,400,30);
        lblSe.setFont(new Font("Javanese Text", Font.BOLD, 17));
        lblSe.setForeground(new Color(0x00000));
        lblSe.setText("Selecciona\n " +" una\n " + " conferencia!!!");
        panel.add(lblSe);
        
        JLabel lblName = new JLabel(); //**************************************************************************** Nombre
        lblName.setBounds(50,50,300,30);
        lblName.setFont(new Font("Javanese Text", Font.BOLD, 25));
        lblName.setForeground(new Color(0x00000));
        panel.add(lblName);
       
       
        JLabel lblPre = new JLabel(); //**************************************************************************** Precio_etiqueta
        lblPre.setBounds(50,100,100,25);
        lblPre.setFont(new Font("Javanese Text", Font.ITALIC, 20));
        lblPre.setForeground(new Color(0x00000));
        panel.add(lblPre);
        
        JLabel lblPrecio = new JLabel(); //**************************************************************************** Precio
        lblPrecio.setBounds(125,100,200,25);
        lblPrecio.setFont(new Font("Javanese Text", Font.ITALIC, 20));
        lblPrecio.setForeground(new Color(0x00000));
        panel.add(lblPrecio);
        
         JLabel lblFecha = new JLabel(); //**************************************************************************** Fecha
        lblFecha.setBounds(50,140,200,25);
        lblFecha.setFont(new Font("Javanese Text", Font.ITALIC, 20));
        lblFecha.setForeground(new Color(0x00000));
        panel.add(lblFecha);
        
         JLabel lblCupo = new JLabel(); //**************************************************************************** Cupo
        lblCupo.setBounds(50,180,200,25);
        lblCupo.setFont(new Font("Javanese Text", Font.ITALIC, 20));
        lblCupo.setForeground(new Color(0x00000));
        panel.add(lblCupo);
        
         JLabel lblHoras = new JLabel(); //**************************************************************************** Duración
        lblHoras.setBounds(50,220,200,25);
        lblHoras.setFont(new Font("Javanese Text", Font.BOLD, 20));
        lblHoras.setForeground(new Color(0x00000));
        panel.add(lblHoras); 
        
        JLabel lblInicio = new JLabel(); //**************************************************************************** Hora inicio
        lblInicio.setBounds(50,260,200,25);
        lblInicio.setFont(new Font("Javanese Text", Font.ITALIC, 20));
        lblInicio.setForeground(new Color(0x00000));
        panel.add(lblInicio);
        
         JLabel lblFin = new JLabel(); //**************************************************************************** Hora Fin
        lblFin.setBounds(50,300,200,25);
        lblFin.setFont(new Font("Javanese Text", Font.ITALIC, 20));
        lblFin.setForeground(new Color(0x00000));
        panel.add(lblFin);
        
        JLabel lblP = new JLabel(); //**************************************************************************** ID_conferencia
        lblP.setBounds(50,300,200,25);
        lblP.setFont(new Font("Javanese Text", Font.ITALIC, 20));
        lblP.setForeground(new Color(0x00000));
        lblP.setVisible(false);
        panel.add(lblP);
        
        // DETECTAR LA POSICIÓN SELECCIONADA
        tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int fila = tabla.rowAtPoint(e.getPoint());
                int columna = tabla.columnAtPoint(e.getPoint());
                if ((fila > -1) && (columna > -1)) {
                    //lblName.setText((String) modelo.getValueAt(fila, columna));
                    lblP.setText((String) modelo.getValueAt(fila, 0));    // ID_conferencia
                    
                    lblSe.setText("");
                    lblName.setText((String) modelo.getValueAt(fila, 1)); //Nombre conferencia
                    lblFecha.setText("Fecha: " + (String) modelo.getValueAt(fila, 2)); // Fecha
                    lblPre.setText("Precio: $"); 
                    lblPrecio.setText((String) modelo.getValueAt(fila, 3)); // Precio
                  
                   conferencias.forEach((n) -> {
                     int id = n.getIdConferencia();
                       if(id ==   Integer.valueOf((String) modelo.getValueAt(fila, 0))){
                    
                           int cupo = n.getCupoTotal();
                           lblCupo.setText("Cupo total: " + String.valueOf(cupo));    //Cupo
                           lblHoras.setText("Duración");
                           
                       Time horaI = n.getHoraInicial();
                       lblInicio.setText(String.valueOf(horaI)); //HoraInicio
                    
                        Time horaF = n.getHoraFinalizacion();
                        lblFin.setText(String.valueOf(horaF));   //HoraFin
                       
                       }
                   });
                }
            }
        });
        
        // CONFIGURACIÓN FINAL AL JFRAME
        setContentPane(contentPane);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setVisible(true);
    }
}
