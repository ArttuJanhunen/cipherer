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
public class Pair {

    private int number;
    private char letter;

    public Pair(char letter, int number) {
        this.number = number;
        this.letter = letter;
    }

    /**
     * 
     * @return returns char value of the pair
     */
    
    public char getChar() {
        return this.letter;
    }

    /**
     * 
     * @return returns integer value of the pair
     */
    
    public int getNumber() {
        return this.number;
    }
}
