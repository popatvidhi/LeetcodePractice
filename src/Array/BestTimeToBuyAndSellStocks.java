package Array;

public class BestTimeToBuyAndSellStocks {

    public static void main(String args[]){
        int[] prices = {7,1,5,3,6,4};
        int res = maxProfit(prices);
        System.out.println(res);
    }

    public static int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int max = 0;
        while(sell < prices.length){
            int profit = 0;
            if(prices[buy] < prices[sell]){
                profit = prices[sell] - prices[buy];
                max = Math.max(profit, max);
            }else{
                buy = sell;
            }
            sell++;
        }
        return max;
    }
}
