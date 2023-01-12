package Stack;

import java.util.Stack;

public class Problem2 {
    static int prec(char ch) {
        switch(ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String InfixToPostfix(String exp) {
        String result = new String("");
        Stack<Character> stk = new Stack<Character>();

        for(int i=0; i<exp.length(); i++) {
            char c = exp.charAt(i);
        
            if(Character.isLetterOrDigit(c))
                result += c;
            else if(c == '(')
                stk.push(c);
            else if(c == ')') {
                while(!stk.isEmpty() && stk.peek() != ('(')) {
                    result += stk.peek();
                    stk.pop();
                }
                stk.pop();
            }
            else {
                while(!stk.isEmpty() && prec(c) <= prec(stk.peek())) {
                    result += stk.peek();
                    stk.pop();
                }
                stk.push(c);
            }

        }
        while(!stk.isEmpty()) {
            if(stk.peek() == '(')
                return "Invalid Expression";
            result += stk.peek();
            stk.pop();
        }
        return result;
    }
    
    public static void main(String[] args) {
        String exp = "(A+B)+(C-D)";
        System.out.print(InfixToPostfix(exp));
        
    }
    
}
