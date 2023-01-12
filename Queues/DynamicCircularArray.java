package Queues;

import java.security.DrbgParameters.Capability;

public class DynamicCircularArray {
    private int[] A;
    private int size, front, rear;
    private static int CAPACITY = 16;

    public DynamicCircularArray() {
        A = new int[CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }
    public DynamicCircularArray(int cap) {
        A = new int[cap];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }
    
    //enqueue
    public void enQueue(int data) {
        if(size == CAPACITY){
            expand();
        }
        size++;
        A[rear] = data;
        rear = (rear+1)%CAPACITY;
    }

    //dequeue
    public int deQueue() {
        if(isEmpty()) {
            System.out.println("Queue is empty nothing to remove: Underflow");
        }
        int result = A[front];
        if(front == rear) {
            return -1;
        } else {
            front = (front+1)%size;
            size--;
            shrink();
        }
        return result;
    }

    public boolean isEmpty() {
        return(size == 0);
    }

    public boolean isFull() {
        return(size == CAPACITY);
    }

    public int getSize() {
        return size;
    }

    public void expand() {
        int length = getSize();
        int[] newQueue = new int[CAPACITY<<1];
        System.arraycopy(A, 0, newQueue, 0, length);
        A = newQueue;
        front = 0;
        rear = -1;
        CAPACITY *= 2;

    }

    public void shrink(){
        
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is empty nothing to print");
        }
        for(int i=front; i<rear; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SimpleCircularArray obj = new SimpleCircularArray();
        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.enQueue(5);
        obj.display();
        obj.deQueue();
        obj.display();
        System.out.println(String.format("Queue are in %d elements", obj.getSize()));
        
    }

}