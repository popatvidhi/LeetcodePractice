package Heap;

import java.util.*;

public class TopKFrequentWords {

    public static void main(String args[]){
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        List<String> res = topKFrequent(words, 4);
        for(String s : res){
            System.out.print(s + " ");
        }
    }
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue(new Comparator<String>(){
            @Override
            public int compare(String word1, String word2){
                int frequency1 = map.get(word1);
                int frequency2 = map.get(word2);
                if(frequency1 == frequency2) return word2.compareTo(word1);
                return frequency1 - frequency2;
            }
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(entry.getKey());
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
