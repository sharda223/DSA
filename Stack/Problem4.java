package Stack;

import java.util.Stack;

public class Problem4 {
    public static int postfixEvaluation(String operators) {
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<operators.length(); i++) {
            char ch = operators.charAt(i);
            if(Character.isDigit(ch)) {
                s.push(ch - '0');
            } else {
                if(ch == '+'){
                    int op1 = s.pop();
                    int op2 = s.pop();
                    s.push(op1+op2);
                } else if(ch == '-'){
                    int op1 = s.pop();
                    int op2 = s.pop();
                    if(op2>op1){
                        s.push(op2-op1);
                    } else {
                        s.push(op1-op2);
                    }
                } else if(ch == '*') {
                    int op1 = s.pop();
                    int op2 = s.pop();
                    s.push(op1*op2);
                } else if(ch == '/') {
                    int op1 = s.pop();
                    int op2 = s.pop();
                    if(op1>op2 && op2!=0) {
                        s.push(op1/op2);
                    } else if(op2>op1 && op1!=0) {
                        s.push(op2/op1);
                    }
                } else if(ch == '^') {
                    int op1 = s.pop();
                    int op2 = s.pop();
                    s.push((int) Math.pow(op1, op2));
                } 
            }

        }
        return s.pop();
    }
    public static void main(String[] args) {
       String operators = "123*+5-";
       System.out.println(postfixEvaluation(operators)); 
        
    }
    
}
