package Strings;


import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public static void main(String args[]){
        String s = "AABABBA";
        int k = 3;
        int res = characterReplacement(s, k);
        System.out.println("Solution s: "+res);
        int res1 = characterReplacementUsingFrequencyCount(s, k);
        System.out.println("Solution s: "+ res1);
    }
    public static int characterReplacement(String s, int k){
        /**
         *
         * ALGO
         *
         * 1. Keep l and r pointer to 0, keep increasing r pointer by 1
         * 2. If char at r pointer is not in HashMap then put it in HashMap with value 1, else get value of it then add 1 and put it in hashmaps
         * 3. Get the max of the char from the HashMap
         * 4. Check if the windowlen - max > k, if yes then shift l pointer by 1, before shifting decrement the value of l char from HashMap
         * 5. cr.
         */
        //HashMap to store character with their occurences in substring
        HashMap<Character, Integer> charOccurences = new HashMap<>();
        int res = 0;
        int l = 0;
        int count = 0;
        //slidding window concept
        for(int r = 0; r < s.length(); r++){
             char rChar = s.charAt(r);
             charOccurences.put(rChar, charOccurences.getOrDefault(rChar, 0) + 1);
             count = Math.max(count, charOccurences.get(rChar));

             while(((r - l + 1) - count) > k){
                 char lChar = s.charAt(l);
                 charOccurences.put(lChar, charOccurences.get(lChar)-1);
                 l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }


    public static int characterReplacementUsingFrequencyCount(String s, int k) {
        int l = 0, res = 0, maxFreq = 0;
        int[] freq = new int[26];
        char[] sChar = s.toCharArray();
        for(int r = 0; r < sChar.length; r++){
            freq[sChar[r] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[sChar[r] - 'A']);
            while((r - l + 1) - maxFreq > k){
                freq[sChar[l] - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
