package Strings;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String args[]){
        String s = "car";
        String t = "rac";
        boolean res = anagramStringSolution(s, t);
        boolean res1 = anagramHashMapSolution(s, t);
        boolean res2 = anagramCharacterArraySolution(s, t);
        System.out.println("String Solution: "+res);
        System.out.println("HashMap Solution: "+res1);
        System.out.println("Character Array Solution: "+res2);
    }
    public static boolean anagramStringSolution(String s, String t){
        //Time complexity is O(nlogn)
        //Space complexity is O(s+t) i.e O(1)
        if(s.length() != t.length())
            return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);

        return Arrays.equals(s1, t1);
    }

    public static boolean anagramHashMapSolution(String s, String t){
        //Time complexity is O(n)
        //Space complexity is O(s+t) i.e O(n)

        if(s.length() != t.length())
            return false;
        boolean res;

        HashMap<Character, Integer> hashS = new HashMap<>();
        HashMap<Character, Integer> hashT = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            hashS.put(ch1, hashS.getOrDefault(ch1, 0)+1);
            hashT.put(ch2, hashT.getOrDefault(ch2, 0)+1);
        }
        if(hashS.equals(hashT))
            return true;

        return false;
    }

    public static boolean anagramCharacterArraySolution(String s, String t){
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            chars[c-'a']--;
        }
        for (int i=0;i<26;i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
