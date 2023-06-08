package exercises;

public class Palindrome {
    public static void main(String[] args) {
        //Scrie o functie care sa determine daca un string este palindrom
        String st = "alabala";
        if (isPalindrome(st)) {
            System.out.println("The word " + st + " is palindrome.");
        } else {
            System.out.println("The word " + st + " isn't palindrome.");
        }

        if (isPalindrome1(st)) {
            System.out.println("The word " + st + " is palindrome.");
        } else {
            System.out.println("The word " + st + " isn't palindrome.");
        }
    }

    public static boolean isPalindrome(String st) {
        String reversedSt = "";
        for (int i = st.length() - 1; i >= 0; i--) {
            reversedSt += st.charAt(i);
        }
        if (reversedSt.equals(st)) {
            return true;
        }
        return false;
    }

    public static boolean isPalindrome1(String st) {
        for (int i = 0; i < st.length() / 2; i++) {
            if (st.charAt(i) != st.charAt(st.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
