package Views;

import Administracion.usuarioGeneralAdmin;
import Formatos.JTextFieldHint;
import Models.conferencia;
import Models.usuarioGeneral;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author fabian_rodriguez
 */

public class CrearConferencia extends JFrame {
    // Data
    private final int id;
    private usuarioGeneral user;
    private usuarioGeneralAdmin userAdmin;
    private conferencia confer;
    
    // Text display
    private final JLabel labCreate = new JLabel("Nueva conferencia");
    private final JLabel labName = new JLabel("Tema");
    private final JLabel labCupo = new JLabel("Cupo total");
    private final JLabel labPrice = new JLabel("Precio");
    private final JLabel labDiag = new JLabel("-");
    private final JLabel labDiag2 = new JLabel("-");
    private final JLabel labDats = new JLabel(":");
    private final JLabel labDats2 = new JLabel(":");
    private final JLabel labDate = new JLabel("Fecha");
    private final JLabel labTimeStart = new JLabel("Hora de inicio");
    private final JLabel labTimeFinish = new JLabel("Hora de finalización");
    
    // Text Field
    private final JTextField fldName = new JTextField();
    private final JTextField fldCupo = new JTextField();
    private final JTextFieldHint fldPrice = new JTextFieldHint();
    private final JTextFieldHint fldYear = new JTextFieldHint();
    private final JTextFieldHint fldMonth = new JTextFieldHint();
    private final JTextFieldHint fldDay = new JTextFieldHint();
    private final JTextFieldHint fldHourStart = new JTextFieldHint();
    private final JTextFieldHint fldMinStart = new JTextFieldHint();
    private final JTextFieldHint fldHourFinish = new JTextFieldHint();
    private final JTextFieldHint fldMinFinish = new JTextFieldHint();
    
    // Buttons
    private final JButton btnCreate = new JButton("Crear conferencia");

    public CrearConferencia(int id) {
        super();
        this.id = id;
        user = userAdmin.buscar(id);
        init();
    }
    
    private void init() {
        Font fontTitle = new Font("Segoe UI", 0, 30);
        Font fontSubtitle = new Font("Segoe UI Light", 1, 20);
        Font fontText = new Font("Segoe UI Light", 1, 16);
        
        // Ventana
        this.setTitle("Crear conferencia" + user.getNombre());
        this.setSize(900, 660);
//        this.setDefaultCloseOperation(HIDE_ON_CLOSE); **********************************
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setBackground(new Color(0xACDBE5));
        
        // Layout
        GroupLayout form = new GroupLayout(getContentPane());
        getContentPane().setLayout(form);
        
        // Spaces between elements
        form.setAutoCreateContainerGaps(true);
        form.setAutoCreateGaps(true);
        
        // Buttons config
        btnConfig(btnCreate);
        btnCreate.addActionListener((ActionEvent e) -> {
            validDatos();
        });
        
        // Hints config
        fldPrice.setHint("Si no tiene costo escriba 0");
        fldYear.setHint("AAAA");
        fldMonth.setHint("MM");
        fldDay.setHint("DD");
        fldHourStart.setHint("HH");
        fldMinStart.setHint("MM");
        fldHourFinish.setHint("HH");
        fldMinFinish.setHint("MM");
        
        // Fonts labels config
        labCreate.setFont(fontTitle);
        labName.setFont(fontText);
        labCupo.setFont(fontText);
        labPrice.setFont(fontText);
        labDate.setFont(fontText);
        labTimeStart.setFont(fontText);
        labTimeFinish.setFont(fontText);
        labDiag.setFont(fontText);
        labDiag2.setFont(fontText);
        labDats.setFont(fontText);
        labDats2.setFont(fontText);
        fldName.setFont(fontText);
        fldCupo.setFont(fontText);
        fldPrice.setFont(fontText);
        fldYear.setFont(fontText);
        fldMonth.setFont(fontText);
        fldDay.setFont(fontText);
        fldHourStart.setFont(fontText);
        fldMinStart.setFont(fontText);
        fldHourFinish.setFont(fontText);
        fldMinFinish.setFont(fontText);
        fldName.setBackground(new Color(0xE1F1F7));
        fldCupo.setBackground(new Color(0xE1F1F7));
        fldPrice.setBackground(new Color(0xE1F1F7));
        fldYear.setBackground(new Color(0xE1F1F7));
        fldMonth.setBackground(new Color(0xE1F1F7));
        fldDay.setBackground(new Color(0xE1F1F7));
        fldHourStart.setBackground(new Color(0xE1F1F7));
        fldMinStart.setBackground(new Color(0xE1F1F7));
        fldHourFinish.setBackground(new Color(0xE1F1F7));
        fldMinFinish.setBackground(new Color(0xE1F1F7));
        
        form.setVerticalGroup(
            form.createSequentialGroup()
                .addGap(25)
                .addGroup(
                    form.createParallelGroup()
                        .addComponent(labCreate)
                        .addGap(10)
                )
                .addGroup(
                    form.createSequentialGroup()
                        .addComponent(labName)
                        .addComponent(fldName, 35, 35, 35)
                        .addGap(10)
                )
                .addGroup(
                    form.createSequentialGroup()
                        .addComponent(labCupo)
                        .addComponent(fldCupo, 35, 35, 35)
                        .addGap(10)
                )
                .addGroup(
                    form.createSequentialGroup()
                        .addComponent(labPrice)
                        .addComponent(fldPrice, 35, 35, 35)
                        .addGap(10)
                )
                .addGroup(
                    form.createSequentialGroup()
                        .addComponent(labDate)
                        .addGroup(
                            form.createParallelGroup()
                                .addComponent(fldYear, 35, 35, 35)
                                .addComponent(labDiag)
                                .addComponent(fldMonth, 35, 35, 35)
                                .addComponent(labDiag2)
                                .addComponent(fldDay, 35, 35, 35)
                        )
                        .addGap(10)
                )
                .addGroup(
                    form.createSequentialGroup()
                        .addComponent(labTimeStart)
                        .addGroup(
                            form.createParallelGroup()
                                .addComponent(fldHourStart, 35, 35, 35)
                                .addComponent(labDats)
                                .addComponent(fldMinStart, 35, 35, 35)
                        )
                        .addGap(10)
                )
                .addGroup(
                    form.createSequentialGroup()
                        .addComponent(labTimeFinish)
                        .addGroup(
                            form.createParallelGroup()
                                .addComponent(fldHourFinish, 35, 35, 35)
                                .addComponent(labDats2)
                                .addComponent(fldMinFinish, 35, 35, 35)
                        )
                        .addGap(30)
                )
                .addComponent(btnCreate)
        );
        
        form.setHorizontalGroup(
            form.createSequentialGroup()
                .addGap(90)
                .addGroup(
                    form.createParallelGroup()
                        .addComponent(labCreate)
                        .addComponent(labName)
                        .addComponent(fldName, 650, 650, 650)
                        .addComponent(labCupo)
                        .addComponent(fldCupo, 650, 650, 650)
                        .addComponent(labPrice)
                        .addComponent(fldPrice, 650, 650, 650)
                        .addComponent(labDate)
                        .addGroup(
                            form.createSequentialGroup()
                                .addComponent(fldYear, 100, 100, 100)
                                .addComponent(labDiag)
                                .addComponent(fldMonth, 50, 50, 50)
                                .addComponent(labDiag2)
                                .addComponent(fldDay, 50, 50, 50)
                        )
                        .addComponent(labTimeStart)
                        .addGroup(
                            form.createSequentialGroup()
                                .addComponent(fldHourStart, 50, 50, 50)
                                .addComponent(labDats)
                                .addComponent(fldMinStart, 50, 50, 50)
                        )
                        .addComponent(labTimeFinish)
                        .addGroup(
                            form.createSequentialGroup()
                                .addComponent(fldHourFinish, 50, 50, 50)
                                .addComponent(labDats2)
                                .addComponent(fldMinFinish, 50, 50, 50)
                        )
                        .addComponent(btnCreate)
                )
        );
    }
    
    private void btnConfig(JButton btn) {
        btn.setOpaque(false);
        btn.setBackground(new Color(0,0,0,0));
        btn.setFont(new Font("Segoe UI", 0, 18));
    }
    
    private boolean validDatos() {
        String name;
        int cupo;
        int price;
        boolean costo;
        String strDate;
        Date date;
        String strTimeStart;
        Date timeStart;
        String strTimeFinish;
        Date timeFinish;
        int year;
        int month;
        int day;
        int hourStart;
        int minStart;
        int hourFinish;
        int minFinish;
        
        if(
                fldName.getText().isEmpty() || 
                fldCupo.getText().isEmpty() || 
                fldPrice.getText().isEmpty() ||
                fldYear.getText().isEmpty() ||
                fldMonth.getText().isEmpty() ||
                fldDay.getText().isEmpty() ||
                fldHourStart.getText().isEmpty() ||
                fldMinStart.getText().isEmpty() ||
                fldHourFinish.getText().isEmpty() ||
                fldMinFinish.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            return false;
        }
        
        name = fldName.getText();
        
        try{
            cupo = Integer.parseInt(fldCupo.getText());
            price = Integer.parseInt(fldPrice.getText());
            year = Integer.parseInt(fldYear.getText());
            month = Integer.parseInt(fldMonth.getText());
            day = Integer.parseInt(fldDay.getText());
            hourStart = Integer.parseInt(fldHourStart.getText());
            minStart = Integer.parseInt(fldMinStart.getText());
            hourFinish = Integer.parseInt(fldHourFinish.getText());
            minFinish = Integer.parseInt(fldMinFinish.getText());
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
        
        date = parseDate(strDate);
        
        if(hourStart > 23 || hourStart < 0 || minStart > 59|| minStart < 0) {
            JOptionPane.showMessageDialog(null, "Formato de hora de inicio invalido");
            return false;
        }
        
        if(hourFinish > 23 || minFinish > 59) {
            JOptionPane.showMessageDialog(null, "Formato de hora de finalización invalido");
            return false;
        }
        
        strTimeStart = Integer.toString(hourStart) + ":" + Integer.toString(minStart) + ":00";
        
        timeStart = parseTime(strTimeStart);
        
        System.out.println(date + "  |  " + timeStart);
        
//        confer = new conferencia(user.getId(), name, cupo, price, costo, date, timeStart, timeFinish);
        
//        conferenciaAdmin.agregar(confer);
        
        return true;
    }
    
    private static Date parseDate(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-dd-MM");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error al convertir a Date");
        }
        return fechaDate;
    }
    
    private static Date parseTime(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        Date time = null;
        try {
            time = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error al convertir a Time");
        }
        return time;
    }
}
