package Stack;

import java.util.Stack;

public class Problem5 {
    public static int precedence(char operator) {
        if(operator == '+' || operator == '-') {
            return 1;
        } else if(operator == '*' || operator == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public static int operation(int v1, int v2, char op) {
        if(op == '+') {
            return v1+v2;
        } else if(op == '-') {
            return v2-v1;
        } else if(op == '*') {
            return v1*v2;
        } else if(op == '/') {
            if(v1==0) {
                System.out.println("undefined");
                return 0;
            }
            return v2/v1;
        } else {
            return 1;
        }
    }

    public static int InfixEvaluation(String exp) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i=0; i<exp.length(); i++) {
            char ch1 = exp.charAt(i);
             if(ch1 == '(') {
                operators.push(ch1);
             } 
             else if(Character.isDigit(ch1)) {
                operands.push(ch1 - '0');
             }
             else if(ch1 == ')') {
                while(operators.peek() != '(') {
                    int a = operands.pop();
                    int b = operands.pop();

                    char ch2 = operators.pop();

                    int result = operation(a, b, ch2);
                    operands.push(result);
                }
                operators.pop();
             }
             else if(ch1 == '+' || ch1 == '-' || ch1 == '*' || ch1 == '/') {
                while(operators.size() > 0 && precedence(operators.peek()) >= precedence(ch1)) {
                    int a = operands.pop();
                    int b = operands.pop();

                    char ch2 = operators.pop();

                    int result = operation(a, b, ch2);
                    operands.push(result);
                }
                operators.push(ch1);
             }
        }
        while(operators.size() != 0) {
            int a = operands.pop();
                    int b = operands.pop();

                    char ch2 = operators.pop();

                    int result = operation(a, b, ch2);
                    operands.push(result);
        }
        //System.out.println("result of infix evaluation is: " + operands.peek());
        return operands.peek();
    }
    public static void main(String[] args) {
        String exp = "2*(5*(3+6))/5-2";
        System.out.println(InfixEvaluation(exp));
    }
}
