package Array;

public class PlusOne {

    public static void main(String args[]){
        int[] digits = new int[]{1,3,9};
        int[] res = plusOne(digits);
        for(int i = 0; i < res.length; i ++){
            System.out.print( res[i] + ", ");
        }
    }

    public static int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
