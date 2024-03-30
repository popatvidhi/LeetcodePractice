package Array;

public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {

    public static void main(String args[]){
        int[] nums = {1, 3, 2, 3, 3};
        System.out.println(countSubarrays(nums, 2));
    }

    public static long countSubarrays(int[] nums, int k) {
        int maxNum=0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        long ans = 0;
        int count = 0;

        for (int l = 0, r = 0; r < nums.length; ++r) {
            if (nums[r] == maxNum)
                ++count;
            while (count == k)
                if (nums[l++] == maxNum)
                    --count;
            ans += l;
        }

        return ans;
    }
}
