package Array;

public class TwoSumII {
    public static void main(String args[]){
        int[] res = new int[2];
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        res = twoSum(nums, target);
        for(int i=0; i<res.length; i++){
            System.out.println(res[i]);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int[] res = new int[2];
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }else if(sum > target){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }
}
