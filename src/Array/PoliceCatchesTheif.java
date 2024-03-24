package Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an array of size n in which each element contains either a 'P' for policeman or a 'T' for thief and an integer value k. Maximize the number of thieves that can be caught by the police.
 * The constraints are :
 *
 * A police can catch at most one thief.
 * A police cannot catch a thief who is more than K units away from him.
 * Input 1:
 * P T T P T T P
 * 2
 *
 * Output 1:
 * 3
 *
 * Input 2:
 * T T P P T P T P
 * 2
 *
 * Output 2:
 * 4
 *
 * There are two ways to catch a thief.
 * CASE 1: The thief to be caugth lies to the left of the police.
 * CASE 2: The thief to be caugth lies to the right of the police.
 *
 * Mathematical expression for the above two cases:
 * Let index of police be i and index of the thief be j.
 * When j < i and i - j ≤ k we will choose the smallest possible j(farthest on the left).
 * When j > i and j - i ≤ k we will choose the smallest possible j(closest to the right).
 *
 * For both conditions we will choose the leftmost thief possible to catch.
 */
public class PoliceCatchesTheif {

    public static void main(String args[]){
        char[] arr = {'T', 'T', 'P', 'P', 'T', 'P', 'T', 'P'};
        int res = catchThieves(arr, 2);
        System.out.println(res);
    }

    public static int catchThieves(char arr[], int k) {

        Queue<Integer> tq = new LinkedList<>(); // queue to store index of thief
        Queue<Integer> pq = new LinkedList<>(); // queue to store index of police

        for (int i = 0; i < arr.length; i++) { // loop through array to find index of thief/police
            if (arr[i] == 'T') {
                tq.offer(i);
            } else {
                pq.offer(i);
            }
        }

        int counter = 0;
        while (!tq.isEmpty() && !pq.isEmpty()) {
            if (Math.abs(tq.peek() - pq.peek()) <= k) { // thief is within the reach of the policeman
                counter++;
                pq.poll();
                tq.poll();
            } else if (tq.peek() > pq.peek()) { // thief lies beyond the reach of the current policeman
                pq.poll();
            } else { // thief is not reachable from any of the police
                tq.poll();
            }
        }

        return counter;
    }
}
