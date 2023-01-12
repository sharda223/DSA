package Queues;

public class LinkedListImplementation {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }
    
        static Node head = null;
        static Node tail = null;
        static int length;

        public static boolean isEmpty(){
            return head == null & tail == null;
        }

        public static void Enqueue(int data) {
            Node newNode = new Node(data);
            if(tail == null) {
                head = tail = newNode;
                length++;
                return;
            }
            tail.next = newNode;
            tail = newNode;
            length++;
        }

        public static int Dequeue() {
            if(isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int front = head.data;
            if(head == tail) {
                tail = null;
            }
            head = head.next;
            length--;
            return front;
        }

        public static int Peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }

        public static void display() {
            Node temp = head;
            while(temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        public static int getSize() {
            return length;
        }
        public static void main(String[] args) {
            Enqueue(1);
            Enqueue(2);
            Enqueue(3);
            Enqueue(4);
            Enqueue(5);
            display();
            System.out.println(String.format("Queue are in %d elements", getSize()));
            Dequeue();
            display();
            System.out.println(String.format("Queue are in %d elements", getSize()));
            System.out.println(Peek());
        }
  
}
