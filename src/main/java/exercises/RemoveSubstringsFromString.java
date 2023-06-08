package exercises;

public class RemoveSubstringsFromString {
    //Elimina toate subsirurile “abc” din sirul “s”

    public static void main(String[] args) {
        String s = "RemoabcveSubabcstringsFromStrabcing";
        System.out.println(getStringWithoutSubstrings(s));
    }

    public static String getStringWithoutSubstrings(String s) {
        int i = 0;
        String stringWithoutSubstrings = "";
        while (i < s.length() - 2) {
            if (s.charAt(i) == 'a' && s.charAt(i + 1) == 'b' && s.charAt(i + 2) == 'c') {
                i = i + 3;
            } else {
                stringWithoutSubstrings = stringWithoutSubstrings + s.charAt(i);
                i++;
            }
        }
        if (i != s.length()) {
            stringWithoutSubstrings = stringWithoutSubstrings + s.charAt(i) + s.charAt(i + 1);
        }
        return stringWithoutSubstrings;
    }
}
