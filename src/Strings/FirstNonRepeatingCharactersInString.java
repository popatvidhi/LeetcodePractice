package Strings;

import java.util.HashMap;

public class FirstNonRepeatingCharactersInString {

    public static void main(String args[]){
        int res = firstUniqChar("leetcode");
        System.out.println(res);
        int res1 = firstUniqCharSol2("loveleetcode");
        System.out.println(res1);
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i = 0; i < s.length(); i++){
            if(count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static int firstUniqCharSol2(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(count[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

}
