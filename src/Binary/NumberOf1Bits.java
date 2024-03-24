package Binary;

public class NumberOf1Bits {

    public  static void main(String args[]){
        int res = hammingWeightSol1(00000000000000000000000000001011);
        int res2 = hammingWeightSol2(00000000000000000000000000001011);
        System.out.println(res);
        System.out.println(res2);
    }

    // you need to treat n as an unsigned value
    public static int hammingWeightSol1(int n) {
        int res = 0;
        while(n > 0){
            res += n % 2;
            n = n >> 1;
        }
        return res;
    }

    public static int hammingWeightSol2(int n) {
        int res = 0;
        while(n > 0){
            n = n & (n - 1);
            res += 1;
        }
        return res;
    }
}
