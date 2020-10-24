/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JLabel;

/**
 *
 * @author ajanhune
 */
public class Labels {
    public static JLabel method() {
        JLabel label = new JLabel("Encrypting with letterstonumbers");

        label.setBounds(380, 100, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel time() {
        JLabel label = new JLabel("");

        label.setBounds(410, 700, 150, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel testHeader() {
        JLabel label = new JLabel("Performance testing");

        label.setBounds(425, 50, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel lettersAndNumbersResults() {
        JLabel label = new JLabel("LettersToNumbers results: ");

        label.setBounds(50, 150, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel knapsackResults() {
        JLabel label = new JLabel("Knapsack results: ");

        label.setBounds(50, 350, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel rsaResults() {
        JLabel label = new JLabel("RSA results: ");

        label.setBounds(50, 550, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel lettersAndNumbers1() {
        JLabel label = new JLabel("LettersToNumbers 1000 words: ");

        label.setBounds(50, 190, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel knapsack1() {
        JLabel label = new JLabel("Knapsack 1000 words: ");

        label.setBounds(50, 390, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel rsa1() {
        JLabel label = new JLabel("RSA 1000 words: ");

        label.setBounds(50, 590, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel lettersAndNumbers2() {
        JLabel label = new JLabel("LettersToNumbers 5000 words: ");

        label.setBounds(50, 230, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel knapsack2() {
        JLabel label = new JLabel("Knapsack 5000 words: ");

        label.setBounds(50, 430, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel rsa2() {
        JLabel label = new JLabel("RSA 5000 words: ");

        label.setBounds(50, 630, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel lettersAndNumbers3() {
        JLabel label = new JLabel("LettersToNumbers 10 000 words: ");

        label.setBounds(50, 270, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel knapsack3() {
        JLabel label = new JLabel("Knapsack 10 000 words: ");

        label.setBounds(50, 470, 400, 30);
        label.setVisible(false);

        return label;
    }

    public static JLabel rsa3() {
        JLabel label = new JLabel("RSA 10 000 words: ");

        label.setBounds(50, 670, 400, 30);
        label.setVisible(false);

        return label;
    }
}
