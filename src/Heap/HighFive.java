package Heap;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi, calculate each student's top five average.
 *
 * Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average. Sort result by IDj in increasing order.
 *
 * A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.
 *
 *
 *
 * Example 1:
 *
 * Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
 * The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.
 * Example 2:
 *
 * Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
 * Output: [[1,100],[7,100]]
 */
public class HighFive {

    public static void main(String args[]){
        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] res= highFive(items);
        for(int r = 0; r < items.length; r++){
            System.out.print("[");
            for(int c = 0; c < items[0].length; c++){
                System.out.print(items[r][c]);
            }
            System.out.print("] ");
        }
    }

    public static int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> treeMap= new TreeMap<>();
        for(int[] item : items){
            int id = item[0];
            int score = item[1];
            if(treeMap.containsKey(id)){
                PriorityQueue<Integer> heap = treeMap.get(id);
                heap.offer(score);
                if(heap.size() > 5){
                    heap.poll();
                }
                treeMap.put(id, heap);
            }else{
                PriorityQueue<Integer> heap = new PriorityQueue<>();
                heap.offer(score);
                treeMap.put(id, heap);
            }
        }

        int[][] res = new int[treeMap.size()][2];
        int index = 0;
        for(int id : treeMap.keySet()){
            PriorityQueue<Integer> heap = treeMap.get(id);
            int sum = 0;
            while(!heap.isEmpty()){
                sum += heap.poll();
            }
            res[index][0] = id;
            res[index][1] = sum / 5;
            index++;
        }

        return res;
    }
}
