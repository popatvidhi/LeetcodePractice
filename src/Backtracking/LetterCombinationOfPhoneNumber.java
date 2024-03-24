package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

    public static void main(String args[]){
        List<String> res = letterCombinations("45");
        for(String s : res){
            System.out.print(" '"+s+"' ");
        }
    }
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<String,String> letters = new HashMap<>();
        letters.put("2", "abc");
        letters.put("3","def");
        letters.put("4","ghi");
        letters.put("5","jkl");
        letters.put("6","mno");
        letters.put("7","pqrs");
        letters.put("8","tuv");
        letters.put("9","wxyz");

        if(digits == null || digits.length() == 0 ){
            return res;
        }else {
            backtrack(digits, 0, "", res, letters);
        }

        return res;
    }
    public static void backtrack(String digits, int indexAt, String curString, List<String> res, HashMap<String, String> letters){
        if(curString.length() == digits.length()){
            res.add(curString);
            return;
        }

        char digit = digits.charAt(indexAt);
        String chars = letters.get(String.valueOf(digit));

        if(chars != null){
            for(char c : chars.toCharArray()){
                backtrack(digits, indexAt + 1, curString + c, res, letters);
            }
        }

    }
}
