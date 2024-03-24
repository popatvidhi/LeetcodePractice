package Array;

public class TrappingRainWater {

    public static void main(String args[]){
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap1(height));
        System.out.println(trap2(height));
    }

    //Time - O(n)    Space - O(1)
    public static int trap1(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int total = 0;

        maxLeft[0] = height[0];
        maxRight[n - 1] = height[n - 1];

        // Calculate maxLeft for each index
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        // Calculate maxRight for each index
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(maxLeft[i], maxRight[i]);
            total += Math.max(minHeight - height[i], 0);
        }

        return total;
    }

    //Time - O(n)    Space - O(n)
    public static int trap2(int[] height) {
        if(height == null || height.length == 0){
            return  0;
        }
        int l = 0, r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        int total = 0;
        while(l < r){
            if(maxL < maxR){
                l++;
                maxL = Math.max(maxL, height[l]);
                total += maxL - height[l];
            }else{
                r--;
                maxR = Math.max(maxR, height[r]);
                total += maxR - height[r];
            }
        }
        return total;
    }
}
