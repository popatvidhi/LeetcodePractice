package Strings;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        String res = longestCommonPrefixSol1(strs);
        String res1 = longestCommonPrefixSol2(strs);
        System.out.println(res);
        System.out.println(res1);
    }

    public static String longestCommonPrefixSol1(String[] strs) {
        Arrays.sort(strs);
//        for(String str : strs)
//            System.out.println(str);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int i = 0;
        while(i < s1.length()){
            if(s1.charAt(i) == s2.charAt(i)){
                i++;
            }else{
                break;
            }
        }
        return s1.substring(0, i);
    }

    public static String longestCommonPrefixSol2(String[] strs) {
        if(strs.length == 0)
            return "";
        String pre = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0, pre.length() - 1);
                if(pre.isEmpty())
                    return "";
            }
        }
        return pre;
    }
}
