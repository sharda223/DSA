package CircularLinkedList;

public class CLL {

    Node head;
    Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next; 
        }
    }

    //Insert to tail
    public void InsertToTail(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return; 
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode; 

    }

    //Insert to head
    public void InsertToHead(int val) {
        Node newNode = new Node(val);
        if(tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            head = newNode;
        }
        
    }

    //Insert any position
    public Node InsertAnyPos(int val, int position) {
        Node newNode = new Node(val);
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

    //remove from head
    public void DeleteFromHead() {
        if(head == null) {
            System.out.println("list is empty");
        }
        head = head.next;
        tail.next = head;
       
    }

    //remove from tail
    public void DeleteFromTail() {
        Node secondLastNode = head;
        Node LastNode = head.next;
        if(head == null) {
            System.out.println("list is empty");
        }
        if(head.next == null) {
            head = null;
            return;
        }
        while(LastNode != tail) {
            LastNode = LastNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = head;
        secondLastNode = tail;
    }

    //remove any val
    public void DeleteAnyVal(int val) {
        Node temp = head;
        if(head == null) {
            System.out.println("list is empty");
        }
        if(temp.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = temp.next;
            if(n.val == val) {
                temp.next = n.next;
                break;
            }
            temp = temp.next;
        } while(temp != head);
    }


    public void display() {
      Node node = head;
      if(head != null) {
        do {
            System.out.print(node.val + " -> ");
            node = node.next;
        } while(node != head);
      }  
      System.out.println("HEAD");
    }

 
    public static void main(String[] args) {
        CLL list = new CLL();
        list.InsertToTail(5);
        list.InsertToTail(10);
        list.InsertToTail(15);
        list.InsertToTail(20);
        list.InsertToHead(4);
        list.InsertToHead(2);
        list.display();
        list.InsertAnyPos(50, 5);
        list.DeleteFromHead();
        list.display();
        list.DeleteFromTail();
        list.display();
        list.DeleteAnyVal(10);
        list.display();
    }
     
    
}
