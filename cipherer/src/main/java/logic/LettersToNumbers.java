/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import logic.helpers.Pair;

/**
 *
 * @author ajanhune
 */
public class LettersToNumbers {

    // Initialize pairs for the class
    private static Pair[] lettersAndNumbers = {
        new Pair('a', 1),
        new Pair('b', 2),
        new Pair('c', 3),
        new Pair('d', 4),
        new Pair('e', 5),
        new Pair('f', 6),
        new Pair('g', 7),
        new Pair('h', 8),
        new Pair('i', 9),
        new Pair('j', 10),
        new Pair('k', 11),
        new Pair('l', 12),
        new Pair('m', 13),
        new Pair('n', 14),
        new Pair('o', 15),
        new Pair('p', 16),
        new Pair('q', 17),
        new Pair('r', 18),
        new Pair('s', 19),
        new Pair('t', 20),
        new Pair('u', 21),
        new Pair('v', 22),
        new Pair('w', 23),
        new Pair('x', 24),
        new Pair('y', 25),
        new Pair('z', 26),
        new Pair('å', 27),
        new Pair('ä', 28),
        new Pair('ö', 29),
        new Pair('A', 30),
        new Pair('B', 31),
        new Pair('C', 31),
        new Pair('D', 33),
        new Pair('E', 34),
        new Pair('F', 35),
        new Pair('G', 36),
        new Pair('H', 37),
        new Pair('I', 38),
        new Pair('J', 39),
        new Pair('K', 40),
        new Pair('L', 41),
        new Pair('M', 42),
        new Pair('N', 43),
        new Pair('O', 44),
        new Pair('P', 45),
        new Pair('Q', 46),
        new Pair('R', 47),
        new Pair('S', 48),
        new Pair('T', 49),
        new Pair('U', 50),
        new Pair('V', 51),
        new Pair('W', 52),
        new Pair('X', 53),
        new Pair('Y', 54),
        new Pair('Z', 55),
        new Pair('Å', 56),
        new Pair('Ä', 57),
        new Pair('Ö', 58),
        new Pair(' ', 60),
        new Pair('.', 61),
        new Pair(',', 62),
        new Pair('?', 63),
        new Pair('!', 64),
        new Pair('1', 65),
        new Pair('2', 66),
        new Pair('3', 67),
        new Pair('4', 68),
        new Pair('5', 69),
        new Pair('6', 70),
        new Pair('7', 71),
        new Pair('8', 72),
        new Pair('9', 73),
        new Pair('0', 74),
        new Pair('(', 76),
        new Pair(')', 77),
        new Pair(':', 78),};

    /**
     *
     * @param message string to be encrypted
     * @return returns encrypted version of the given string
     */
    public static String encrypt(String message) {
        String cryptedMessage = "";
        char[] charMessage = message.toCharArray();

        for (char letter : charMessage) {
            cryptedMessage += getNumber(letter) == -1
                    ? String.valueOf(letter) + "*"
                    : String.valueOf(getNumber(letter)) + "*";
        }

        return cryptedMessage;
    }

    /**
     *
     * @param message string to be decrypted
     * @return returns decrypted version of the given string, assumed it has
     *    been encrypted correctly
     */
    public static String decrypt(String message) {
        String decryptedMessage = "";

        String[] intMessage = message.split("\\*");

        for (String number : intMessage) {
            if (number.equals("*")) {
                continue;
            }
            decryptedMessage += getChar(Integer.parseInt(number)) == '§'
                    ? number
                    : String.valueOf(getChar(Integer.parseInt(number)));
        }

        return decryptedMessage;
    }

    /**
     *
     * @param letter
     * @return returns int equivalent for the given char
     * @see Pair#getNumber()
     */
    private static int getNumber(char letter) {
        for (Pair pair : lettersAndNumbers) {
            if (pair.getChar() == letter) {
                return pair.getNumber();
            }
        }
        return -1;
    }

    /**
     *
     * @param number
     * @return returns char equivalent for the given int
     * @see Pair#getChar()
     */
    private static char getChar(int number) {
        for (Pair pair : lettersAndNumbers) {
            if (pair.getNumber() == number) {
                return pair.getChar();
            }
        }
        return '§';
    }

}
