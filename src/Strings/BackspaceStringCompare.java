package Strings;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String args[]){
        boolean res = backspaceCompare("ab##", "c#d#");
        System.out.println(res);
        boolean res1 = backspaceCompareCounting("#c", "#c");
        System.out.println(res1);
    }
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(!sStack.isEmpty()){
                    sStack.pop();
                }
            }else{
                sStack.push(s.charAt(i));
            }
        }
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#'){
                if(!tStack.isEmpty()){
                    tStack.pop();
                }
            }else{
                tStack.push(t.charAt(i));
            }
        }
        return sStack.equals(tStack);
    }

    public static boolean backspaceCompareCounting(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int backspaceCountS = 0, backspaceCountT = 0;

        while (i >= 0 || j >= 0) {
            // Skip over backspace characters
            while (i >= 0 && (s.charAt(i) == '#' || backspaceCountS > 0)) {
                if (s.charAt(i) == '#') {
                    backspaceCountS++;
                } else {
                    backspaceCountS--;
                }
                i--;
            }

            while (j >= 0 && (t.charAt(j) == '#' || backspaceCountT > 0)) {
                if (t.charAt(j) == '#') {
                    backspaceCountT++;
                } else {
                    backspaceCountT--;
                }
                j--;
            }

            // Compare characters at the current positions
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                // Check if both strings are fully processed
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }

            // Move to the previous characters in both strings
            i--;
            j--;
        }

        return true;

    }
}
