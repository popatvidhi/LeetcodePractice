package Strings;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String args[]){
        boolean res = backspaceCompare("ab#c", "ad#c");
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
        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(i > 0)
                    count[s.charAt(i - 1) - 'a']--;
            }else{
                count[s.charAt(i) - 'a']++;
            }
        }
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#'){
                if(i > 0)
                    count[t.charAt(i - 1) - 'a']--;
            }else{
                count[t.charAt(i) - 'a']--;
            }
        }
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
