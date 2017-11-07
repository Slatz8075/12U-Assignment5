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

    public OrderedList() {
        head = null;
        numItems = 0;
    }

    public void add(int num) {
        //start at beginning of list
        IntNode node = head;
        //create the new node
        IntNode temp = new IntNode(num);
        //see if it is the first item
        if (node == null) {
            head = temp;
            //check to see if the num in question is less or equal to the head than the head
        } else if (num <= head.getNum()) {
            //therefore it needs to go at the very front of the line
            temp.setNext(head);
            head = temp;
        } else {
            //travel through to the end
            while (true) {
                //check this position's number with the number we are trying to insert
                if (node.getNext() == null || num <= node.getNext().getNum()) {
                    //insert it into the list
                    //set this new nodes's pointer to the next node in line, as long as it is not the end of the line
                    if (node.getNext() != null) {
                        //set the pointer
                        temp.setNext(node.getNext());
                    }
                    //now set the current-node-in-question's pointer to this new node
                    node.setNext(temp);
                    //break the while loop
                    break;
                }
                //the if statement hasn't triggered so travel to the next node
                node = node.getNext();
            }
        }
        //Increase the size counter
        numItems++;
    }

    public void remove(int num) {
        //start at beginning of list
        IntNode node = head;
        //keep a integer to store which node we are on
        int pos = 0;
        //create a while loop to go through checking and advancing
        while (true) {
            //check to see if this node's number is the number the user it looking for
            if (node.getNum() == num) {
                //it is so remove it from the list
                //check the special case where it is at the beginning of the list
                if (node == head) {
                    //just set the head to be the next node in line
                    head = node.getNext();
                    //subtract one from the list count
                    numItems--;
                    //and break the loop
                    break;
                    //now check the case where the node is at the end
                }else if (node.getNext() == null) {
                    //we know that this node is the number of items in the list - 1
                    //so start at the beginning of the list again
                    node = head;
                    //now use a for loop to move through the list until we are just infront of the item we want to delete
                    for (int i = 0; i < numItems - 1; i++) {
                        //move forward
                        node = node.getNext();
                    }
                    //now we are just infront of the item we want to delete
                    //so set its pointer to null
                    node.setNext(null);
                    //subtract one from the list count
                    numItems--;
                    //and break the loop
                    break;
                    //therefore the num is between the front and the end of the list
                } else {
                    //since we have kept track of which node we are on with the pos variable
                    //we can start at the head
                    node = head;
                    //and use a for loop to advance up until the item we want to delete
                    for(int i = 0; i < pos-1; i++){
                        //move to the next node in line
                        node = node.getNext();
                        System.out.println("for loop triggered");
                    }
                    System.out.println("Position: " + pos);
                    //now we know that the next node in line is to be deleted
                    //so set the pointer to the node after the next one
                    node.setNext(node.getNext().getNext());
                    //subtract one from the list count
                    numItems--;
                    //and break the loop
                    break;
                }
            }
            //check to see if we have made it to the end of the list
            if(node.getNext() == null){
                //we are so break out of the loop
                break;
            }
            //we have not yet found our number to continue advancing through the list
            node = node.getNext();
            //also update which node we are on
            pos++;
        }
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int index) {
        IntNode node = head;
        //move the number of times
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node.getNum();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderedList list = new OrderedList();
        System.out.println("Adding...");
        list.add(2);
        list.add(-5);
        list.add(4);
        list.add(3);
        list.add(0);
        list.add(3);
        list.add(-2);
        System.out.println("The List: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.remove(-5);
        list.remove(2);
        list.remove(4);
        System.out.println("Removed -5, 2 and 4");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
