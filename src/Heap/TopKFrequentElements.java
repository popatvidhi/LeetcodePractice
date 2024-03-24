package Heap;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String args[]){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        for(int r : res){
            System.out.print(r + " ");
        }
        int[] res1 = topKFrequent2(nums, k);
        for(int i : res1){
            System.out.print(i + " ");
        }
    }

    //time - O(k log n)
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            maxHeap.add(entry);
        }
        List<Integer> list = new ArrayList<>();
        while(list.size() < k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            list.add(entry.getKey());
        }
        return list.stream().mapToInt(Integer :: intValue).toArray();
    }
    //time - O(k log n)
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b));
        for(Integer i : freq.keySet()){
            maxHeap.add(i);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[] topElements = new int[maxHeap.size()];
        for(int i = maxHeap.size()-1; i >= 0; i--){
            topElements[i] = maxHeap.poll();
        }
        return topElements;
    }

}
