/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.helpers.Binary;
import logic.helpers.Splitter;

/**
 *
 * @author ajanhune
 */
public class KnapsackCrypt {

    // Private key
    private static int[] privateKey = {2, 7, 11, 21, 42, 89, 180, 354};

    // Public key created from private key
    private static int[] publicKey = new int[privateKey.length];

    // Number bigger than private keys combined value that will take modulo
    // when encrypting
    private static int m = 881;

    // Number that has 1 as greatest common divisor with m
    private static int n = 588;

    // Multiplicative inverse for n mod m
    private static int x = 442;

    /**
     * Creates public key with private key and m and m
     */
    public static void createPublicKey() {
        for (int i = 0; i < privateKey.length; i++) {
            publicKey[i] = (privateKey[i] * n) % m;
        }
    }

    /**
     *
     * @param message message to be encrypted
     * @return returns string value of the encrypted message
     */
    public static String encrypt(String message) {
        String encrypted = "";

        char[] charMessage = message.toCharArray();
        char[] charBinary = Binary.convertToBinary(charMessage);
        int[] intMessage = new int[charBinary.length];

        for (int i = 0; i < charBinary.length; i++) {
            intMessage[i] = Integer.parseInt(String.valueOf(charBinary[i]));
        }

        int[][] slicedMessage = slice(intMessage);
        int tableAmount = (int) Math.ceil(charBinary.length / 8.0);

        for (int i = 0; i < tableAmount; i++) {
            encrypted += sliceToString(slicedMessage[i]) + " ";
        }

        return encrypted.trim();
    }

    /**
     *
     * @param message encrypted message string
     * @return returns decrypted message in string format
     */
    public static String decrypt(String message) {
        String[] messageSlots = Splitter.split(message, ' ');
        String decryptedMessage = "";
        int[] intSlots = new int[messageSlots.length];

        try {
            for (int i = 0; i < messageSlots.length; i++) {
                intSlots[i] = Integer.parseInt(messageSlots[i]);
            }
        } catch (NumberFormatException e) {
            return "Malformed message given, try again";
        }

        for (int number : intSlots) {
            int inverse = (number * x) % m;
            decryptedMessage += "" + decryptSlot(inverse);
        }

        String decryptedAndConverted = Binary.convertToString(decryptedMessage);

        return decryptedAndConverted;
    }

    /**
     *
     * @param message int[] format of the message that has been converted to
     * binary
     * @return returns int[][] format for the binary message that has been
     * encrypted with the public key where int[this has letters index][this has
     * the letters value]
     */
    public static int[][] slice(int[] message) {
        createPublicKey();
        int numberSlot = 0;
        int tableSlot = 0;
        int tableAmount = (int) Math.ceil(message.length / 8.0);
        int[][] result = new int[tableAmount][8];

        for (int i = 0; i < message.length; i++) {
            if (numberSlot >= 8) {
                numberSlot = 0;
                tableSlot++;
            }
            result[tableSlot][numberSlot] = message[i] * publicKey[numberSlot];
            numberSlot++;
        }
        return result;
    }

    /**
     *
     * @param slice encrypted value of a letter
     * @return slice's total sum in string format
     */
    public static String sliceToString(int[] slice) {

        int total = 0;

        for (int i = 0; i < slice.length; i++) {
            total += slice[i];
        }

        String sliceString = "" + total;
        return sliceString;
    }

    /**
     *
     * @param number int value of the encrypted letter that has been treated
     * with (number * x) % m
     * @return string value of the decrypted letter, in binary form
     */
    public static String decryptSlot(int number) {
        int helper = number;
        String decrypted = "";
        boolean[] indexes = new boolean[privateKey.length];

        for (int i = privateKey.length - 1; i >= 0; i--) {
            if (helper >= privateKey[i]) {
                indexes[i] = true;
                helper -= privateKey[i];
            } else {
                indexes[i] = false;
            }
        }

        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i]) {
                decrypted += "" + 1;
            } else {
                decrypted += "" + 0;
            }
        }
        return decrypted;
    }

}
