package Strings;

import java.util.HashMap;

public class IsomorphicsStrings {

    public static void main(String args[]){
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s,t));

    }
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            char st = t.charAt(i);
            if(map.containsKey(sc)){
                if(map.get(sc) != st){
                    return false;
                }
            }else{
                if(map.containsValue(st)){
                    return false;
                }
                map.put(sc, st);
            }
        }
        return true;
    }
}
