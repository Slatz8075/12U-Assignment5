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
        //see if it is the first item
        if (node == null) {
            IntNode temp = new IntNode(num);
            head = temp;
            System.out.println("added");
        } else {
            //travel to end
            while (node.getNext() != null) {
                //check this position's number with the number we are trying to insert
                if (num < node.getNext().getNum()) {
                    //create the new node
                    IntNode temp = new IntNode(num);
                    //insert it into the list
                    //set this new nodes's pointer to the next node in line
                    temp.setNext(node.getNext());
                    //now set the current-node-in-question's pointer to this new node
                    node.setNext(temp);
                    
                    System.out.println("added");
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

    /*
    public void remove(int num) {
        //if removeing from start
        if (pos == 0) {
            head = head.getNext();
        } else if (pos == numItems - 1) {
            //removeing from the end
            IntNode node = head;
            //moveing to the 2nd last item
            for (int i = 0; i < numItems - 1; i++) {
                node = node.getNext();
            }
            //sever the link
            node.setNext(null);
        } else {
            IntNode node = head;
            //move to the spot just before
            for (int i = 0; i < pos - 1; i++) {
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

*/
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
        list.add(2);
        list.add(-5);
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i));
        }
    }
}
