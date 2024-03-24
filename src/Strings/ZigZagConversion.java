package Strings;

public class ZigZagConversion {

    public static void main(String arg[]){
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String res = convert(s, numRows);
        System.out.println(res);
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        //StringBuilder res = new StringBuilder();
        String res  = "";
        for(int r = 0; r < numRows; r++){
            int increment = 2 * (numRows - 1);
            for(int i = r; i < s.length(); i++, increment++){
                res += s.charAt(i);
                if(r > 0 && r < numRows - 1 && (i + increment - 2 * r) < s.length()){
                    res += s.charAt(i + increment - 2 * r);
                }
            }
        }
        return res;
    }
}
