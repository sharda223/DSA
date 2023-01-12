package Stack;

import java.util.Stack;

public class Problem1 {

    static boolean isValidParanthesis(String str) {
        Stack<Character> st = new Stack<Character>();
        if(str == null || str.length() == 0)
            return true;

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == ')') {
                if(!st.isEmpty() && st.peek() == '(')
                    st.pop();
            else
                return false;
            } else if(str.charAt(i) == ']') {
                if(!st.isEmpty() && st.peek() == '[')
                    st.pop();
             else
                return false;
            } else if(str.charAt(i) == '}') {
                if(!st.isEmpty() && st.peek() == '{')
                    st.pop();
             else
                return false;
            } else {
                st.push(str.charAt(i));
            }
        }
        if(st.isEmpty())
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        System.out.println(isValidParanthesis("{()}"));
    }
}
