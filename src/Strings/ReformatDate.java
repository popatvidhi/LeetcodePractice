package Strings;

import java.util.*;

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

    public static String reformatDate1(String date) {
        String[] d = date.split(" ");
        int dd = Integer.parseInt(d[0].substring(0, d[0].length() - 2));

        Map<String, String> month = new HashMap<>();
        month.put("Jan","01");
        month.put("Feb","02");
        month.put("Mar","03");
        month.put("Apr","04");
        month.put("May","05");
        month.put("Jun","06");
        month.put("Jul","07");
        month.put("Aug","08");
        month.put("Sep","09");
        month.put("Oct","10");
        month.put("Nov","11");
        month.put("Dec","12");
        String mm = month.get(d[1]);

        String yyyy = d[2];

        return yyyy + "-" + mm + "-" + String.format("%02d", dd);
    }
}
