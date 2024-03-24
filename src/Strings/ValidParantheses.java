package Strings;

import java.util.HashMap;
import java.util.Stack;

public class ValidParantheses {
    public static void main(String args[]){
        String s = "(){}[]";
        String t = "(}";
        boolean res = parantheses(s);
        boolean res1 = parantheses(t);
        System.out.println("Solution s: "+res);
        System.out.println("Solution t: "+res1);
    }
    public static boolean parantheses(String s){
        HashMap<Character, Character> valid = new HashMap<>();
        valid.put(')','(');
        valid.put(']','[');
        valid.put('}','{');
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(valid.containsKey(c)){
                if(st.empty() || st.pop()!=valid.get(c))
                    return false;
            }else{
                st.push(c);
            }
        }
        return st.empty();
    }
}
