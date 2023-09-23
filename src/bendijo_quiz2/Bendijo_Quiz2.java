
package bendijo_quiz2;

import java.util.Scanner;

class Node {
        int data;
        Node next;
        
        Node (int m){
            data = m;
            next = null;
        }
    }

public class Bendijo_Quiz2 {
    
public static Node head, tail;
private int size;

 public Node insertNode (int data){
    Node newNode = new Node (data);
    newNode.next = head;
    head = newNode;
    return head;
    }
        public void display(){
         Node node = head;
         
      
            while (node != null){
                System.out.println(node.data+"");
                node = node.next;
     }
         System.out.println();
     }
    public void display1() throws Exception{
        if (size == 0) {
            throw new Exception("List is empty");
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println();
     }
     
     
     public boolean search (int target){
             Node current = head;
             
             while(current != null){
                 if (current.data == target){
                     return true;
                 }
                 current = current.next;
             }
             return false;
     }
    
    public int searchPosition(int target){
    Node current = head;
    int pos = 0;
        while (current != null) {            
            if (current.data == target) {
                return pos;
                
            }
            current = current.next;
            pos++;
        }
        return -1;
    }
       
    private Node createNewNode(int index) throws Exception {
        Node node = new Node(index);
        node.data = index;
        node.next = null;
        return node;
    }

    private void insertion(int index, int position) throws Exception {
        if (position < 0 || position > size) {
            throw new Exception("Invalid Index");
        } else if (position == 0) {
            insertBeginning(index);
        } else if (position == size) {
            insertEnd(index);
        } else {
            Node node = createNewNode(index);
            Node prev = getNodeAt(position - 1);
            node.next = prev.next;
            prev.next = node;
            tail.next = head;
            size++;
        }
    }

    private void insertBeginning(int index) throws Exception {
        Node node = createNewNode(index);
        if (size == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        tail.next = head;
        size++;
    }

    private void insertEnd(int index) throws Exception {
        Node node = createNewNode(index);
        if (size > 0) {
            tail.next = node;
            tail = node;
        } else if (size == 0) {
            head = tail = node;
        }
        tail.next = head;
        size++;
    }
      private Node getNodeAt(int position) throws Exception {
        if (size == 0) {
            throw new Exception("Linked list is empty");
        } else if (position < 0 || position >= size) {
            throw new Exception("Invalid Position");
        } else {
            Node current = head;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            return current;
        }
    }
    
    public static void main(String[] args) throws Exception {
        Bendijo_Quiz2 mm = new Bendijo_Quiz2 ();
        
        Scanner scan = new Scanner(System.in);
        boolean number = true;
        
        while (number){
            
            System.out.println("\nNumber?? 1, 2,");
                    
            int choice = scan.nextInt();
            
                if (choice  == 1){
                   mm.insertNode(1000);
                   mm.insertNode(1);
                   mm.insertNode(554);
                   mm.insertNode(234);
                   mm.insertNode(884);
                   mm.insertNode(10);
                   mm.display();
                   
                    System.out.println("Enter the number you want to search");
                    int search = scan.nextInt();
                    
                    int targetVal = search;
        
                    int posi = mm.searchPosition(targetVal);
        
                    if (posi != -1) {
                     System.out.println("The " + targetVal + " is here");
                            } else {
                     System.out.println("The "+ targetVal + " is not here");
            
                            }
                }else if (choice == 2){
                    
                    while (number) {
                    System.out.println("1. Insert");             
                    System.out.println("2. Display");
                    int input = scan.nextInt();
                    
                    switch (input){
                        case 1: 
                            System.out.println("Insert Element");
                            int element = scan.nextInt();
                            System.out.println("Enter Position");
                            int position = scan.nextInt();

                    mm.insertion(element, position - 1);      
                    break;
                    
                        case 2:
                            mm.display1();
                            break;
                            
                        default:
                            System.out.println("WRONG CHOICE");
                }
                    }

        }else {
                    System.out.println("Invalid Choice \n TRY AGAIN");
                }
        
    }
    
    }
    
}
