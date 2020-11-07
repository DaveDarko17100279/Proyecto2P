
package Views;

import BD.conexion;
import BD.conferenciaBD;
import BD.usuarioGeneralBD;
import Models.conferencia;
import Models.conferencia_participante;
import Models.usuarioGeneral;
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
import java.util.Random;
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
   // Connection con = conexion.getConnection();
    int ID_u;
    private JTable jTableEjemplo = new JTable();
    
    public DetallesConferenciaAjena (int ID_u) {
        init();
        this.ID_u = ID_u;
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
        
        conferenciaBD confe = new conferenciaBD();
        ArrayList<conferencia> conferencias = confe.consultarConferencia();
        
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
           
      public void  inscribir_onclick(int ID_c, int Precio){
         
         /*CONSULTA PARTICIPANTES DE CONFERENCIAS Y USUARIOS*/
          //ArrayList<conferencia_participante> participantes = consultarParticipantes(ID_c, true);
                conferenciaBD particiP = new conferenciaBD();
                ArrayList<conferencia_participante> participantes = particiP.consultarParticipantes(ID_c, true);
          
                usuarioGeneralBD user = new usuarioGeneralBD();
                usuarioGeneral usuario = user.getUsuarioByID(5);
            
          /*GENERAR CODIGO DE PARTICIPANTE*/
             boolean repetido = false;
             int Codigo_p = 0;
          do{
                Random r = new Random(); 
                int low = 1001;
                int high = 9999;
                Codigo_p = r.nextInt(high-low) + low;
            
                   //  ArrayList<conferencia_participante> Tparticipantes = consultarParticipantes(ID_c, false);
                   //ArrayList<conferencia_participante> Tparticipantes = new  ArrayList<>();
              
                conferenciaBD particip = new conferenciaBD();
                ArrayList<conferencia_participante> Tparticipantes = particip.consultarParticipantes(ID_c, false);
                           
                 for(conferencia_participante Tpar:Tparticipantes){
                        if(Codigo_p == Tpar.getID_CP()){
                             repetido = true;
                             break;
                        }else{
                             repetido = false;
                             }
                        }
            }while(repetido == true);
           
           /*COMPROBAR QUE EL USUARIO NO ESTE YA INSCRITÓ*/
          if(participantes.size() > 0){
               JOptionPane.showMessageDialog(null, "Usted ya esta inscrito en esta conferencia");
           /*COMPROBAR QUE EL USUARIO TENGA DINERO SUFICIENTE*/
          }else if(usuario.getZenis() < Precio){
              JOptionPane.showMessageDialog(null, "Zenis insuficientes, sus Zenis: $" + usuario.getZenis() + ", Precio: " + Precio);
          }else{
              
              int Zenis = usuario.getZenis() - Precio;
              
              //actualizarZenis(Zenis, 5);
              usuarioGeneralBD zen = new  usuarioGeneralBD() ;
              zen.actualizarZenis(Zenis, 5);
              
              //InsertarParticipante(5, ID_c, Codigo_p);
              conferenciaBD inPar = new conferenciaBD();
              inPar.InsertarParticipante(5, ID_c, Codigo_p);
              
              JOptionPane.showMessageDialog(null, "Inscripción exitosa!!!");
          }
      }
}
