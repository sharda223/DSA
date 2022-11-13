package LLProblems;

//find nth node from the last after that delete that nth  node

public class problems {
    
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val,Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public Node removeNthNodeFromEnd(Node head, int n) {
        if(head.next == null) {
          return null;  
        }

        int size = 0;
        Node currNode = head;
        while(currNode != null) {
            currNode = currNode.next;
            size++;
        }

        if(n == size) {
            return head.next;
        }
          
        int indexToSearch = size - n;
        Node prev = head;
        int i = 1 ;
        while(i < indexToSearch) {
            prev = prev.next;
            i++;

        }
        prev.next = prev.next.next;
        return head;
    }
    
}
