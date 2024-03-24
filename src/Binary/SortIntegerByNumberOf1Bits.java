package Binary;

import java.util.Arrays;
import java.util.Comparator;

public class SortIntegerByNumberOf1Bits {

    public static void main(String args[]){
        int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] res = sortByBitsSol1(arr);
        for(int r : res){
            System.out.print(r + " ");
        }
        System.out.println();
        int[] res1 = sortByBitsSol2(arr);
        for(int r : res1){
            System.out.print(r + " ");
        }
    }

    public static int[] sortByBitsSol1(int[] arr) {
        Arrays.sort(arr);
        int[][] dp = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++){
            dp[i][0] = arr[i];
            dp[i][1] = Integer.bitCount(arr[i]);
        }
        Arrays.sort(dp, Comparator.comparingDouble(a -> a[1]));
        for(int i = 0; i < arr.length; i++){
            arr[i] = dp[i][0];
        }
        return arr;
    }
    public static int[] sortByBitsSol2(int[] arr) {
        int[] c=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            c[i]=countBit(arr[i])*10001+arr[i];
        }
        Arrays.sort(c);
        for(int i=0;i<arr.length;i++)
        {
            c[i]%=10001;
        }
        return c;
    }
    private static int countBit(int n)
    {
        int res=0;
        while(n>0)
        {
            res+=(n&1);
            n>>=1;
        }
        return res;
    }
}
