package SinglyLinkedList;

public class LL {
    Node head;
    private int size;

    LL() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;
    
        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }          
    }
    
    //add - first position
    public void addFirst(String data) {
        Node newNode = new Node(data);
        
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next  = head;
        head = newNode;
    }

    //add - last position
    public void addLast(String data) {
        Node newNode = new Node(data);
        
        if(head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    //print
    public void printList() {
        if(head == null) {
            System.out.println("list is empty");
            return; 
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    //delete first
    public void deleteFirst() {
        if(head == null) {
            System.out.println("The list is empty");
            return;
        }

        size--;
        head = head.next;
    }

    //delete last
    public void deleteLast() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }

        size--;
        
        if(head.next == null) {
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null) {
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }

        secondLast.next = null; 
    }

    public int getSize() {
        return size;
    }

     public void reverseIterate() {
        if(head == null || head.next == null) {
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
            
        }
        head.next = null;
        head = prevNode;
     }

     public Node reverseRecursive(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
     }

     public Node InsertAtAnyPos(String data, int position) {
        Node newNode = new Node(data);
        Node currNode = head;

        int index = 0;

        while(index < position-1) {
            currNode = currNode.next;
            index++;
        }

        newNode.next = currNode.next;
        currNode.next = newNode;

        return head;
        
     }

     public void DeleteAtAnyPos(int position) {
        Node temp = head;
        Node ptr = temp.next;

        for(int i=0; i<(position-2); i++) {
            temp = ptr;
            ptr = ptr.next;
        }
        temp.next = ptr.next;
     }
    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.printList();

        list.addLast("list");
        list.printList();

        list.addFirst("this");
        list.printList();

        // list.deleteFirst();
        // list.printList();

        // list.deleteLast();
        // list.printList();

        // System.out.println(list.getSize());

        // list.reverseIterate();
        // list.printList();

    //    list.InsertAtAnyPos("linked", 3);
    //    list.printList();
         
        list.DeleteAtAnyPos(3);
        list.printList();
    
    }
    
}
