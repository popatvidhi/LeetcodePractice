package Math;

import java.util.HashMap;

public class FractionToRecurringDecimal {

    public static void main(String args[]){
        String res = fractionToDecimal(4, 33);
        System.out.println(res);
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)){
            res.append("-");
        }
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        long remainder = num % den;
        res.append(num / den);

        if(remainder == 0){
            return res.toString();
        }

        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while(remainder != 0){
            if(map.containsKey(remainder)){
                res.insert(map.get(remainder), "(");
                res.append(")");
                break;
            }
            map.put(remainder, res.length());
            remainder *= 10;
            res.append(remainder / den);
            remainder %= den;
        }
        return res.toString();
    }
}
