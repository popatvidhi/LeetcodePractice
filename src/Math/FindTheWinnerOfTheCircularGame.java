package Math;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinnerOfTheCircularGame {

    public static void main(String args[]){
        System.out.println(findTheWinnerBruteForce(6, 5));
        System.out.println(findTheWinnerOptimized(6, 5));
    }
    //Time - O(n^2)
    public static int findTheWinnerBruteForce(int n, int k) {
        int res = 0;
        for(int i = 1; i <= n; i++){
            res = (res + k) % i;
        }
        return res + 1;
    }

    //Time - O(n + k)
    public static int findTheWinnerOptimized(int n, int k) {
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            qu.offer(i);
        }
        while(qu.size() != 1){
            int j = 1;
            while(j < k){
                int temp = qu.poll();
                qu.offer(temp);
                j++;
            }
            qu.poll();
        }
        return qu.peek();
    }

}
