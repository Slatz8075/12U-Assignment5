/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg5;

/**
 *
 * @author slatz8075
 */
public class OrderedList {
    
    private IntNode head;
    private int numItems;
    
    public OrderedList(){
        head = null;
        numItems = 0;
    }
    
    public void add(int num){
        //start at beginning of list
        IntNode node = head;
        //see if it is the first item
        if(node == null){
            IntNode temp = new IntNode(num);
            head = temp;
        } else {
            //travel to end
            while(node.getNext() != null){
                //travel to next node
                node = node.getNext();
            }
            //node is the last node in the list
            //create the new node
            IntNode temp = new IntNode(num);
            //insert it into the list
            node.setNext(temp);
        }
        //Increase the size counter
        numItems++;
    }
    
    public void remove(int num){
        //if removeing from start
        if(pos == 0){
            head = head.getNext();
        } else if(pos == numItems - 1){
            //removeing from the end
            IntNode node = head;
            //moveing to the 2nd last item
            for(int i = 0; i < numItems - 1; i++){
                node = node.getNext();
            }
            //sever the link
            node.setNext(null);
        }else{
            IntNode node = head;
            //move to the spot just before
            for(int i = 0; i < pos - 1; i++){
                node = node.getNext();
            }
            //the node to remove
            IntNode toRemove = node.getNext();
            //its next node
            IntNode next = toRemove.getNext();
            //set all the links
            node.setNext(next);
            toRemove.setNext(null);
        }
        numItems--;
    }
    
    public int size(){
        return numItems;
    }
    
    public boolean isEmpty(){
        return numItems == 0;
    }
    
    public int get(int index){
        IntNode node = head;
        //moev the number of times
        for(int i = 0; i < position; i++){
            node = node.getNext();
        }
        return node.getNum();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderedList list = new OrderedList();
        list.add(2);
        list.add(-5);
        list.remove(1);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
