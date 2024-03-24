package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static void main(String args[]){
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = groupAnagrams(strs);
        for(List<String> s : res) {
            System.out.println(s);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String s : strs) {
            // Count the frequency of each character in the string
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Create a character count string representation with a delimiter
            String key = "";
            for (int i = 0; i < 26; i++) {
                key += "#" + count[i];
            }

            // Add the string to the corresponding anagram group
            if (!anagramGroups.containsKey(key)) {
                anagramGroups.put(key, new ArrayList<>());
            }
            anagramGroups.get(key).add(s);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}
