/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Styles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;


public class JTextFieldHint  extends JTextField implements FocusListener{
    private final Font fontLost = new Font("Segoe UI Light",Font.BOLD, 16);
    private final Font fontGained = new Font("Segoe UI Light", Font.BOLD,16);
    private final Color colorLost = Color.LIGHT_GRAY;
    private Color colorGained = Color.BLACK;
    private String hint;
    
    public JTextFieldHint(){
        addFocusListener(this);
    }
    public void setHint(String hint) {
        setForeground(colorLost);
        setFont(fontLost);
        setText(hint);
        this.hint = hint;
    }
    public String getHint(){
        return hint;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getText().equals(getHint())) {
            setText("");
            setFont(fontGained);
            setForeground(colorGained);
        }
        else {
            setForeground(colorGained);
            setFont(fontGained);
            setText(getText());
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().length() <= 0) {
            setHint(getHint());
        }
        else {
            setForeground(colorGained);
            setFont(fontGained);
            setText(getText());
        }
    }
}
