package Strings;

import java.util.ArrayList;
import java.util.List;

public class IntegerToRoman {

    public static void main(String args[]){
        String res = intToRomanSol1(58);
        System.out.println(res);
        String res1 = intToRomanSol2(58);
        System.out.println(res1);
    }

    public static String intToRomanSol1(int num){
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M",  "CM", "D",  "CD", "C",  "XC", "L", "XL", "X",  "IX", "V",  "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (num == 0){
                break;
            }
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static String intToRomanSol2(int num) {
        List<Pair> symbolList = new ArrayList<>();
        symbolList.add(new Pair("I", 1));
        symbolList.add(new Pair("IV", 4));
        symbolList.add(new Pair("V", 5));
        symbolList.add(new Pair("IX", 9));
        symbolList.add(new Pair("X", 10));
        symbolList.add(new Pair("XL", 40));
        symbolList.add(new Pair("L", 50));
        symbolList.add(new Pair("XC", 90));
        symbolList.add(new Pair("C", 100));
        symbolList.add(new Pair("CD", 400));
        symbolList.add(new Pair("D", 500));
        symbolList.add(new Pair("CM", 900));
        symbolList.add(new Pair("M", 1000));

        StringBuilder res = new StringBuilder();
        for(int i = symbolList.size() - 1; i >= 0; i--){
            String symbol = symbolList.get(i).sym;
            int val = symbolList.get(i).val;
            while(num >= val){
                res.append(symbol);
                num -= val;
            }
        }
        return res.toString();
    }

    private static class Pair {
        String sym;
        int val;

        Pair(String sym, int val) {
            this.sym = sym;
            this.val = val;
        }
    }
}
