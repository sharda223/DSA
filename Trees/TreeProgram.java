package Trees;

import java.util.LinkedList;
import java.util.Stack;

public class TreeProgram {

    //Inserting into Binary Tree
    static void insertIntoBinaryTree(Node root, int data) {
        Node temp;
        if(root == null) {
            temp = new Node(data);
            root = temp;
            return;
        } else {
            // inserting left node
            if(data < root.data) {
                if(root.left == null) {
                    root.left = new Node(data);
                } else {
                    insertIntoBinaryTree(root.left, data);
                }
            }
            // inserting right node
            if(data > root.data) {
                if(root.right == null) {
                    root.right = new Node(data);
                } else {
                    insertIntoBinaryTree(root.right, data);
                }
            }
        }
    }

    // Recursive Approach
    
    static void Preorder(Node root) {
       if (root == null) {
        return;
       }
       System.out.print(root.data + " ");
       Preorder(root.left);
       Preorder(root.right); 
    }

    static void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    static void Postorder(Node root) {
        if (root == null) {
            return;
        }
        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Iterative Approach

    static void IterativePreorder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<Node>();
        s.add(root);
        while(!s.isEmpty()) {
            root = s.pop();
            System.out.print(root.data + " ");
            if (root.right != null) {
                s.push(root.right);
            }
            if (root.left != null) {
                s.push(root.left);
            }
        }
    }

    static void IterativeInorder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s = new Stack<Node>();
        while(true) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                if (s.isEmpty()) {
                    break;
                }
                root = s.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }

    // Iterative Postorder Traversal using two stack

    static void IterativePostorder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(root);
        while(!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) {
                s1.push(root.left);
            }
            if (root.right != null) {
                s1.push(root.right);
            }
        }
        while(!s2.isEmpty()) {
            root = s2.pop();
            System.out.print(root.data + " ");
        }
    }

    // Iterative Postorder Traversal using one stack

    static void IterativePostorderUsingOneStack(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<Node>();
        while(current != null || !stack.isEmpty()) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                Node temp = stack.peek().right;

                if(temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");

                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(9);
        insertIntoBinaryTree(root, 15);
        insertIntoBinaryTree(root, 1);
        insertIntoBinaryTree(root, 12);
        insertIntoBinaryTree(root, 5);
        System.out.println("\nIN ORDER TRAVERSAL");
        Inorder(root);
        System.out.println();
        IterativeInorder(root);
        System.out.println("\nPRE ORDER TRAVERSAL");
        Preorder(root);
        System.out.println();
        IterativePreorder(root);
        System.out.println("\nPOST ORDER TRAVERSAL");
        Postorder(root);
        System.out.println();
        IterativePostorder(root);
        System.out.println("\nPOST ORDER TRAVERSAL USING ONE STACK");
        IterativePostorderUsingOneStack(root);
        System.out.println("hhhhhhhhhiiiiiiiiii");
        
    }
    
}
