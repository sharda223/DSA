package LLProblems;

class Node {
    int val;
    Node next;

    public Node() {

    }

    @Override
    public String toString() {
        return "Node [val=" + val + ", next=" + next + "]";
    }

    public Node(int val) {
        this.val = val;
    }
    Node(int val,Node next) {
        this.val = val;
        this.next = next;
    }
}

public class nthNodeProblem {

    Node head;

    

    public static int getSize(Node head) {
        Node curr = head;
        int count = 0;
        if(head == null) {
            //System.out.println("list is empty");
            return -1;
        }

        while(curr != null) {
            count++;
            curr = curr.next;
            
        }
        return count;
        
    }

    public static Node nthNode(Node head, int n) {
        int count = getSize(head.next);
        Node currNode = head;
        //Node temp = head.next;
        if(n <= 0) {
            return null;
        }

        while(count != n-1) {
            
            if(count < n-1) {
                if(currNode.next == null) {
                    return currNode;
                }
                System.out.println("fewer number of nodes in the list");
                return  null;
            } else if(count > n-1){
                currNode = currNode.next;
                count = getSize(currNode.next);
            }
        }
        return currNode;
        
    }

    public static void display(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
       // nthNodeProblem obj = new nthNodeProblem();
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node head = node1;
        display(head);
        
        Node result = nthNode(head, 6);
        System.out.println(result.toString());
        
    }
    
}
