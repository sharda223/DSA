package DoublyLinkedList;

public class DLL {

    Node head;

    class Node {
        int val;
        Node next; 
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    //insert at begining
    public void InsertAtBig(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev = null;
        if(head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    //insert at end
    public void InsertLast(int val) {
        Node node = new Node(val);
        Node last = head;

        if(head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while(last.next != null) {
          last = last.next;  
        }
        last.next = node;
        node.next = null;
        node.prev = last;
    }

    //Insert at any position
    public void InsertAnyPos(int val, int position) {
        Node newNode = new Node(val);
        Node CurrNode = head;
        int index = 0;
        while(index < position-1) {
            CurrNode = CurrNode.next;
            index++;
        }
        newNode.next = CurrNode.next;
        CurrNode.next = newNode;
        newNode.prev = CurrNode;
        newNode.next.prev = newNode;
    }

    //Delete at first
    public void DeleteFirst() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }
        head = head.next;
        head.prev = null;
    }

    //Delete at last
    public void DeleteLast() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }

        if(head.next == null) {
            head = null;
            return;
        }
        Node seconeLastNode = head;
        Node LastNode = head.next;

        while(LastNode.next != null) {
            LastNode = LastNode.next;
            seconeLastNode = seconeLastNode.next;
        }
        seconeLastNode.next = null;
    
    }

    //Delete at any pos
    public void DeleteAnyPos(int position) {
        Node temp = head;
        Node ptr = head.next;
        for(int i=0; i<(position-2); i++) {
            temp = ptr;
            ptr = ptr.next;
        }
        temp.next = ptr.next;
        ptr.next.prev = temp;
    }

    public void display() {
        Node node = head;
        Node last = null;
        while(node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println(" END");

        System.out.println("Print in reverse");
        while(last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }
    public static void main(String[] args) {
        DLL list = new DLL();
        list.InsertAtBig(2);
        list.InsertAtBig(3);
        list.InsertAtBig(5);
        list.InsertAtBig(6);
        list.InsertLast(100);
        list.InsertAnyPos(99, 4);
        list.DeleteFirst();
        list.DeleteLast();
        list.DeleteAnyPos(3);
        list.display();
        
    }
    
}
