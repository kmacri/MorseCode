/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.merrimack.fop2.morsecode;

/**
 *
 * @author kmacr
 */
public class MorseEncoder extends MorseCoder{
    
    
    
    /**
     * //this should call the constructor of MorseCoder to initialize the 
     * to initialize the default morse alphabet in the binary tree 
     */
    //constructor
    public MorseEncoder(){
        //this will call the constructor of MorseCoder which is the super class 
        //Take a look at the shape class videos again. 
        super();
        
    }
    
   
    
    
    
    
    /**
     * take a letter as a char and the root node from the tree and then recursively call 
     * the private version of encodeLetter until it finds the
     * Morse code pattern for the letter in the tree
     * @param letter
     * @return 
     */
    public String encodeLetter(char letter){
        
        
        return encodeLetter(letter, morseTree.getRootNode());
        
        //String finalString = encodeLetter(letter, morseTree.getRootNode());
        
        //recursively call the private version of encodeLetter until it finds the 
        //Morse code pattern for the letter in the tree
        
    }
    
    
    /**
     * //traverse the tree node by node until it finds the letter and return the morse code pattern for that letter
        //use preorder, postorder or inorder.
     * @param letter
     * @param rootNode
     * @return 
     */
    private String encodeLetter(char letter, BinaryNode<MorseLetter> rootNode){
        
        //traverse the tree node by node until it finds the letter and return the morse code pattern for that letter
        //use preorder, postorder or inorder. 
        
        // //encodeLetter almost works. You need to check if rootNode is null at the beginning to avoid the 
        //NullPointerException and return from your recursion. You also have an extra '|' at the end once
        //I added the null check.
        
        //preorder
            //visit()
            //left()
            //right()
        String thisString = "";
       
        
        if (rootNode == null){
            return thisString;
        }
        
        
        //base item = letter
        if (rootNode.getItem().getLetter() == letter){
            return rootNode.getItem().getPattern();
        }        
        
        //perform again with the leftchild
        thisString = encodeLetter(letter, rootNode.getLeftChild()); 
        
        if (thisString != null && !thisString.isEmpty()){
            return thisString;
        }
        
        //if there is no left child perform on the right child.
        thisString = encodeLetter(letter, rootNode.getRightChild());
        if (thisString != null && !thisString.isEmpty()){
            return thisString;
        }
        
        
        
        return thisString;
        
    }
    
    
    /**
     * for each char in the phrase return the morse code pattern
     * @param phrase
     * @return 
     */
    public String encodePhrase(String phrase){
        
        String encodedPhrase = "";

        for (int i = 0; i < phrase.length(); i++){
            //for each char in the phrase return the morse code pattern
            //encodeLetter returns the pattern 
            String letterAsPattern = encodeLetter(phrase.charAt(i));
            if (i == phrase.length() -1 ){
                encodedPhrase = encodedPhrase + letterAsPattern;
            }
            else {
                encodedPhrase =  encodedPhrase + letterAsPattern + '|';
            }
            
        }
        
        return encodedPhrase;
    }
    
}
