package exercises;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = console.nextLine();
        //String reverse = new StringBuilder((s)).reverse().toString();
        System.out.println(reverseString(s));
    }

    public static String reverseString(String s) {
        String reverseString = "";
        char[] characters = s.toCharArray();
        char[] reverseCharacters = new char[characters.length];
        for (int i = characters.length - 1; i >= 0; i--) {
            reverseCharacters[characters.length - 1 - i] = characters[i];
        }
        for (int i = 0; i < reverseCharacters.length; i++) {
            reverseString = reverseString + reverseCharacters[i];
        }
        return reverseString;
    }
}
