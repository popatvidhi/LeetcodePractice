package Strings;

import java.util.Stack;

public class SimplifyPath {

    public static void main(String args[]){
        String path = "/../abc/.//def/";
        String res = simplifyPath(path);
        System.out.println(res);
    }
    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for(char c : (path + "/").toCharArray()){
            if(c == '/'){
                if(curr.toString().equals("..")){
                    if (!st.isEmpty()) {
                        st.pop();
                    }
                }else if (!curr.toString().equals("") && !curr.toString().equals(".")) {
                    st.push(curr.toString());
                }
                curr = new StringBuilder();
            }else{
                curr.append(c);
            }
        }

        StringBuilder result = new StringBuilder("/");
        result.append(String.join("/", st));
        return result.toString();
    }
}
