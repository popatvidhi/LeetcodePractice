package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReverseWordsInAString {

    public static void main(String[] args){
        String s = "the sky is blue ";
        String res = reverseWords(s);
        System.out.println("-"+res+"-");
    }

    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        List<String> st = new ArrayList<>();
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            while(s.charAt(l) == ' ' && l<s.length()){
                l++;
            }
            while(s.charAt(l)!=' ' && s.charAt(r) != ' ' && r<s.length()){
                r++;
            }
            st.add (0, s.substring(l, r+1).toString());
            l = r+1;
            r=r+1;
        }
        for(int i = 0; i < st.size(); i++){
            res.append(st.get(i) + " ");
        }
        return res.toString();
    }
}
