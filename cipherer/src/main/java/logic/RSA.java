/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.math.BigInteger;

/**
 *
 * @author ajanhune
 */
public class RSA {

    private static long p = 200273;
    private static long q = 200257;
    private static int e = 5;
    private static int k = 2;
    private static long publicKeyN = p * q;
    private static long funnyN = (p - 1) * (q - 1);
    private static long privateKeyD = (k * funnyN + 1) / e;

    /**
     *
     * @param message string to be encrypted
     * @return returns an encrypted string
     */
    public static String encrypt(String message) {
        String encrypted = "";
        char[] charMessage = message.toCharArray();

        int[] intMessage = twoCharsToInt(charMessage);

        for (int i = 0; i < intMessage.length; i++) {
            BigInteger toEncrypt = new BigInteger(String.valueOf(intMessage[i]));
            BigInteger modPow = toEncrypt.modPow(new BigInteger(String.valueOf(e)), new BigInteger(String.valueOf(publicKeyN)));
            long encryptedLong = modPow.longValue();
            encrypted += encryptedLong + " ";
        }

        return encrypted.trim();
    }

    /**
     *
     * @param message string to be decrypted
     * @return returns a decrypted string
     */
    public static String decrypt(String message) {
        String decrypted = "";
        String[] messageSplit = message.split(" ");
        String[] decryptedSplit = new String[messageSplit.length];

        for (int i = 0; i < messageSplit.length; i++) {
            BigInteger split = new BigInteger(messageSplit[i]);
            BigInteger modPow = split.modPow(new BigInteger(String.valueOf(privateKeyD)), new BigInteger(String.valueOf(publicKeyN)));
            Long decryptedLong = modPow.longValue();
            decryptedSplit[i] = decryptedLong + "";
        }

        for (int i = 0; i < decryptedSplit.length; i++) {
            decrypted += asciiToLetter(decryptedSplit[i]);
        }

        return decrypted.trim();
    }

    /**
     *
     * @param charMessage message in char[] form
     * @return returns message in a form where two chars are converted to a
     * combined integer value and added to int[]
     */
    private static int[] twoCharsToInt(char[] charMessage) {
        int[] intMessage;
        if (charMessage.length % 2 == 0) {
            intMessage = new int[charMessage.length / 2];
        } else {
            intMessage = new int[charMessage.length / 2 + 1];
        }

        int charAmount = 0;
        int helper = 0;
        String combineChar = "";

        for (int i = 0; i < charMessage.length; i++) {

            int charValue = (int) charMessage[i];
            String charToCorrectLength = charValue + "";
            while (charToCorrectLength.length() < 3) {
                charToCorrectLength = "0" + charToCorrectLength;
            }
            combineChar += charToCorrectLength;
            charAmount++;
            if (charAmount >= 2 || i == charMessage.length - 1) {
                intMessage[helper] = Integer.parseInt(combineChar);
                helper++;
                charAmount = 0;
                combineChar = "";
            }
        }

        return intMessage;
    }

    /**
     *
     * @param message part of the message being decrypted
     * @return returns one or two letters depending on the size of the given
     * decrypted ascii number form letter string
     */
    private static String asciiToLetter(String message) {
        String letters = "";

        if (message.length() <= 3) {
            letters += (char) Integer.parseInt(message);
        } else {
            while (message.length() < 6) {
                message = "0" + message;
            }
            letters += (char) Integer.parseInt(message.substring(0, 3));
            letters += (char) Integer.parseInt(message.substring(3));
        }

        return letters;
    }

}
