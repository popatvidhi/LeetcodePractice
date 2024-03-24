package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a 2-D String array of student-marks find the student with the highest average and output his average score. If the average is in decimals, floor it down to the nearest integer.
 *
 * Example 1:
 *
 * Input:  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
 * Output: 99
 * Explanation: Since Jessica's average is greater than Bob's, Mike's and Jason's average.
 */
public class StudentWithHighestAverage {

    public static void main(String args[]){
        String[][] scores = {{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}};
        int res = highestAverage(scores);
        System.out.println(res);
    }
    public static int highestAverage(String[][] scores){
        if(scores.length == 0 || scores == null){
            return -1;
        }
        int highest = 0;
        Map<String, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < scores.length; i++){
            List<Integer> scoreList = map.get(scores[i][0]);
            if(scoreList == null){
                List<Integer> currentScore = new ArrayList<>();
                currentScore.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], currentScore);
            }else{
                scoreList.add(Integer.valueOf(scores[i][1]));
                map.put(scores[i][0], scoreList);
            }
        }

        for(Map.Entry<String, List<Integer>> entry : map.entrySet()){
            int curreAverageScore = averageCal(entry.getValue());
            highest = Math.max(highest, curreAverageScore);
        }
        return highest;

    }
    public static int averageCal(List<Integer> scores){
        int len = scores.size();
        int sum = 0;
        for(int score : scores){
            sum += score;
        }
        float average = sum / len;
        return (int) average;
    }
}
