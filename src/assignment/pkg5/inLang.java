/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg5;

/**
 *
 * @author slatz8075
 */
public class inLang {

    //create an array whos purpose it is to store the characters
    private char[] stack;
    //create a new string for the comparison
    private String newWord;
    //create a integer to forwards through the array
    private int revMove;

    public boolean inLang(String word) {
        //create a char array that is as long as the word
        stack = new char[word.length()];
        //start the revMove at 0
        revMove = 0;
        //put the characters into the array backwards using a for loop
        for(int pos = word.length()-1; pos >= 0; pos--){
            //make this position equal the corresponding character in the word
            stack[revMove] = word.charAt(pos);
            //move to the next array position
            revMove++;
        }
        //we now have the reverse string in char array form
        //create the string
        newWord = new String(stack);
        //now is this word equal to the old word and is it's center character a $ sign????
        if((newWord.contains(word)) && word.charAt(word.length()/2) == '$'){
            //we have confirmed that this word is a part of the language so return true
            return true;
        }else{
            //it is not so return false
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inLang p = new inLang();
        System.out.println("Is cat$tac apart of the language: " + p.inLang("cat$tac"));
        System.out.println("Is cat$cat apart of the language: " + p.inLang("cat$cat"));
        System.out.println("Is potato apart of the language: " + p.inLang("potato"));
        
    }
    
}
