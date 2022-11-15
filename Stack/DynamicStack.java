package Stack;

public class DynamicStack {
    int capacity = 1<<1;
    int stack[] = new int[capacity];
    int top = 0;

    public void push(int data) {
        if(size()==capacity)
            expand();
        stack[top] = data;
        top++;

    }

    public int pop() {
        int data = 0;

        if(isEmpty()) {
            System.out.println("stack is empty");
        }
        else {
            top--;
            data = stack[top];
            stack[top] = 0;
            shrink();
        }
        return data;
    }

    private void shrink() {
        int length = size();
        if(length<=(capacity>>1)>>1)
            capacity = capacity>>1;
        int newStack[] = new int[capacity];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
    }

    private int size() {
        return top;
    }

    private void expand() {
        int length = size();
        int newStack[] = new int[capacity<<1];
        System.arraycopy(stack, 0, newStack, 0, length);
        stack = newStack;
        capacity = capacity<<1;
    }

    public int peek() {
        
        return stack[top-1];
        
    }

    public boolean isEmpty() {
        return top<=0;
    }

    public void show() {
        for(int n : stack)
        {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicStack dStack = new DynamicStack();

        dStack.push(2);
        dStack.show();
        dStack.push(5);
        dStack.show();
        dStack.push(10);
        dStack.show();
        dStack.push(15);
        dStack.show();
        dStack.push(20);
        dStack.show();
        dStack.pop();
        dStack.show();
        dStack.pop();
        dStack.show();
        dStack.pop();
        dStack.show();
        dStack.pop();
        dStack.show();
        System.out.println(dStack.peek());
        //dStack.show();
    }
    
}
