package Array;

public class JumpGameII {

    public static void main(String arg[]){
        int[] nums = new int[]{2,3,1,1,4};
        int res = jump(nums);
        System.out.println(res);
    }

    public static int jump(int[] nums) {
        //bfs
        int res = 0;
        int l = 0, r = 0;

        while(r < nums.length - 1){
            int farthest = 0;
            for(int i = l; i < r + 1; i++){
                farthest = Math.max(farthest, i+nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
    }
}
