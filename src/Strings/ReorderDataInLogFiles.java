package Strings;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {

    public static void main(String args[]){
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] res = reorderLogFiles(logs);
//        for(String s : res){
//            System.out.print(" [ " + s + " ] ");
//        }
    }

    public static String[] reorderLogFiles(String[] logs) {
        Comparator<String> myCmp = new Comparator<String>(){
            public int compare(String log1, String log2){
                String[] split1 = log1.split(" ", 2);
                for(String s : split1){
                    System.out.print(" [ " + s + " ] ");
                }
                System.out.println("Split 2");
                String[] split2 = log2.split(" ", 2);
                for(String s : split2){
                    System.out.print(" [ " + s + " ] ");
                }

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if(!isDigit1 && !isDigit2){
                    int cmp = split1[1].compareTo(split2[1]);
                    if(cmp != 0){
                        return cmp;
                    }
                    return split1[0].compareTo(split2[0]);
                }
                if(!isDigit1 && isDigit2){
                    return -1;
                }else if(isDigit1 && !isDigit2){
                    return 1;
                }else{
                    return 0;
                }
            }
        };
        Arrays.sort(logs, myCmp);
        return logs;
    }
}
