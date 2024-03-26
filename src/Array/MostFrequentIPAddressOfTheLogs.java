package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Given a list of logs with IP addresses in the following format.
 * lines = ["10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"]
 *
 * Return the most frequent IP address from the logs. The retuned IP address value must be in a string format.
 * If multiple IP addresses have the count equal to max count, then return the address as a comma-separated string with IP addresses in sorted order.
 */
public class MostFrequentIPAddressOfTheLogs {

    public static void main(String[] args) {
        System.out.println("Most Frequent IP!");

        List<String> res = getMostFrequentIpSol1(new String[]{"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24",
                "10.0.0.2 - GET 2020-08-20", "10.0.0.2 - GET 2020-08-24","10.0.0.3 - GET 2020-08-24",
                "10.0.0.3 - GET 2020-08-24","10.0.0.4 - GET 2020-08-24",});
        for(String r : res){
            System.out.println(r + " ");
        }

        List<String> res1 = getMostFrequentIpSol2(new String[]{"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24",
                "10.0.0.2 - GET 2020-08-20", "10.0.0.2 - GET 2020-08-24","10.0.0.3 - GET 2020-08-24",
                "10.0.0.3 - GET 2020-08-24","10.0.0.4 - GET 2020-08-24",});
        for(String r : res1){
            System.out.println(r + " ");
        }
    }

    public static List<String> getMostFrequentIpSol1(String[] logs){
        HashMap<String, Integer> map = new HashMap<>();

        // Step 1: Constructing the Frequency Map and finding the maximum frequency
        int maxFreq = 0;
        for (String log : logs) {
            String[] arr = log.split(" ");
            String ip = arr[0];
            int freq = map.getOrDefault(ip, 0) + 1;
            map.put(ip, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        // Step 2: Collect IP addresses with maximum frequency
        List<String> mostFrequent = new ArrayList<>();
        for (String ip : map.keySet()) {
            if (map.get(ip) == maxFreq) {
                mostFrequent.add(ip);
            }
        }

        // Step 3: Sort the result list (if necessary)
        Collections.sort(mostFrequent);

        return mostFrequent;
    }


    public static List<String> getMostFrequentIpSol2(String[] logs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> mostFrequent = new ArrayList<>();
        int maxFreq = 0;

        // Step 1: Constructing the Frequency Map and finding the maximum frequency
        for (String log : logs) {
            String[] arr = log.split(" ");
            String ip = arr[0];
            int freq = map.getOrDefault(ip, 0) + 1;
            map.put(ip, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        // Step 2: Collect and sort IP addresses with maximum frequency
        for (String ip : map.keySet()) {
            if (map.get(ip) == maxFreq) {
                int index = 0;
                while (index < mostFrequent.size() && ip.compareTo(mostFrequent.get(index)) > 0) {
                    index++;
                }
                mostFrequent.add(index, ip); // Add IP address at the correct position to maintain sorted order
            }
        }

        return mostFrequent;
    }

}
