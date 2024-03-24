package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void main(String[] args){
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean res = wordBreak(s, wordDict);
        System.out.println(res);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        Arrays.fill(dp, false);
        dp[n] = true;
        for(int i = n - 1; i >= 0; i--){
            for(String w : wordDict){
                int len = w.length();
                if((i + len <= s.length()) && (s.substring(i, i+len).equals(w))){
                    dp[i] = dp[i+len];
                }
                if(dp[i])
                    break;
            }
        }
        return dp[0];
    }
}
