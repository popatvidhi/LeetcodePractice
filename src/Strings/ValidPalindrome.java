package Strings;

import java.util.HashMap;
import java.util.Stack;

public class ValidPalindrome {
    public static void main(String args[]){
        String s = "A man, a plan, a canal: Panama";
        boolean res = isPalindromeSol1(s);
        boolean res1 = isPalindromeSol2(s);
        System.out.println("Solution 1: "+res);
        System.out.println("Solution 2: "+res1);
    }
    public static boolean isPalindromeSol1(String s){
        String newS = "";
        String revStr = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isAlphaNumeric(c)){
                newS = newS + Character.toLowerCase(c);
                //System.out.println(newS);
            }
        }

        for(int i = 0; i<newS.length(); i++){
            char ch = newS.charAt(i);
            revStr = ch + revStr;
            //System.out.println(revStr);

        }
        return newS.equals(revStr);
    }

    public static boolean isAlphaNumeric(char c){
        if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
            return true;
        else
            return false;
    }
    public static boolean isPalindromeSol2(String s){
        int l = 0;
        int r = s.length()-1;
        char[] c = s.toCharArray();
        while(l<=r){
            while(l<r && !isAlphaNumeric(c[l]))
                l++;
            while(r>l && !isAlphaNumeric(c[r]))
                r--;
            if(Character.toLowerCase(c[l]) != Character.toLowerCase(c[r]))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
