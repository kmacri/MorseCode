/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.merrimack.fop2.morsecode;

/**
 *
 * @author kmacr
 */
public class MorseDecoder extends MorseCoder {
    
    //constructor 
    public MorseDecoder(){
        super();
    }
    
    
    public char decodeLetter(String pattern){
        
        return decodeLetter(pattern, morseTree.getRootNode());
    }
    
    private char decodeLetter(String pattern, BinaryNode<MorseLetter> rootNode){
        
        //examine the first character of the pattern
        //If there is no pattern left (base case), return the letter at the current node.
        //If it is a dot, then you should go down the left child subtree. 
        //f it is a dash, then you should go down the right child subtree. 
        //Then you should recursively call this method with your subtree, removing 
        //the first character from the pattern and repeating until you hit the base case
        //which should give you the letter.
        
        
        char thisChar;
        
        //base case (left) there is no left child return the letter at current node
        if (rootNode.getLeftChild() == null){
            //return the letter at the current node 
            return rootNode.getItem().getLetter();
        }
        
        if (pattern.charAt(0) == '.') {
            //Go down the left child 
            
            //subTree leftNode
            BinaryNode leftNode = rootNode.getLeftChild();
            
            //remove first char of the pattern 
            pattern = pattern.substring(1);
            
            //recursively call with subtree and new pattern
            thisChar = decodeLetter(pattern, leftNode);
            
            //need return to keep from going right into the '-' block 
            
            return thisChar;
            
            
        }
        if (pattern.charAt(0) == '-') {
            //Go down the right child 
            
            //subTree rightNode
            BinaryNode rightNode = rootNode.getRightChild();
            
            //remove first char of the pattern 
            pattern = pattern.substring(1);
            
            //recursively call with subtree and new pattern
            thisChar = decodeLetter(pattern, rightNode);
            ////Check this ************
            ////Need a check here and return here if null or emptyif (thisChar   ){
                //return thisChar;
                
            //
            
            return thisChar;
            
            
            
        }
        
        return rootNode.getItem().getLetter();
        
        
        
        }
    
    /**
     * Takes a phrase, leverages decode letter to decode each letter in the phrase to morsecode
     * @param phrasePattern
     * @return 
     */
    public String decodePhrase(String phrasePattern){
        //split phrasePattern in string array 
        String[] morsePatterns = phrasePattern.split("\\|");
        
        //empty string for decoded phrase
        String decodedString = "";
        
        //iterate through array decoding each phrase
        for(int i = 0; i < morsePatterns.length; i++){
            //decode each part of the phrase and add it to the string 
            decodedString = decodedString + decodeLetter(morsePatterns[i]);
        }
        
        return decodedString;
    }
            

            
}
