
package Views;

import BD.conexion;
import Models.conferencia;
import Models.conferencia_participante;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/*DETALLES DE CONFERENCIAS NO CREADAS POR EL USUARIO ACTUAL*/
public class DetallesConferenciaAjena extends JFrame {
    Connection con = conexion.getConnection();
    
    private JTable jTableEjemplo = new JTable();
    
    public DetallesConferenciaAjena () {
        init();
        
    }
    
     private void init() {
     
        // CONFIGURAR EL JFRAME
        setTitle("Conferencias");
        setResizable(false);
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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
        
        JScrollPane scrollPane = new JScrollPane(tabla); //************************************************ SCROLL PABEL TABLA
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 500, 600);
        
        JPanel contentPane = new JPanel(null); // ********************************************************* PANEL CONTENEDOR
        contentPane.setPreferredSize(new Dimension(800, 600));
        contentPane.add(scrollPane);

        // LLENAR LA TABLA
        Object[] fila = new Object[4]; //Columnas
        
        ArrayList<conferencia> conferencias = consultarConferencia();
        
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
       
        JLabel lblPrecio = new JLabel(); //**************************************************************************** Precio
        lblPrecio.setBounds(50,100,200,25);
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
        
        JButton BtnInscribir = new JButton(); //**************************************************************************** Inscribirse
        BtnInscribir.setBounds(50,500,200,40);
        BtnInscribir.setFont(new Font("Javanese Text", Font.BOLD, 20));
        BtnInscribir.setForeground(new Color(0x00000));
        BtnInscribir.setText("Inscribirse");
       BtnInscribir.addActionListener
        (
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        int ID_c = Integer.valueOf(lblP.getText());
                        int Precio = Integer.valueOf(lblPrecio.getText());
                        inscribir_onclick(ID_c, Precio);
                    }
                }
        );
        
        panel.add(BtnInscribir);

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
                    lblPrecio.setText("Precio: $" + (String) modelo.getValueAt(fila, 3)); // Precio
                  
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
     
     
      public ArrayList<conferencia> consultarConferencia() 
    {
        ArrayList<conferencia> conferencias = new ArrayList<conferencia>();
        ResultSet salida;
        conferencia conf;
        try 
        {
            PreparedStatement sql = con.prepareStatement("SELECT conferencia.ID_Conferencia, conferencia.ID_Usuario, conferencia.Nombre_Conferencia, conferencia.Cupo_Total, conferencia.Precio, detalles_conferencia.Fecha_Presentacion, detalles_conferencia.Hora_Inicial, detalles_conferencia.Hora_Finalizacion FROM conferencia INNER JOIN detalles_conferencia ON conferencia.ID_Conferencia = detalles_conferencia.ID_Conferencia WHERE conferencia.ID_Usuario != ?");            
             sql.setInt(1,5);
            salida = sql.executeQuery();
        
            while(salida.next())
            {
                conf = new conferencia();
                conf.setIdUsuario(salida.getInt("conferencia.ID_Usuario"));
                conf.setIdConferencia(salida.getInt("conferencia.ID_Conferencia"));
                conf.setNombreConferencia(salida.getString("conferencia.Nombre_Conferencia"));
                conf.setCupoTotal(salida.getInt("conferencia.Cupo_Total"));
                conf.setPrecio(salida.getInt("conferencia.Precio"));
                conf.setFechaPresentacion(salida.getDate("detalles_conferencia.Fecha_Presentacion"));
                conf.setHoraInicial(salida.getTime("detalles_conferencia.Hora_Inicial"));
                conf.setHoraFinalizacion(salida.getTime("detalles_conferencia.Hora_Finalizacion"));
               // conf.setCosto(salida.getBoolean("conferencia.Costo"));
               
                 System.out.println(salida.next());
                 conferencias.add(conf);
                System.out.println("Agregado");
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return conferencias;
    }
      
      public ArrayList<conferencia_participante> consultarParticipantes(int ID_c) 
    {
        ArrayList<conferencia_participante> participantes = new ArrayList<>();
        ResultSet salida;
        conferencia_participante part;
        try 
        {
            PreparedStatement sql = con.prepareStatement("SELECT * FROM conferencia_participante  WHERE ID_Usuario = ? AND ID_Conferencia = ?");            
             sql.setInt(1,6);
             sql.setInt(2,ID_c);
            salida = sql.executeQuery();
        
            while(salida.next())
            {
                part = new conferencia_participante();
                part.setID_Usuario(salida.getInt("ID_Usuario"));
                part.setID_Conferencia(salida.getInt("ID_Conferencia"));
                part.setCodigo_Participante(salida.getInt("Codigo_Participante"));
               
                participantes.add(part);
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return participantes;
    }
      
      
      public void  inscribir_onclick(int ID_c, int Precio){
         
          //Crear Modelo tabla conferencia_participante. LISTO READY
          //Leer participantes.                          LISTO READY
          //Comprobar si el usuario ya esta dentro.      LISTO READY
          
          //Leer usuarios.
          //Verificar zenis sea mayor o igual a precio.
          
          //Generar código participante.
          //verificar que no se repita en conferencia_participante.
          
          //Insertar en conferencia_participante.
          
          /*COMPROBAR QUE EL USUARIO NO ESTE YA INSCRITÓ*/
          ArrayList<conferencia_participante> participantes = consultarParticipantes(ID_c);
          if(participantes.size() > 0){
               JOptionPane.showMessageDialog(null, "Usted ya esta inscrito en esta conferencia");
          }else{
            
              
              
              JOptionPane.showMessageDialog(null, "Inscripción exitosa!!!");
          }
          
      }
}
