package Math;

public class UglyNumber {

    public static void main(String[] args){
        int n = 6;
        boolean res = isUgly(n);
        System.out.println(res);
    }

    public static boolean isUgly(int n) {
        int[] prime = new int[]{2,3,5};
        if(n<=0)
            return false;
        for(int p : prime){
            while(n%p == 0){
                n = n / p;
            }
        }
        return n == 1;
    }

}
