package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthClosestPointToOrigin {

    public static void main(String args[]){
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] res = kClosest(points, 2);
        for(int r = 0; r < res.length; r++){
            System.out.print("[ ");
            for(int c = 0; c < res[0].length; c++){
                System.out.print(res[r][c] + " ");
            }
            System.out.print("]");
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        for(int[] p : points){
            minHeap.offer(new Pair(findDisatnce(p[0], p[1]), p[0], p[1]));
        }
        int[][] res = new int[k][2];
        int index = 0;
        while(index < k){
            res[index][0] = minHeap.peek().x;
            res[index][1] = minHeap.peek().y;
            minHeap.poll();
            index++;
        }
        return res;
    }

    public static int findDisatnce(int x, int y){
        return (x * x) + (y * y);
    }

    public static class Pair{
        int distance, x, y;
        Pair(int distance, int x, int y){
            this.distance = distance;
            this.x = x;
            this.y = y;
        }
    }
}

