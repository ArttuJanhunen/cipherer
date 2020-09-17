/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.helpers.Binary;

/**
 *
 * @author ajanhune
 */
public class KnapsackCrypt {

    private static int[] privateKey = {2, 7, 11, 21, 42, 89, 180, 354};
    private static int[] publicKey = new int[privateKey.length];

    private static int m = 881;
    private static int n = 588;
    private static int x = 442;

    public static void createPublicKey() {
        for (int i = 0; i < privateKey.length; i++) {
            publicKey[i] = (privateKey[i] * n) % m;
        }
    }

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

        return encrypted;
    }

    public static String decrypt(String message) {
        String[] messageSlots = message.split(" ");
        String decryptedMessage = "";
        int[] intSlots = new int[messageSlots.length];

        for (int i = 0; i < messageSlots.length; i++) {
            intSlots[i] = Integer.parseInt(messageSlots[i]);
        }

        for (int number : intSlots) {
            int inverse = (number * x) % m;
            decryptedMessage += "" + decryptSlot(inverse);
        }

        String decryptedAndConverted = Binary.convertToString(decryptedMessage);

        return decryptedAndConverted;
    }

    public static int[][] slice(int[] message) {
        createPublicKey();
        int size = 8;
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

    public static String sliceToString(int[] slice) {

        int total = 0;

        for (int i = 0; i < slice.length; i++) {
            total += slice[i];
        }

        String sliceString = "" + total;
        return sliceString;
    }

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
