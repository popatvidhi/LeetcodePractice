package Strings;

/**
 * Suppose I have "abbbccda" then it should return [1, 3]. Because it starts from index 1 and is 3 characters long. If the input string is empty then return [-1, 0].
 * Other Examples:
 * "10000111" => [ 1, 4 ]
 * "aabbbbbCdAA" => [ 2, 5 ]
 */
public class LongestUniformSubstring {

    public static void main(String args[]){
        int[] res = repeatedSubstring("abbbccda");
        for(int r : res){
            System.out.print(r + " ");
        }

    }
    public static int[] repeatedSubstring(String s) {
        int[] res = new int[]{-1, 0};
        int l = 0, r = 0;
        while(r < s.length()){
            if(s.charAt(l) == s.charAt(r)){
                int resLen = r - l + 1;
                if(resLen > res[1]){
                    res[1] = resLen;
                    res[0] = l;
                }
            }
            while(s.charAt(l) != s.charAt(r)){
                l++;
            }
            r++;
        }
        return res;
    }
}
