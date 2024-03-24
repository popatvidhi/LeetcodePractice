package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String args[]){
        String[] tokens = {"4","13","5","/","+"};
        int res = evalRPN(tokens);
        System.out.println(res);
    }

    public static int evalRPN(String[] tokens) {
        List<String> operation = Arrays.asList(new String[]{"+","-","/","*"});
        Stack<String> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(operation.contains(tokens[i])){
                String a = st.pop();
                String b = st.pop();
                st.push(String.valueOf(eval(a,b,tokens[i])));
            }else{
                st.push(tokens[i]);
            }
        }
        return Integer.parseInt(st.pop());
    }
    public static int eval(String a, String b, String operation){
        if(operation.equals("+"))
            return Integer.parseInt(a) + Integer.parseInt(b);
        else if(operation.equals("-"))
            return Integer.parseInt(b) - Integer.parseInt(a);
        else if(operation.equals("/"))
            return Integer.parseInt(b) / Integer.parseInt(a);
        else
            return Integer.parseInt(a) * Integer.parseInt(b);
    }
}
