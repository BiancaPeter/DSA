package string;

import java.util.ArrayList;

public class RunLengthEncoding {

    //AAAAAAAAAAAAABBCCCCDD2
    //9A4A2B4C2D12

    //O(N)TS
    public static String rle(String input) {

        ArrayList<Character> encodedString = new ArrayList<>();
        int currentLength = 1;
        for (int i = 0; i < input.length()-1; i++) {
            if (input.charAt(i) == input.charAt(i + 1) && currentLength < 9) {
                currentLength++;
            } else {
                encodedString.add(Character.forDigit(currentLength, 10));
                encodedString.add(input.charAt(i));
                currentLength = 1;
            }

        }
        encodedString.add(Character.forDigit(currentLength, 10));
        encodedString.add(input.charAt(input.length()-1));
        return encodedString.toString();
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAAAABBCCCCDD";
        System.out.println(rle(s));
    }
}
