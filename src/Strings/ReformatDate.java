package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReformatDate {

    public static void main(String args[]){
        System.out.println(reformatDate("20th Oct 2052"));
    }

    public static String reformatDate(String date) {
        String[] d = date.split(" ");
        int dd = Integer.parseInt(d[0].substring(0, d[0].length() - 2));
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> monthList = Arrays.asList(month);
        int mm = monthList.indexOf(d[1]) + 1;
        String yyyy = d[2];

        return yyyy + "-" + String.format("%02d",mm) + "-" + String.format("%02d",dd);
    }
}
