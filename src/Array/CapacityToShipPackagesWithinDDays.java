package Array;

public class CapacityToShipPackagesWithinDDays {

    public static void main(String args[]){
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int res = shipWithinDays(weights,5);
        System.out.println(res);
    }

    public static int shipWithinDays(int[] weights, int days) {
        int l = getMax(weights); // Get the maximum weight in the array
        int r = getSum(weights); // Get the sum of all weights in the array
        int res = r;

        while (l <= r) {
            int cap = (l + r) / 2; // Calculate the mid-capacity

            if (canShip(weights, days, cap)) {
                res = Math.min(res, cap); // Update the result if the current capacity is feasible
                r = cap - 1; // Adjust the right boundary
            } else {
                l = cap + 1; // Adjust the left boundary
            }
        }

        return res;
    }
    private static boolean canShip(int[] weights, int days, int cap) {
        int ships = 1;
        int currCap = cap;

        for (int weight : weights) {
            if (currCap - weight < 0) {
                ships++;
                currCap = cap;
            }
            currCap -= weight;
        }

        return ships <= days;
    }

    private static int getMax(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int weight : weights) {
            max = Math.max(max, weight);
        }
        return max;
    }

    private static int getSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }
}
