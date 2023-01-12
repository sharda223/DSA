

//Implement stack using linkedlist
public class ImplementStackUsingLinkedList {
    Node top = null;
    class Node {
        String data;
        Node next;

        // public Node(String data) {
        //     this.data = data;
        // }

        // public Node(String data,Node next) {
        //     this.data = data;
        //     this.next = next;
        // }

    }

    //Insert element in stack using linkedlist
    public void push(String data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = top;
        if(top == null) {
            top = newNode;
            return;
        }
        
        top = newNode;
    }

    public void pop() {
        if(top == null) {
            System.out.println("stack is empty");
            return;
        }
        top = top.next;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String peek() {
        if(!isEmpty()) {
            return top.data;
        } else {
            System.out.println("stack is empty");
            return null;
        }
    }

    public void display() {
        Node temp = top;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ImplementStackUsingLinkedList list = new ImplementStackUsingLinkedList();
        list.push("my");
        list.push("name");
        list.push("is");
        list.push("sharda");
        list.display();
        list.pop();
        list.display();
        list.peek();
        list.display();
        
    }
    
}
