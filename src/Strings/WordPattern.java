package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordPattern {

    public static void main(String args[]){
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[i];
            if(map.containsKey(c)){
                if(!map.get(c).equals(word)){
                    return false;
                }
            }else{
                if(map.containsValue(word)){
                    return false;
                }
                map.put(c, word);
            }
        }
        return true;

    }
}
