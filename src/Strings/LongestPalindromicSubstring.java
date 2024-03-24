package Strings;

public class LongestPalindromicSubstring {
    public static void main(String args[]){
        String res = "";
        String s = "babad";
        res = longestPalindrome(s);
        System.out.println(res);
    }
    public static String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;
        for(int i = 0; i < s.length(); i++){
            //odd length
            int l = i;
            int r = i;
            while((l >= 0 && r < s.length()) && (s.charAt(l) == s.charAt(r))){
                if((r - l + 1) > resLen){
                    res = s.substring(l, r + 1);;
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
            //even length
            l = i;
            r = i+1;
            while((l >= 0 && r < s.length()) && (s.charAt(l) == s.charAt(r))){
                if((r - l + 1) > resLen){
                    res = s.substring(l, r + 1);
                    resLen = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
