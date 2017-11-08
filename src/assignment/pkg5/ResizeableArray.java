/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg5;

/**
 *
 * @author slatz8075
 */
public class ResizeableArray {

    /**
     * @param args the command line arguments
     */
    //create an array
    private int[] array;
    //create an integer to store how many items are in the list
    private int numItems;
    
    //create the array
    public ResizeableArray(){
        //set the size of the array
        array = new int[10];
        //set the inital number of items in the array
        numItems = 0;
    }
    
    //ADDING
    public void add(int index, int num){
        //check to see if adding a number to the array will exceed the length of the array
        if(numItems + 1 > array.length){
            //it is so create a new array twice the length of the current array
            int[] arrayTemp = new int[array.length*2];
            //transfer the numbers of the first array to this new one using a for loop 
            for(int pos = 0; pos < numItems; pos++){
                //transfer this position's number to the new array
                array[pos] = arrayTemp[pos]; 
            }
            //rename the new array 
            arrayTemp = array;
        }
        //now add the item to the array
         
                //ITEMS BEING SHUFFLED DOWN THE LIST IS REQUIRED
    }
    
    //REMOVE
    public void remove(int index){
        
    }
    
    //SIZE ASKING
    public int size(){
        //tell the user how many items are in the array
        return numItems;
    }
    
    //IS IT EMPTY?
    public boolean isEmpty(){
        //return true or false based on there being items in the array or not
        return numItems == 0;
    }
    
    //GET
    public int get(int index){
        //tell the user the number at this position
        return array[index];
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        // create a resizable array
        
    }
}
