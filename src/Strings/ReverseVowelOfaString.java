package Strings;

public class ReverseVowelOfaString {

    public static void main(String[] args){
        String s = "leetcode";
        String res = reverseVowels(s);
        System.out.println(res);
    }

    public static String reverseVowels(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder vowels = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                vowels.append(c);
            }
        }
        vowels.reverse();
        int n = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(isVowel(c) && n < vowels.length()-1){
                res.append(vowels.charAt(n));
                n++;
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
    public static boolean isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||
                c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
            return true;
        }
        return false;
    }
}
