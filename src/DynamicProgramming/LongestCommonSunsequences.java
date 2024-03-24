package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSunsequences {

    public static void main(String[] args){
        String text1 = "abcde";
        String text2 = "ace";
        int res = longestCommonSubsequence(text1, text2);
        System.out.println(res);
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];

       for(int r = 0; r < dp.length; r++){
           for(int c = 0; c < dp[0].length; c++){
               dp[r][c] = 0;
               System.out.print(dp[r][c] + " ");
           }
           System.out.println();
       }
       for(int r = text1.length() - 1; r >= 0; r--){
           for(int c = text2.length() - 1; c >= 0; c--){
                if(text1.charAt(r) == text2.charAt(c)){
                    dp[r][c] = 1 + dp[r+1][c+1];
                }else{
                    dp[r][c] = Math.max(dp[r][c+1], dp[r+1][c]);
                }
           }
       }
        return dp[0][0];
    }
}
