package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args){
        int[] coins = new int[] {2};
        int amount = 3;
        int res = coinChange(coins, amount);
        System.out.println(res);
    }

    public static int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int a = 1; a < amount + 1; a++ ){
            for(int c : coins){
                if(a-c >= 0){
                    dp[a] = Math.min(dp[a], 1 + dp[a-c]);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
