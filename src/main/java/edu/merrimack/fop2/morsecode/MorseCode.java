/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edu.merrimack.fop2.morsecode;

/**
 *
 * @author kmacr
 */
public class MorseCode {

    public static void main(String[] args) {
        
        //MorseCoder constructor creates a binary tree and setsDefualtAlphabet
        //default aphabet adds the letters to the tree
        
        MorseCoder morseTree = new MorseCoder();
        
        
        //encode tests
        //MorseEncoder newEncoder = new MorseEncoder();
        //String encodeTestString = newEncoder.encodeLetter('P');
        //System.out.println(encodeTestString);
        
        //traverseTree calls public version of traverseTree with root node
        String preOrderTree = morseTree.traverseTreePreorder();
        System.out.println(preOrderTree);
        String inOrderTree = morseTree.traverseTreeInorder();
        System.out.print(inOrderTree);
        
        MorseDecoder newDecoder = new MorseDecoder();
        
        
    }
}
