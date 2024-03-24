package Array;

public class ContainerWithMostWater {
    public static void main(String args[]){
        int res = 0;
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        res = maxArea(nums);
        System.out.println(res);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r){
            int currArea = (Math.min(height[l], height[r])) * (r - l);
            max = Math.max(max, currArea);
            if(height[r] < height[l])
                r--;
            else
                l++;
        }
        return max;
    }

}
