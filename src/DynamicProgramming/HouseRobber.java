package DynamicProgramming;

public class HouseRobber {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,1};
        int res = rob(nums);
        System.out.println(res);
    }

    public static int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        //[rob1, rob2, n, n+1, n+2, ...]
        for(int n : nums){
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
