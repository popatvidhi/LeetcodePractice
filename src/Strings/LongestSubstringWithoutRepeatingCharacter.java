package Strings;


import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String args[]){
        String s = "ababcbb";
        int res = lengthOfLongestSubstring(s);
        System.out.println("Solution s: "+res);
    }
    public static int lengthOfLongestSubstring(String s){
        //Sliding window
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int res = 0;
        char[] c = s.toCharArray();
        for(int r = 0; r < s.length(); r++){
            while(set.contains(c[r])){
                set.remove(c[l]);
                l++;
            }
            set.add(c[r]);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
