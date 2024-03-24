package Binary;

public class AddBinary {

    public static void main(String[] args){
        String res = addBinary("11", "1");
        System.out.println(res);
    }
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;

        for(int i = 0; i < Math.max(a.length(), b.length()); i++){
            int digitA = i < a.length() ? a.charAt(a.length()- 1 - i) - '0': 0;
            int digitB = i < b.length() ? b.charAt(b.length() - 1 - i) - '0': 0;
            int total = digitA + digitB + carry;
            carry = total / 2;
            int currDigit = total % 2;
            res.insert(0, currDigit);
        }
        if(carry == 1){
            res.insert(0, 1);
        }
        return res.toString();
    }
}
