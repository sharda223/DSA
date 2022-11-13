package Stack;

import java.util.Scanner;

public class ImplementStackUsingArray {

    int top = -1;
    int length = 0;
    int arr[];
    int capacity;

    //get size of array
    public int size() {
        return length;
    }

    //Insert elements in stack
    public void push(int val) throws Exception {
        if(size() == capacity) {
            throw new Exception("cannot push operation in stack as stack is full");
        }
        arr[++top] = val;
        length++;

    }

    //delete elements in stack
    public int pop() throws Exception {
        int data;
        if(isEmpty())
            throw new Exception("cannot pop elements in stack as stack is empty");
        data = arr[top];
        arr[top--] = Integer.MIN_VALUE;
        length--;
        return data;
        
    }

    //check stack is empty or not
    public boolean isEmpty() {
        return (length == 0);

    }

    //Inspects top elements in stack
    public int top() throws Exception {
        if(isEmpty()) 
            throw new  Exception("Stack is empty");
        return arr[top]; 
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("nothing to display as stack is empty");
            return;
        }
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        ImplementStackUsingArray obj = new ImplementStackUsingArray();
        obj.arr = new int[n];
        obj.capacity = n;
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.display();
        obj.pop();
        obj.display();
        System.out.println(obj.top());
        obj.display();

        
    }
    
}
