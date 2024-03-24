package Array;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public static void main(String args[]){
        int[] arr = new int[]{3,0,2,1,2};
        int start = 2;
        boolean res = canReach(arr, start);
        System.out.println(res);
    }
    public static boolean canReach(int[] arr, int start) {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);
        while(!qu.isEmpty()){
            int size = qu.size();
            while(size-- > 0){
                int i = qu.poll();
                //either move left point - arr[point]
                if(i - arr[i] >= 0){
                    if(arr[i - arr[i]] == 0){
                        return true;
                    }else if(arr[i - arr[i]] > 0){
                        qu.add(i - arr[i]);
                    }
                }
                //either move right point - arr[point]
                if(i + arr[i] < arr.length){
                    if(arr[i + arr[i]] == 0){
                        return true;
                    }else if(arr[i + arr[i]] > 0){
                        qu.add(i + arr[i]);
                    }
                }

                arr[i] = -1;
            }
        }
        return false;
    }
}
