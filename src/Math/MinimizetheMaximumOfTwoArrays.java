package Math;

public class MinimizetheMaximumOfTwoArrays {

    public static void main(String args[]){
        int res = minimizeSet(2,4,8,2);
        System.out.println(res);
    }

    public static long lcm;
    public static long findLCM(long a, long b){
        return (a * b) / findGCD(a, b);
    }
    public static  long findGCD(long a, long b){
        return (b == 0) ? a : findGCD(b, a % b);
    }
    public static boolean isValidSet(long total, int d1, int d2, int c1, int c2){
        long common = total / lcm;
        long excess1 = Math.max(0, (total / d1 - common) - c2);
        long excess2 = Math.max(0, (total / d2 - common) - c1);
        return (total - common - excess1 - excess2) >= c1 + c2;
    }
    public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long low = uniqueCnt1 + uniqueCnt2, high = Integer.MAX_VALUE;
        lcm = findLCM(divisor1, divisor2);
        while(low < high){
            long mid = (low + high) >> 1;
            boolean valid = isValidSet(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2);
            if(valid){
                high = mid;
            }else{
                low = mid + 1;
            }

        }
        return (int) low;
    }
}
