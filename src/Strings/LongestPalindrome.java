package Strings;

public class LongestPalindrome {

    public static void main(String args[]){
        String s = "abccccdd";
        int res = longestPalindrome(s);
        System.out.println(res);
    }

    public static int longestPalindrome(String s) {
        int[] char_counts = new int[128];
        for(char c : s.toCharArray()){
            char_counts[c]++;
        }
        int res = 0;
        for(int char_count : char_counts){
            res += char_count / 2 * 2;
            if(res % 2 == 0 && char_count % 2 == 1){
                res += 1;
            }
        }
        return res;
    }
}
