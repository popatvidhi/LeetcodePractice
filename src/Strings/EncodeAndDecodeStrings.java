package Strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static void main(String args[]){
        String encodeRes = "";
        List<String> decodeRes = new ArrayList<>();
        List<String> strs = new ArrayList<>();
        strs.add("lint");
        strs.add("code");
        strs.add("love");
        strs.add("you");
        encodeRes = encode(strs);
        decodeRes = decode(encodeRes);
        System.out.println("Encoded: "+encodeRes);
        System.out.print("Decoded: ");
        for(String s : decodeRes){
            System.out.print(s + " ");
        }

    }
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        // write your code here
         String res = "";
         for(String s : strs){
             res += String.valueOf(s.length()) + "#" + s;
         }
         return res;
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        int i = 0;
        int len = 0;
        while(i < str.length()){
            int j = i;
            while(!(str.charAt(j) == '#')){
                j++;
            }
            len = Integer.valueOf(str.substring(i,j));
            res.add(str.substring(j+1, j+1+len));
            i = j + 1 + len;
        }
        return res;
    }
}
