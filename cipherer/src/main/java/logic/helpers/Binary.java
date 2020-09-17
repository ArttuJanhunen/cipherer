/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.helpers;

/**
 *
 * @author ajanhune
 */
public class Binary {

    public static char[] convertToBinary(char[] message) {
        String binaryForm = "";

        for (int i = 0; i < message.length; i++) {
            String eightbit = Integer.toBinaryString(message[i]);
            while (eightbit.length() < 8) {
                eightbit = 0 + eightbit;
            }
            binaryForm += eightbit;
        }

        char[] binaryChar = binaryForm.toCharArray();

        return binaryChar;
    }

    public static String convertToString(String message) {
        String converted = "";
        int helper = 0;
        String binaryForm = "";

        for (int i = 0; i <= message.length(); i++) {
            if (i == message.length()) {
                converted += (char) Integer.parseInt(binaryForm, 2);
                break;
            }
            if (helper >= 8) {
                helper = 0;
                converted += (char) Integer.parseInt(binaryForm, 2);
                binaryForm = "";
            }
            binaryForm += message.charAt(i);
            helper++;
        }

        return converted;
    }
}
