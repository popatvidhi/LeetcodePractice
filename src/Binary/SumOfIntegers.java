package Binary;

public class SumOfIntegers {

    public  static void main(String args[]){
        int res = getSum(2, 3);
        System.out.println(res);
    }

    public static int getSum(int a, int b) {
        while(b != 0){
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }
}
