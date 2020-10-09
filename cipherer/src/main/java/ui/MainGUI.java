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
import logic.RSA;

public class MainGUI implements ActionListener {

    private JLabel convertInfo = method();
    private JLabel timeheader = time();
    private JLabel testHeader = testHeader();
    private JLabel lettersToNumbers = lettersAndNumbersResults();
    private JLabel knapsack = knapsackResults();
    private JLabel rsa = rsaResults();
    private JLabel lettersToNumbers1 = lettersAndNumbers1();
    private JLabel knapsack1 = knapsack1();
    private JLabel rsa1 = rsa1();
    private JLabel lettersToNumbers2 = lettersAndNumbers2();
    private JLabel knapsack2 = knapsack2();
    private JLabel rsa2 = rsa2();
    private JLabel lettersToNumbers3 = lettersAndNumbers3();
    private JLabel knapsack3 = knapsack3();
    private JLabel rsa3 = rsa3();
    private JButton start = start();
    private JButton performance = performance();
    private JButton test = startTests();
    private JButton exittests = exittests();
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
        frame.add(testHeader);
        frame.add(start);
        frame.add(performance);
        frame.add(test);
        frame.add(exittests);
        frame.add(lettersToNumbers);
        frame.add(knapsack);
        frame.add(rsa);
        frame.add(lettersToNumbers1);
        frame.add(knapsack1);
        frame.add(rsa1);
        frame.add(lettersToNumbers2);
        frame.add(knapsack2);
        frame.add(rsa2);
        frame.add(lettersToNumbers3);
        frame.add(knapsack3);
        frame.add(rsa3);
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

    private JLabel testHeader() {
        JLabel label = new JLabel("Performance testing");

        label.setBounds(425, 50, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel lettersAndNumbersResults() {
        JLabel label = new JLabel("LettersToNumbers results: ");

        label.setBounds(50, 150, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel knapsackResults() {
        JLabel label = new JLabel("Knapsack results: ");

        label.setBounds(50, 350, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel rsaResults() {
        JLabel label = new JLabel("RSA results: ");

        label.setBounds(50, 550, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel lettersAndNumbers1() {
        JLabel label = new JLabel("LettersToNumbers 1000 words: ");

        label.setBounds(50, 190, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel knapsack1() {
        JLabel label = new JLabel("Knapsack 1000 words: ");

        label.setBounds(50, 390, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel rsa1() {
        JLabel label = new JLabel("RSA 1000 words: ");

        label.setBounds(50, 590, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel lettersAndNumbers2() {
        JLabel label = new JLabel("LettersToNumbers 5000 words: ");

        label.setBounds(50, 230, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel knapsack2() {
        JLabel label = new JLabel("Knapsack 5000 words: ");

        label.setBounds(50, 430, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel rsa2() {
        JLabel label = new JLabel("RSA 5000 words: ");

        label.setBounds(50, 630, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel lettersAndNumbers3() {
        JLabel label = new JLabel("LettersToNumbers 10 000 words: ");

        label.setBounds(50, 270, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel knapsack3() {
        JLabel label = new JLabel("Knapsack 10 000 words: ");

        label.setBounds(50, 470, 400, 30);
        label.setVisible(false);

        return label;
    }

    private JLabel rsa3() {
        JLabel label = new JLabel("RSA 10 000 words: ");

        label.setBounds(50, 670, 400, 30);
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

    private JButton performance() {
        JButton button = new JButton("Performance testing");

        button.addActionListener(this);
        button.setActionCommand("performance");
        button.setBounds(400, 350, 200, 30);

        return button;
    }

    private JButton startTests() {
        JButton button = new JButton("Start");

        button.addActionListener(this);
        button.setActionCommand("test");
        button.setBounds(450, 100, 100, 30);
        button.setVisible(false);

        return button;
    }

    private JButton exittests() {
        JButton button = new JButton("Exit");

        button.addActionListener(this);
        button.setActionCommand("exittests");
        button.setBounds(450, 725, 100, 30);
        button.setVisible(false);

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
            performance.setVisible(false);

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

        if (e.getActionCommand().equals("performance")) {
            // Hiding welcome message
            introduction.setVisible(false);
            start.setVisible(false);
            performance.setVisible(false);

            // Setting performance test view visible
            test.setVisible(true);
            exittests.setVisible(true);
            testHeader.setVisible(true);
            lettersToNumbers.setVisible(true);
            knapsack.setVisible(true);
            rsa.setVisible(true);
            lettersToNumbers1.setVisible(true);
            knapsack1.setVisible(true);
            rsa1.setVisible(true);
            lettersToNumbers2.setVisible(true);
            knapsack2.setVisible(true);
            rsa2.setVisible(true);
            lettersToNumbers3.setVisible(true);
            knapsack3.setVisible(true);
            rsa3.setVisible(true);

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

            if (method.equals("RSA")) {
                if (direction.equals("encrypt")) {
                    resultArea.setText(RSA.encrypt(writeArea.getText()));
                    timeheader.setText("Action took " + (System.currentTimeMillis() - startTime) + " ms");
                } else {
                    resultArea.setText(RSA.decrypt(writeArea.getText()));
                    timeheader.setText("Action took " + (System.currentTimeMillis() - startTime) + " ms");
                }
            }

        } else {
            timeheader.setText("");
        }

        if (e.getActionCommand().equals("change")) {
            writeArea.setText("");
            resultArea.setText("");
            switch (method) {
                case "letterstonumbers":
                    method = "knapsack";
                    if (direction.equals("encrypt")) {
                        convertInfo.setText("Encrypting with " + method);
                    }
                    if (direction.equals("decrypt")) {
                        convertInfo.setText("Decrypting with " + method);
                    }
                    break;
                case "knapsack":
                    method = "RSA";
                    if (direction.equals("encrypt")) {
                        convertInfo.setText("Encrypting with " + method);
                    }
                    if (direction.equals("decrypt")) {
                        convertInfo.setText("Decrypting with " + method);
                    }
                    break;
                case "RSA":
                    method = "letterstonumbers";
                    if (direction.equals("encrypt")) {
                        convertInfo.setText("Encrypting with " + method);
                    }
                    if (direction.equals("decrypt")) {
                        convertInfo.setText("Decrypting with " + method);
                    }
                    break;
                default:
                    break;
            }
        }

        if (e.getActionCommand().equals("test")) {
            String testPhrase = "Test!";
            String testLevel1 = "";
            String testLevel2 = "";
            String testLevel3 = "";

            for (int i = 0; i < 1000; i++) {
                testLevel1 += testPhrase;
            }

            System.out.println("Loop 1 done");

            // 1000 word round
            long letterStart1 = System.currentTimeMillis();
            String encryptL1 = LettersToNumbers.encrypt(testLevel1);
            String decryptL1 = LettersToNumbers.decrypt(encryptL1);
            long letterStop1 = System.currentTimeMillis() - letterStart1;
            lettersToNumbers1.setText("LettersToNumbers 1000 words: " + letterStop1 + "ms");

            System.out.println("Letters 1 done");

            long knapsackStart1 = System.currentTimeMillis();
            String encryptK1 = KnapsackCrypt.encrypt(testLevel1);
            String decryptK1 = KnapsackCrypt.decrypt(encryptK1);
            long knapsackStop1 = System.currentTimeMillis() - knapsackStart1;
            knapsack1.setText("Knapsack 1000 words: " + knapsackStop1 + "ms");

            System.out.println("Knapsack 1 done");

            long rsaStart1 = System.currentTimeMillis();
            String encryptR1 = RSA.encrypt(testLevel1);
            String decryptR1 = RSA.decrypt(encryptR1);
            long rsaStop1 = System.currentTimeMillis() - rsaStart1;
            rsa1.setText("RSA 1000 words: " + rsaStop1 + "ms");

            System.out.println("RSA 1 done");
            System.out.println("Round 1 done");

            for (int i = 0; i < 5000; i++) {
                testLevel2 += testPhrase;
            }

            System.out.println("Loop 2 done");

            // 10 000 word round
            long letterStart2 = System.currentTimeMillis();
            String encryptL2 = LettersToNumbers.encrypt(testLevel2);
            String decryptL2 = LettersToNumbers.decrypt(encryptL2);
            long letterStop2 = System.currentTimeMillis() - letterStart2;
            lettersToNumbers2.setText("LettersToNumbers 5000 words: " + letterStop2 + "ms");

            System.out.println("Letters 2 done");

            long knapsackStart2 = System.currentTimeMillis();
            String encryptK2 = KnapsackCrypt.encrypt(testLevel2);
            String decryptK2 = KnapsackCrypt.decrypt(encryptK2);
            long knapsackStop2 = System.currentTimeMillis() - knapsackStart2;
            knapsack2.setText("Knapsack 5000 words: " + knapsackStop2 + "ms");

            System.out.println("Knapsack 2 done");

            long rsaStart2 = System.currentTimeMillis();
            String encryptR2 = RSA.encrypt(testLevel2);
            String decryptR2 = RSA.decrypt(encryptR2);
            long rsaStop2 = System.currentTimeMillis() - rsaStart2;
            rsa2.setText("RSA 5000 words: " + rsaStop2 + "ms");

            System.out.println("RSA 2 done");
            System.out.println("Round 2 done");

            for (int i = 0; i < 10000; i++) {
                testLevel3 += testPhrase;
            }

            System.out.println("Loop 3 done");

            // 100 000 word round
            long letterStart3 = System.currentTimeMillis();
            String encryptL3 = LettersToNumbers.encrypt(testLevel3);
            String decryptL3 = LettersToNumbers.decrypt(encryptL3);
            long letterStop3 = System.currentTimeMillis() - letterStart3;
            lettersToNumbers3.setText("LettersToNumbers 10 000 words: " + letterStop3 + "ms");

            System.out.println("Letters to numbers 3 done");

            long knapsackStart3 = System.currentTimeMillis();
            String encryptK3 = KnapsackCrypt.encrypt(testLevel3);
            String decryptK3 = KnapsackCrypt.decrypt(encryptK3);
            long knapsackStop3 = System.currentTimeMillis() - knapsackStart3;
            knapsack3.setText("Knapsack 10 000 words: " + knapsackStop3 + "ms");

            System.out.println("Knapsack 3 done");

            long rsaStart3 = System.currentTimeMillis();
            String encryptR3 = RSA.encrypt(testLevel3);
            String decryptR3 = RSA.decrypt(encryptR3);
            long rsaStop3 = System.currentTimeMillis() - rsaStart3;
            rsa3.setText("RSA 10 000 words: " + rsaStop3 + "ms");

            System.out.println("RSA 3 done");
            System.out.println("Round 3 done");

            if (decryptL1.equals(testLevel1) && decryptL2.equals(testLevel2) && decryptL3.equals(testLevel3)) {
                System.out.println("LettersToNumbers successful");
            }

            if (decryptK1.equals(testLevel1) && decryptK2.equals(testLevel2) && decryptK3.equals(testLevel3)) {
                System.out.println("Knapsack successful");
            }

            if (decryptR1.equals(testLevel1) && decryptR2.equals(testLevel2) && decryptR3.equals(testLevel3)) {
                System.out.println("RSA successful");
            }

        }

        if (e.getActionCommand().equals("exittests")) {
            // Setting visible welcome message
            introduction.setVisible(true);
            start.setVisible(true);
            performance.setVisible(true);

            // Setting performance test view visible
            test.setVisible(false);
            exittests.setVisible(false);
            testHeader.setVisible(false);
            lettersToNumbers.setVisible(false);
            knapsack.setVisible(false);
            rsa.setVisible(false);
            lettersToNumbers1.setVisible(false);
            knapsack1.setVisible(false);
            rsa1.setVisible(false);
            lettersToNumbers2.setVisible(false);
            knapsack2.setVisible(false);
            rsa2.setVisible(false);
            lettersToNumbers3.setVisible(false);
            knapsack3.setVisible(false);
            rsa3.setVisible(false);

        }

        if (e.getActionCommand().equals("copy")) {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection selected = new StringSelection(resultArea.getText());
            clipboard.setContents(selected, null);
        }
    }

}
