package Math;

public class SqrtOfX {

    public static void main(String args[]){
        int res = mySqrt(8);
        System.out.println(res);
    }

    public static int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int l = 1, r = x;
        int res = 0;
        while(l <= r){
            int m = l + (r - l)/2;
            if(m <= x/m){
                l = m + 1;
                res = m;
            }else{
                r = m - 1;
            }
        }
        return res;
    }
}
