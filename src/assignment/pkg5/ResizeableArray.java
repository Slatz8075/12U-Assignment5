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
        System.out.println(num);
        //check to see if the index position is greater than the number of items recorded in the list
        if(index > numItems){
            //it is so interpret this at being the last position 
            index = numItems;
        }
        //check to see if adding a number to the array will exceed the length of the array
        if(numItems + 1 > array.length){
            //it is so create a new array twice the length of the current array
            int[] arrayTemp = new int[array.length*2];
            //transfer the numbers of the first array to this new one using a for loop 
            for(int pos = 0; pos < numItems; pos++){
                //transfer this position's number to the new array
                arrayTemp[pos] = array[pos];
            }
            //rename the new array 
            array = arrayTemp;
        }
        //now add the item to the array
        //shift the items down the line using a for loop - starting at the end 
        for(int pos = numItems - 1; pos >= index; pos--){
            //set this array position's number to the next position's number down the line
            array[pos+1]= array[pos];
        }
        //so now there is an open spot at the index that user wants their number at
        //so set the position to the num
        array[index] = num;
        //add one to item counter
        numItems++;
    }
    
    //REMOVE
    public void remove(int index){
        //shift the items forward into the spot
        for(int pos = index; pos < numItems; pos++){
            //set this array position's number to the next position's number down the line
            array[pos]= array[pos+1];
        }
        //update the counte
        numItems--;
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
        ResizeableArray array = new ResizeableArray();
        //check to see if empty
        System.out.println("Empty?: " + array.isEmpty());
        //add numbers
        System.out.println("Adding...");
        array.add(0, 1);
        array.add(1, 4);
        array.add(3, 5);
        
        array.add(1, 3);
        array.add(1, 2);
        
        array.add(5, 0);
        array.add(6, 0);
        array.add(7, 0);
        array.add(8, 0);
        array.add(9, 0);
        array.add(10, 0);
        
        System.out.println("Size: " + array.size());

        //print the array
        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
        }
        
        System.out.println("removing... 2");
        
        array.remove(1);
        
        //print the array
        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
        }
        System.out.println("Size: " + array.size());
        
        System.out.println("Get index 3: " + array.get(3));
        
    }
}
