package Strings;

public class StringToIntegerAtoi {

    public static void main(String args[]){
        int res = myAtoi("-42");
        System.out.println(res);
    }

    public static int myAtoi(String s) {
        long num = 0;
        char[] c = s.toCharArray();
        if(c.length == 0) return 0;
        int i =0, sign = 1;
        char current = c[i];

        //remove white spaces
        while(current == ' '){
            i++;
            if(i == c.length) return 0;
            current = c[i];
        }

        //check sign
        if(current == '-'){
            sign = -1;
            i++;
        }else if(current == '+'){
            sign = 1;
            i++;
        }

        for(; i < c.length; i++){
            current = c[i];
            if(current < '0' || current > '9') break;
            else{
                num *= 10;
                num += current - '0'; //converts to integer - ex - this takes ascii value of current and subtract from ascii value of 0 and return ascii value of res.
                if(sign * num <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
                else if(sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
        }

        num *= sign;
        return (int) num;
    }
}
