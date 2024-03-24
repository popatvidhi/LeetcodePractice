package Strings;

public class StringCompression {

    public static void main(String args[]){
        char[] chars = {'a','a','b','b','c','c','c'};
        int res = compress(chars);
        System.out.println(res);
    }

    public static int compress(char[] chars) {
       int index = 0;
       int i = 0;
       while(i < chars.length){
           int j = i;
           while(j < chars.length && chars[j] == chars[i]){
                j++;
           }
           chars[index++] = chars[i];
           if(j - i > 1){
               String count = j - i + "";
               for(char c : count.toCharArray()){
                   chars[index++] = c;
               }
           }
           i = j;
       }
       return index;
    }
}
