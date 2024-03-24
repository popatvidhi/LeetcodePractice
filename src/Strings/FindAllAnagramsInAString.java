package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    public static void main(String args[]){
        List<Integer> res = findAnagrams("cbaebabacd", "abc");
        for(Integer r : res){
            System.out.print(r + " ");
        }
        System.out.println();
        List<Integer> res1 = findAnagrams1("cbaebabacd", "abc");
        for(Integer r : res1){
            System.out.print(r + " ");
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()){
            return res;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();

        for(int i = 0; i < p.length(); i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(sMap.equals(pMap)){
            res.add(0);
        }

        int l = 0;
        for(int r = p.length(); r < s.length(); r++){
            sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
            if(sMap.get(s.charAt(l)) == 0){
                sMap.remove(s.charAt(l));
            }
            l++;
            if(sMap.equals(pMap)){
                res.add(l);
            }
        }
        return res;
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(p.length() > s.length()) return ans;
        int[] cnt = new int[26];
        for(int i = 0 ; i < p.length() ; i++){
            cnt[s.charAt(i)-'a']++;
            cnt[p.charAt(i)-'a']--;
        }

        boolean flag = true;
        for(int i = 0 ; i < 26 ; i++){
            if(cnt[i] != 0){
                flag = false;
                break;
            }
        }
        if(flag == true)
            ans.add(0);
        for(int i = p.length() ; i < s.length() ; i++){
            cnt[s.charAt(i)-'a']++;
            cnt[s.charAt(i-p.length())-'a']--;
            flag = true;
            for(int j = 0 ; j < 26 ; j++){
                if(cnt[j] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag == true)
                ans.add(i-p.length()+1);
        }
        return ans;
    }
}
