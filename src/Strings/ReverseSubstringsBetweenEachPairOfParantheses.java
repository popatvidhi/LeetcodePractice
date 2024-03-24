package Strings;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParantheses {

    public static void main(String arg[]){
        String res = reverseParentheses("u(love)i");
        System.out.println(res);
    }
    public static String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                StringBuilder sb = new StringBuilder();
                // Pop characters from the stack until an opening parentheses is found
                while(!st.isEmpty() && st.peek() != '('){
                    sb.append(st.pop());
                }
                // Pop the opening parentheses
                st.pop();
                // Add the reversed string within parentheses back to the stack
                while (!sb.toString().isEmpty()) {
                    st.add(sb.charAt(0));
                    sb.deleteCharAt(0);
                }
            }else{
                st.push(c);
            }
        }

        StringBuilder res = new StringBuilder();
        // Pop all the characters from the stack and add them to the StringBuilder
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}
