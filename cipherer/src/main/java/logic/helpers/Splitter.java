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
public class Splitter {

    /**
     *
     * @param text String to be splitted
     * @param splitter char that determines split points
     * @return String[] that contains all substrings of the original string,
     * splitted at all occurrences of splitter parameter
     */
    public static String[] split(String text, char splitter) {
        char[] charText = text.toCharArray();
        int splittedLength = 1;
        for (char c : charText) {
            if (c == splitter) {
                splittedLength++;
            }
        }

        String[] splitted = new String[splittedLength];
        for (int i = 0; i < splittedLength; i++) {
            splitted[i] = "";
        }

        String part = "";
        int index = 0;

        for (int i = 0; i < charText.length; i++) {
            if (charText[i] != splitter) {
                part += charText[i];
                if (i == charText.length - 1) {
                    splitted[index] = part;
                }
            } else if (charText[i] == splitter) {
                splitted[index] = part;
                index++;
                part = "";
            }
        }

        return splitted;
    }
}
