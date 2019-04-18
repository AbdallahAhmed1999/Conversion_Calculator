/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion_calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Abdallah_Ahmed
 */
public class Conversion_Calculator extends JFrame implements ActionListener {

    JButton[] buttonsList;
    JTextField textField;
    JButton b1;
    Integer type = 10;
    Integer decemal = 10;
    
    public Conversion_Calculator() {

        textField = new JTextField(26);
        JPanel textPanel = new JPanel(new GridLayout(1, 1, 0, 0));
        textPanel.add(textField);

        String buttons = "0123456789ABCDEF";

        buttonsList = new JButton[16];
        JPanel buttonsPanel = new JPanel(new GridLayout(4, 4, 3, 3));
        for (int i = 0; i < buttons.length(); i++) {
            b1 = new JButton(buttons.substring(i, i + 1));
            buttonsList[i] = b1;
            buttonsPanel.add(b1);
        }

        for (JButton b : buttonsList) {
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    textField.setText(textField.getText() + b.getText());
                }
            });
        }

        JPanel radioPanel = new JPanel(new GridLayout(5, 1, 0, 5));
        JRadioButton bin = new JRadioButton("Bin");
        JRadioButton dec = new JRadioButton("Dec");
        JRadioButton hex = new JRadioButton("Hex");
        JRadioButton oct = new JRadioButton("Oct");
        ButtonGroup group = new ButtonGroup();
        group.add(bin);
        group.add(dec);
        group.add(hex);
        group.add(oct);
        radioPanel.add(bin);
        radioPanel.add(dec);
        radioPanel.add(hex);
        radioPanel.add(oct);
        bin.addActionListener(this);
        dec.addActionListener(this);
        hex.addActionListener(this);
        oct.addActionListener(this);
        JButton c = new JButton("C");
        radioPanel.add(c);
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textField.setText("");
            }
        });
        this.setTitle("Conversion Calculator");
        this.setSize(new Dimension(350, 300));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout(2, 2));
        this.setVisible(true);

        this.add(textPanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.CENTER);
        this.add(radioPanel, BorderLayout.EAST);
    }

    private void setEnable(int x) {
        for (int i = 0; i < x; i++) {
            buttonsList[i].setEnabled(true);
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < buttonsList.length; i++) {
            buttonsList[i].setEnabled(false);
        }
    try{
    switch (ae.getActionCommand()) {
            case "Bin":
                setEnable(2);
                decemal = Integer.parseInt(textField.getText(), type);
                type = 2; 
                textField.setText(Integer.toString(decemal,type));
                break;
            case "Dec":
                setEnable(10);
                decemal = Integer.parseInt(textField.getText(), type);
                type = 10;
                textField.setText(Integer.toString(decemal,type));
                break;
            case "Hex":
                setEnable(16);
                decemal = Integer.parseInt(textField.getText(), type);
                type = 16;
                textField.setText(Integer.toString(decemal,type));
                break;
            case "Oct":
                setEnable(8);
                decemal = Integer.parseInt(textField.getText(), type);
                type = 8;
                textField.setText(Integer.toString(decemal,type));
                break;
        }
        }catch(Exception e){
            System.out.println("Exception");
        }
    }
    
    
    public static void main(String[] args) {
        Conversion_Calculator conversion_Calculator = new Conversion_Calculator();
    }

}
