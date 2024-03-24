package Strings;

public class PalindromicSubtring {
    public static void main(String args[]){
        int res;
        String s = "aaab";
        res = countSubstrings(s);
        System.out.println(res);
    }
    public static int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            //odd length
            int l = i;
            int r = i;
            res += countPalindrome(s,l,r);
            //even length
            l = i;
            r = i+1;
            res += countPalindrome(s,l,r);

        }
        return res;
    }
    public static int countPalindrome(String s, int l, int r){
        int res = 0;
        while((l >= 0 && r < s.length()) && (s.charAt(l) == s.charAt(r))){
            res++;
            l--;
            r++;
        }
        return res;
    }
}
