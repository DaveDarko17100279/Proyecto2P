package Views;

import Formatos.*;
import BD.ConferenciasInsBD;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Pris
 */
public class ConferenciasIns extends JFrame {
    
    JPanel Botones  = new RoundedPanel(30, new Color(255, 252, 255, 200));
    JPanel Titulo  = new RoundedPanel(90, new Color(255, 252, 255, 250));
    JPanel Borde = new RoundedPanel(0, new Color(255, 252, 255, 200));
    JButton login = new Botones("MENOS");
    JButton detalles = new Botones("DETALLES");
    JButton Siguiente = new Botones(">");
    JButton Anterior = new Botones("<");
    FondoPanel fondo = new FondoPanel();
    JLabel Title = new JLabel("M I S  C O N F E R E N C I A S");
    JLabel Nombre = new JLabel("CONFERENCIA");
    JLabel ID = new JLabel("ID");    
    JLabel Cupo = new JLabel("CUPO TOTAL");
    JLabel Precio  = new JLabel("PRECIO");
    JLabel Fecha  = new JLabel("FECHA");
    JLabel horaInicio  = new JLabel("INICIA");
    JLabel horaFinal  = new JLabel("FINALIZA");
    
    JLabel NombreM = new JLabel("");
    JLabel IDM = new JLabel("ID");    
    JLabel CupoM = new JLabel("");
    JLabel PrecioM  = new JLabel("");
    JLabel FechaM  = new JLabel("");
    JLabel horaInicioM  = new JLabel("");
    JLabel horaFinalM  = new JLabel("");
    
    
    int pos;
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String fechaComoCadena;
 

     public ConferenciasIns () {
        //titulo de la ventana
        setTitle("Index");
        //tamaño de la ventana
        setSize(1000,703);
        //Se podra redimencionar
        setResizable(false);
        //Localizacion
        setLocationRelativeTo(null);
        //Salir
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setContentPane(fondo);
        //Crear la interfaz
         pos = 0;
         ShowPosInfo(pos);
        init();
        transparenciaButton();
        
    }
     
      
     private void init() {
        // Layout 
        this.setLayout(null);
        BordeRedondo border = new BordeRedondo(40); // radio = 10

                        
        Botones.setLayout(null);
        Botones.setBounds (175, 170, 650, 215);
        Botones.setOpaque(false);
        
        Titulo.setLayout(null);
        Titulo.setBounds(10, 20, 1050, 100);
        Titulo.setOpaque(false);
        
        Title.setBounds(320, 30, 1050, 45);
        Title.setForeground(new Color (12, 8, 12, 100));
        Title.setFont(new java.awt.Font("Segoe UI Light", 1, 25));
       
        
        Nombre.setBounds(50, 20, 150, 45);
        Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Nombre.setForeground(new Color (12, 8, 12, 120));
        Nombre.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
        
        Cupo.setBounds(200, 20, 150, 45);
        Cupo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cupo.setForeground(new Color (12, 8, 12, 120));
        Cupo.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
        
        Precio.setBounds(330, 20, 150, 45);
        Precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Precio.setForeground(new Color (12, 8, 12, 120));
        Precio.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
        
        NombreM.setBounds(50, 60, 150, 45);
        NombreM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NombreM.setForeground(new Color (12, 8, 12, 100));
        NombreM.setFont(new java.awt.Font("Segoe UI Light", 1, 15));
        
        CupoM.setBounds(200, 60, 150, 45);
        CupoM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CupoM.setForeground(new Color (12, 8, 12, 100));
        CupoM.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
        
        PrecioM.setBounds(330, 60, 150, 45);
        PrecioM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PrecioM.setForeground(new Color (12, 8, 12, 100));
        PrecioM.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
        
        detalles.setBounds(430, 110, 150, 45);
        detalles.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        detalles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        detalles.setBorder(border);
        detalles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        Anterior.setBounds(200, 145, 100, 45);
        Anterior.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Anterior.setBorder(border);
        Anterior.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        Siguiente.setBounds(300, 145, 100, 45);
        Siguiente.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
        Siguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Siguiente.setBorder(border);
        Siguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        Botones.add(login);
        Botones.add(detalles);
        Botones.add(Nombre);
        Botones.add(Cupo);
        Botones.add(Precio);
        Botones.add(NombreM);
        Botones.add(CupoM);
        Botones.add(PrecioM);
        Botones.add(Anterior);
        Botones.add(Siguiente);
        Titulo.add(Title);
        getContentPane().add(Botones);
        getContentPane().add(Titulo);
        getContentPane().add(Borde);
        
        detalles.addActionListener (
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                     
                        detalles.setVisible(false);
                        
                        Botones.setLayout(null);
                        Botones.setBounds (175, 170, 650, 315);
                        Botones.setOpaque(false);
                        
                        Fecha.setBounds(450, 20, 150, 45);
                        Fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        Fecha.setForeground(new Color (12, 8, 12, 120));
                        Fecha.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
                        
                        horaInicio.setBounds(50, 100, 150, 45);
                        horaInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        horaInicio.setForeground(new Color (12, 8, 12, 120));
                        horaInicio.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
                        
                        horaFinal.setBounds(200, 100, 150, 45);
                        horaFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        horaFinal.setForeground(new Color (12, 8, 12, 120));
                        horaFinal.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
                        
                        FechaM.setBounds(450, 60, 140, 45);
                        FechaM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        FechaM.setForeground(new Color (12, 8, 12, 100));
                        FechaM.setFont(new java.awt.Font("Segoe UI Light", 1, 15));
                        
                        horaInicioM.setBounds(50, 140, 150, 45);
                        horaInicioM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        horaInicioM.setForeground(new Color (12, 8, 12, 100));
                        horaInicioM.setFont(new java.awt.Font("Segoe UI Light", 1, 15));
                        
                        horaFinalM.setBounds(200, 140, 150, 45);
                        horaFinalM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        horaFinalM.setForeground(new Color (12, 8, 12, 100));
                        horaFinalM.setFont(new java.awt.Font("Segoe UI Light", 1, 14));
                        
                        Anterior.setBounds(200, 245, 100, 45);
                        Anterior.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
                        Anterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        Anterior.setBorder(border);
                        Anterior.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                        Siguiente.setBounds(300, 245, 100, 45);
                        Siguiente.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
                        Siguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        Siguiente.setBorder(border);
                        Siguiente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                                
                        login.setBounds(430, 200, 150, 45);
                        login.setFont(new java.awt.Font("Segoe UI Light", 1, 13));
                        login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        login.setBorder(border);
                        login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                        Botones.add(horaInicio);
                        Botones.add(horaFinal);
                        Botones.add(login);
                        Botones.add(Fecha);
                        Botones.add(horaInicioM);
                        Botones.add(horaFinalM);
                        Botones.add(FechaM);
                    }
                }
        );
        
         Siguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  pos++;
                  if(pos < new ConferenciasInsBD().BindList().size()){
                      ShowPosInfo(pos);
                  }
                  else{
                      pos = new ConferenciasInsBD().BindList().size() - 1;
                      ShowPosInfo(pos);
                      JOptionPane.showMessageDialog(null, "END");
                  }
            }

         });
         
         Anterior.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e){

                pos--;
                if(pos > 0){
                    ShowPosInfo(pos);                
                }
                else{
                    pos = 0;
                    ShowPosInfo(pos);
                    JOptionPane.showMessageDialog(null, "END");
                }
            }
        });
         
      
        
        
    }
     
      public void ShowPosInfo(int index){
          
          if(new ConferenciasInsBD().BindList().size() == 0){
              JOptionPane.showMessageDialog(null, "No te has inscrito a ninguna conferencia");
              
          }else{
            IDM.setText(Integer.toString(new ConferenciasInsBD().BindList().get(index).getIdUsuario()));
            NombreM.setText(new ConferenciasInsBD().BindList().get(index).getNombreConferencia());
            CupoM.setText(Integer.toString(new ConferenciasInsBD().BindList().get(index).getCupoTotal()));
            PrecioM.setText(Integer.toString(new ConferenciasInsBD().BindList().get(index).getPrecio()));
            FechaM.setText(sdf.format(new ConferenciasInsBD().BindList().get(index).getFechaPresentacion()));
            horaInicioM.setText(String.valueOf(new ConferenciasInsBD().BindList().get(index).getHoraInicial()));
            horaFinalM.setText(String.valueOf(new ConferenciasInsBD().BindList().get(index).getHoraFinalizacion()));
          }
         
    }
     
     
     
    class FondoPanel extends JPanel {
        private Image imagen;
         
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/Fondo1.jpg")).getImage();
         
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
    
    public void transparenciaButton() {
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setBorderPainted(true);
        
        detalles.setOpaque(false);
        detalles.setContentAreaFilled(false);
        detalles.setBorderPainted(true);
        
        Anterior.setOpaque(false);
        Anterior.setContentAreaFilled(false);
        Anterior.setBorderPainted(true);
        
        Siguiente.setOpaque(false);
        Siguiente.setContentAreaFilled(false);
        Siguiente.setBorderPainted(true);
    }
    
    class BordeRedondo implements Border {

        private int radio;  

        BordeRedondo(int radius) {
            this.radio = radius;
        }  

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radio+1, this.radio+1, this.radio+2, this.radio);
        }  

        public boolean isBorderOpaque() {
            return true;
        }  

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radio, radio);
        }
    }
}
