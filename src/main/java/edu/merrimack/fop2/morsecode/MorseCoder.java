/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.merrimack.fop2.morsecode;

/**
 *
 * @author kmacr
 */
//***Need to change this to protected.
public class MorseCoder {

    //attributes
    //binary tree of type MorseLetter
    protected BinaryTree<MorseLetter> morseTree;

    //need a MorseLetter object as the data for the tree node
    MorseLetter root = new MorseLetter('$', " ");

    /**
     * Initialize the morseTree and add a BinaryNode representing the root (‘$’
     * == the character)
     */
    //Constructor
    public MorseCoder() {

        //set tree utilizes initializeTree???
        morseTree = new BinaryTree(root);
        setDefaultAlphabet();

        //or are we using setTree with what as parameters? 
        //reset the tree
        //morseTree.setTree(root, morseTree, morseTree);

    }

    //methods
    public void setDefaultAlphabet() {

        //adding the letters? 
        //just add to tree
        //addToTree('A', ".-")
        
        addToTree('A', ".-");
        addToTree('B', "-...");
        addToTree('C', "-.-.");
        addToTree('D', "-..");
        addToTree('E', ".");
        addToTree('F', "..-.");
        addToTree('G', "--.");
        addToTree('H', "....");
        addToTree('I', "..");
        addToTree('J', ".---");
        addToTree('K', "-.-");
        addToTree('L', ".-..");
        addToTree('M', "--");
        addToTree('N', "-.");
        addToTree('O', "---");
        addToTree('P', ".--.");
        addToTree('Q', "--.-");
        addToTree('R', ".-.");
        addToTree('S', "...");
        addToTree('T', "-");
        addToTree('U', "..-");
        addToTree('V', "...-");
        addToTree('W', ".--");
        addToTree('X', "-..-");
        addToTree('Y', "-.--");
        addToTree('Z', "--..");
        
        
        
      
    }

    /**
     * Takes a letter and its Morse code pattern (e.g. addToTree(‘A’, “.-“) ).
     * This should add a MorseLetter to the appropriate BinaryNode in the tree.
     *
     * @param letter
     * @param pattern
     */
    //Have a binary tree that we want to add nodes to. 
    //The nodes data are of type MorseLetter
    //Is it supposed to be void or return a MorseLetter?    
    public void addToTree(char letter, String pattern) {
        //add the letter to the tree
        //have to call the private version of the add to tree
        //start recursion here, then recurse over the private method. 
        
        addToTree(letter, pattern, pattern, morseTree.getRootNode());

    }

    /**
     * The private version of this method should be a recursive call that calls
     * itself, minus The leading morse character each time through the recursive
     * loop.
     *
     * @param letter
     * @param pattern
     * @param originalPattern
     * @param subTreeRoot
     */
    private void addToTree(char letter, String pattern, String originalPattern, BinaryNode<MorseLetter> subTreeRoot) {

        //create a morseLetter
        //this is the data of the node
        MorseLetter morseLetter = new MorseLetter(letter, originalPattern);

        //base case, there are no characters left in the pattern. 
        if (pattern == null || pattern.isEmpty() ) {
            //add the item (letter) to that node
            subTreeRoot.setItem(morseLetter); // subTreeRoot is the current node. 
        } //if not at the end of the string
        else {
            //get rid of the first element of pattern
            if (pattern.charAt(0) == '.') {
                //remove the char from the pattern
                pattern = pattern.substring(1);
            

                //add node to the left child subtree if null
                if (subTreeRoot.getLeftChild() == null) {
                    BinaryNode newNode = new BinaryNode();
                    subTreeRoot.setLeftChild(newNode);
                }
            

                //make recursive call with the left child subtree. 
                addToTree(letter, pattern, originalPattern, subTreeRoot.getLeftChild());
                
            }

            else if (pattern.charAt(0) == '-') {
                    //remove the char from the pattern
                    pattern = pattern.substring(1);

                    //add node to right child subtree if null
                    if (subTreeRoot.getRightChild() == null) {
                        BinaryNode newNode = new BinaryNode();
                        subTreeRoot.setRightChild(newNode);

                    }

                    //make recursive call with the right child subtree. 
                    addToTree(letter, pattern, originalPattern, subTreeRoot.getRightChild());
                }
            }

        }

    
   /**
    * Traverse tree preOrder and return string
    * @return 
    */
    public String traverseTreePreorder(){
        //visit a node then perfrom an operation on that node 
        //define visit? 

        //base case is an empty tree
        // return the result of a recursive call that starts at the root node of the tree like this:
        //return traverseTreePreorder(morseTree.getRootNode())
        
        return traverseTreePreorder(morseTree.getRootNode());
        

    }
    

    private String traverseTreePreorder(BinaryNode<MorseLetter> rootNode) {

        //visit
        //left
        //right
        
        //****why do I have to have the "" part. 
        String preOrderString = "";

        //base case is if the node is null 
        if (rootNode == null) {
            //dont understand this, I dont want to return preOrderString here 
            return preOrderString;
        }
        //update the string with the letter. 
        char r = rootNode.getItem().getLetter();
        preOrderString = preOrderString + r;

        //call traverseTreePrOrder with left child of root. 
        //should keep recursively calling tracerseTreePreorder on the leftchild until its null in which
        //case it will check the rightchild. 
        //These return the updated string
        
        
        String leftResult = traverseTreePreorder(rootNode.getLeftChild());
        String rightResult = traverseTreePreorder(rootNode.getRightChild());
        
        
        //For the other traversal types, the order here will be different. 
        String finalString = preOrderString+ leftResult + rightResult;
        
        
        


        return finalString;
    }
    
    /**
     * Traverse tree postOrder and return string
     * @return 
     */
    public String traverseTreePostorder(){
      
        return traverseTreePostorder(morseTree.getRootNode());

    }
    
    private String traverseTreePostorder(BinaryNode<MorseLetter> rootNode) {

        String postOrderString = "";

        if (rootNode == null) {
            return postOrderString;
        }
        
        //first recur on the left
        String leftResult = traverseTreePostorder(rootNode.getLeftChild());
        
        //second recur on the right
        String rightResult = traverseTreePostorder(rootNode.getRightChild());
        
        //visit
        char r = rootNode.getItem().getLetter();
        postOrderString = postOrderString + r;
        
        //For the other traversal types, the order here will be different. 
        String finalString = leftResult + rightResult + postOrderString;

        return finalString;
    }
    
    public String traverseTreeInorder(){
      
        return traverseTreeInorder(morseTree.getRootNode());

    }
    
    
    /**
     * Traverse tree inOrder and return string
     * @param rootNode
     * @return 
     */
    private String traverseTreeInorder(BinaryNode<MorseLetter> rootNode) {

        //left
        //visit
        //right
        
        String inOrderString = "";

        if (rootNode == null) {
            return inOrderString;
        }
        
        //left
        String leftResult = traverseTreeInorder(rootNode.getLeftChild());
        
        //visit
        char r = rootNode.getItem().getLetter();
        inOrderString = inOrderString + r;
        
        //right
        String rightResult = traverseTreeInorder(rootNode.getRightChild());
        
        //For the other traversal types, the order here will be different. 
        String finalString = leftResult + inOrderString +   rightResult;

        return finalString;
    }
                
    public void setCustomAlphabet(char[] letters, String[] patterns){
        
        //MorseLetter array
        
        //linked list
        //LinkedList<MorseLetter> morseArray = new LinkedList<>();
        
        //create a tree
        morseTree = new BinaryTree(root);
        
        //and add the root node here because calling this method doesn't call the constructor.
        
        
        
        //dont need to create a separate linked list or array? 
        MorseLetter [] morseArray;
        
        //iterate through lists create letters
        for (int i = 0; i < letters.length; i++){
            //for each element in the arrays, addToTree 
            addToTree(letters[i], patterns[i]);
            
            //morseArray[i] = new MorseLetter(letters[i], patterns[i]);
            
            
        }
    }

}
