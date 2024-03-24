package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {

    public static void main(String[] args){
        int[] candies = new int[]{2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> res = kidsWithCandies(candies, extraCandies);
        for(boolean r : res){
            System.out.println(res + " ");
        }
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0, n = candies.length;

        for(int i=0;i<n;i++)
            max = Math.max(max, candies[i]);

        List<Boolean> ans = new ArrayList<Boolean>(n);

        for(int i=0;i<n;i++)
            ans.add(max<=candies[i]+extraCandies);

        return ans;
    }
}
