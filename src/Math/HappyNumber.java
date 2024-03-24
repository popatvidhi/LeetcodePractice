package Math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args){
        int n = 19;
        boolean res = isHappy(n);
        System.out.println(res);
    }

    public static Set<Integer> visited = new HashSet<>();
    public static boolean isHappy(int n) {
        while(!visited.contains(n)){
            if(n==1)
                return true;
            visited.add(n);
            n = sumOfSquares(n);
        }
        return false;
    }
    public static int sumOfSquares(int n){
        int ans = 0;
        while(n > 0){
            int rem = n % 10;
            ans += rem * rem;
            n /= 10;
        }
        return ans;
    }
}
