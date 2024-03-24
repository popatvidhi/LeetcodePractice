package Strings;

public class ReverseWordsInString {

    public static void main(String args[]){
        String s = "the sky is blue";
        String res = reverseWords(s);
        System.out.println(res);
    }


    public static String reverseWords(String s) {
        int i = s.length() - 1;
        int j = s.length() - 1;
        StringBuilder res = new StringBuilder();
        while(j >= 0){
            while(j >= 0 && isAlphaNumeric(s.charAt(j))){
                j--;
            }
            res.append(s.substring(j+1, i+1)).append(" ");

            while (j >= 0 && !isAlphaNumeric(s.charAt(j))) {
                j--;
            }
            i = j;
        }
        return res.toString().trim();
    }
    public static boolean isAlphaNumeric(char c){
        if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
            return true;
        return false;
    }
}
