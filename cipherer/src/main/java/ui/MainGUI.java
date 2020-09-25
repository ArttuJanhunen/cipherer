package ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ajanhune
 */
import logic.LettersToNumbers;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import logic.KnapsackCrypt;

public class MainGUI implements ActionListener {
    
    private JLabel convertInfo = method();
    private JLabel timeheader = time();
    private JButton start = start();
    private JButton cipher = convertText();
    private JButton encrypt = encrypt();
    private JButton decrypt = decrypt();
    private JButton change = changeMethod();
    private JButton copy = copyText();
    private JTextArea introduction = welcome();
    private JTextArea writeArea = writeArea();
    private JTextArea resultArea = resultArea();
    private JScrollPane scrollWriteArea = makeScrollable(writeArea);
    private JScrollPane scrollResultArea = makeScrollable(resultArea);
    private String direction = "encrypt";
    private String method = "letterstonumbers";

    // Frame of the GUI
    public void run() {
        JFrame frame = new JFrame("Cipherer");
        
        frame.add(introduction);
        frame.add(timeheader);
        frame.add(start);
        frame.add(scrollWriteArea);
        frame.add(scrollResultArea);
        frame.add(cipher);
        frame.add(encrypt);
        frame.add(decrypt);
        frame.add(change);
        frame.add(copy);
        frame.add(convertInfo);
        
        frame.setSize(1000, 800);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocation(500, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // GUI labels
    private JLabel method() {
        JLabel label = new JLabel("Encrypting with letterstonumbers");
        
        label.setBounds(380, 100, 400, 30);
        label.setVisible(false);
        
        return label;
    }
    
    private JLabel time() {
        JLabel label = new JLabel("");
        
        label.setBounds(410, 700, 150, 30);
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
    
    private JButton changeMethod() {
        JButton button = new JButton("Change method");
        button.addActionListener(this);
        button.setActionCommand("change");
        button.setBounds(670, 30, 200, 30);
        button.setVisible(false);
        
        return button;
    }
    
    private JButton copyText() {
        JButton button = new JButton("Copy");
        button.addActionListener(this);
        button.setActionCommand("copy");
        button.setBounds(425, 600, 150, 30);
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
            change.setVisible(true);
            copy.setVisible(true);
            timeheader.setVisible(true);
        }
        
        if (e.getActionCommand().equals("encrypt")) {
            direction = "encrypt";
            convertInfo.setText("Encrypting with " + method);
            writeArea.setText("");
            resultArea.setText("");
        }
        
        if (e.getActionCommand().equals("decrypt")) {
            direction = "decrypt";
            convertInfo.setText("Decrypting with " + method);
            writeArea.setText("");
            resultArea.setText("");
        }
        
        if (e.getActionCommand().equals("convert")) {
            long startTime = System.currentTimeMillis();
            System.out.println("Converting message: " + writeArea.getText());
            if (method.equals("letterstonumbers")) {
                if (direction.equals("encrypt")) {
                    resultArea.setText(LettersToNumbers.encrypt(writeArea.getText()));
                    timeheader.setText("Action took " + (System.currentTimeMillis() - startTime) + " ms");
                } else {
                    resultArea.setText(LettersToNumbers.decrypt(writeArea.getText()));
                    timeheader.setText("Action took " + (System.currentTimeMillis() - startTime) + " ms");
                }
            }
            
            if (method.equals("knapsack")) {
                if (direction.equals("encrypt")) {
                    resultArea.setText(KnapsackCrypt.encrypt(writeArea.getText()));
                    timeheader.setText("Action took " + (System.currentTimeMillis() - startTime) + " ms");
                } else {
                    resultArea.setText(KnapsackCrypt.decrypt(writeArea.getText()));
                    timeheader.setText("Action took " + (System.currentTimeMillis() - startTime) + " ms");
                }
            }
            
        } else {
            timeheader.setText("");
        }
        
        if (e.getActionCommand().equals("change")) {
            writeArea.setText("");
            resultArea.setText("");
            if (method.equals("letterstonumbers")) {
                method = "knapsack";
                if (direction.equals("encrypt")) {
                    convertInfo.setText("Encrypting with " + method);
                }
                if (direction.equals("decrypt")) {
                    convertInfo.setText("Decrypting with " + method);
                }
                
            } else if (method.equals("knapsack")) {
                method = "letterstonumbers";
                if (direction.equals("encrypt")) {
                    convertInfo.setText("Encrypting with " + method);
                }
                if (direction.equals("decrypt")) {
                    convertInfo.setText("Decrypting with " + method);
                }
            }
        }
        
        if (e.getActionCommand().equals("copy")) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection selected = new StringSelection(resultArea.getText());
            clipboard.setContents(selected, null);
        }
    }
    
}
