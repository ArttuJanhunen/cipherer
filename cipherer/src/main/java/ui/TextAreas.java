/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author ajanhune
 */
public class TextAreas {

    public static JTextArea welcome() {
        JTextArea area = new JTextArea();

        area.setText("Welcome to the Cipherer! In this application you can "
                + "encrypt and decrypt your messages easily and then copy them "
                + "and pass them on!");

        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setColumns(20);
        area.setRows(3);
        area.setBounds(200, 100, 600, 70);
        area.setFont(new Font("Arial Black", Font.BOLD, 16));
        area.setBorder(BorderFactory.createBevelBorder(1));

        return area;
    }

    public static JTextArea writeArea() {
        JTextArea area = new JTextArea();

        area.setColumns(20);
        area.setRows(10);
        area.setFont(new Font("Arial Black", Font.BOLD, 16));
        area.setBorder(BorderFactory.createBevelBorder(1));
        area.setBounds(50, 130, 900, 200);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setVisible(false);

        return area;
    }

    public static JTextArea resultArea() {
        JTextArea area = new JTextArea();

        area.setColumns(20);
        area.setRows(10);
        area.setFont(new Font("Arial Black", Font.BOLD, 16));
        area.setBorder(BorderFactory.createBevelBorder(1));
        area.setBounds(50, 390, 900, 200);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setVisible(false);
        area.setEditable(false);

        return area;
    }

    public static JScrollPane makeScrollable(JTextArea area) {
        JScrollPane scroll = new JScrollPane(area);

        scroll.setBounds(area.getX(), area.getY(), area.getWidth(), area.getHeight());
        scroll.setVisible(false);

        return scroll;
    }
}
