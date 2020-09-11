package UI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ajanhune
 */
import Logic.LettersToNumbers;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainGUI implements ActionListener {

    private JLabel convertInfo = method();
    private JButton start = start();
    private JButton cipher = convertText();
    private JButton encrypt = encrypt();
    private JButton decrypt = decrypt();
    private JTextArea introduction = welcome();
    private JTextArea writeArea = writeArea();
    private JTextArea resultArea = resultArea();
    private JScrollPane scrollWriteArea = makeScrollable(writeArea);
    private JScrollPane scrollResultArea = makeScrollable(resultArea);
    private String method = "encrypt";

    // Frame of the GUI
    public void run() {
        JFrame frame = new JFrame("Cipherer");

        frame.add(introduction);
        frame.add(start);
        frame.add(scrollWriteArea);
        frame.add(scrollResultArea);
        frame.add(cipher);
        frame.add(encrypt);
        frame.add(decrypt);
        frame.add(convertInfo);

        frame.setSize(1000, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocation(500, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Converting label
    private JLabel method() {
        JLabel label = new JLabel("Encrypting");

        label.setBounds(450, 100, 200, 30);
        label.setVisible(false);

        return label;
    }

    // GUI buttons
    private JButton start() {
        JButton button = new JButton("Start");

        button.addActionListener(this);
        button.setActionCommand("start");
        button.setBounds(450, 300, 100, 30);

        return button;
    }

    private JButton convertText() {
        JButton button = new JButton("Convert message");

        button.addActionListener(this);
        button.setActionCommand("convert");
        button.setBounds(400, 340, 200, 30);
        button.setVisible(false);

        return button;
    }

    private JButton encrypt() {
        JButton button = new JButton("Encrypt");

        button.addActionListener(this);
        button.setActionCommand("encrypt");
        button.setBounds(340, 30, 150, 30);
        button.setVisible(false);

        return button;
    }

    private JButton decrypt() {
        JButton button = new JButton("Decrypt");

        button.addActionListener(this);
        button.setActionCommand("decrypt");
        button.setBounds(500, 30, 150, 30);
        button.setVisible(false);

        return button;
    }

    // GUI text areas
    private JTextArea welcome() {
        JTextArea area = new JTextArea();

        area.setText("Welcome to the Cipherer! In this application you can "
                + "encrypt and decrypt your messages easily and then copy them"
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

    private JTextArea writeArea() {
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

    private JTextArea resultArea() {
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

    private JScrollPane makeScrollable(JTextArea area) {
        JScrollPane scroll = new JScrollPane(area);

        scroll.setBounds(area.getX(), area.getY(), area.getWidth(), area.getHeight());
        scroll.setVisible(false);

        return scroll;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("start")) {
            // Hiding welcome message
            introduction.setVisible(false);
            start.setVisible(false);

            // Setting modification view visible
            writeArea.setVisible(true);
            resultArea.setVisible(true);
            scrollWriteArea.setVisible(true);
            scrollResultArea.setVisible(true);
            cipher.setVisible(true);
            decrypt.setVisible(true);
            encrypt.setVisible(true);
            convertInfo.setVisible(true);
        }

        if (e.getActionCommand().equals("encrypt")) {
            method = "encrypt";
            convertInfo.setText("Encrypting");
            writeArea.setText("");
            resultArea.setText("");
        }

        if (e.getActionCommand().equals("decrypt")) {
            method = "decrypt";
            convertInfo.setText("Decrypting");
            writeArea.setText("");
            resultArea.setText("");
        }

        if (e.getActionCommand().equals("convert")) {
            System.out.println("Converting message: " + writeArea.getText());
            if (method.equals("encrypt")) {
                resultArea.setText(LettersToNumbers.encrypt(writeArea.getText()));

            } else {
                resultArea.setText(LettersToNumbers.decrypt(writeArea.getText()));
            }
        }
    }

}
