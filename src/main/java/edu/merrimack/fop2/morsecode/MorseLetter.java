/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.merrimack.fop2.morsecode;

/**
 *This creates letter objects (a container) and its morse pattern
 * The MorseLetter is the object (the ‘T’) that we will store in the BinaryTree / BinaryNode classes
 * @author kmacr
 */
public class MorseLetter {
    
    //attributes
    private char letter;
    private String pattern;
    
    
    //contructor 
    public MorseLetter(char letter, String pattern){
        this.letter = letter;
        this.pattern = pattern;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public char getLetter() {
        return letter;
    }

    public String getPattern() {
        return pattern;
    }
    
    
    
}
