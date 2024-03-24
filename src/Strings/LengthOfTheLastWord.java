package Strings;

import java.util.List;

public class LengthOfTheLastWord {

    public static void main(String args[]){
        String s = "   fly me   to   the moon  ";
        int res = lengthOfLastWord(s);
        System.out.println(res);
    }

    public static int lengthOfLastWord(String s) {
        int res = 0;
        s = s.trim();
        System.out.println(s);
        int i = s.length()-1;
        while(i >= 0 && s.charAt(i)!=' '){
            res++;
            i--;
        }
        return res;
    }
}
