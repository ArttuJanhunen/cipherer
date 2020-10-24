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
public class SubString {

    /**
     *
     * @param original String to take substring from
     * @param start start index for substring, inclusive
     * @param stop stop index for substring, exclusive
     * @return returns substring from the original string
     */
    public static String subString(String original, int start, int stop) {
        String sub = "";
        char[] origChar = original.toCharArray();

        for (int i = start; i < origChar.length; i++) {
            if (i < stop) {
                sub += origChar[i];
            }
        }

        return sub;
    }
}
