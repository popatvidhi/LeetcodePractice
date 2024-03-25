package Array;

/**
 * Given an integer array of size n. Elements of the array is >= 0. Starting from arr[startInd], follow each element to the index it points to.
 * Find a cycle and return its length. No cycle is found -> -1.
 *
 *
 * Examples:
 *
 * lengthOfCycle([1, 0], 0); // 2
 * lengthOfCycle([1, 2, 0], 0); // 3
 * lengthOfCycle([1, 2, 3, 1], 0); // 3
 */

public class FindLengthOftheCycleInAnArray {

    public static void main(String args[]){
        int arr1[] = {1,0};
        System.out.println(lengthOfCycle(arr1, 0));
        int arr2[] = {1, 2, 0};
        System.out.println(lengthOfCycle(arr2, 0));
        int arr3[] = {1, 2, 3, 1};
        System.out.println(lengthOfCycle(arr3, 0));
    }

    public static int lengthOfCycle(int[] arr, int startIndex) {
        if (arr == null || arr.length == 0)
            return -1;
        int count = 1;
        int fast = arr[arr[startIndex]];
        int slow = arr[startIndex];
        while (fast != slow) {
            if (fast >= arr.length) {
                return -1;
            }
            count++;
            fast = arr[arr[fast]];
            slow = arr[slow];
        }
        return count;
    }
}
