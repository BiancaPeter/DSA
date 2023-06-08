package exercises;

import java.util.*;

public class Practice {
    //first non repeating character
    //exp: abcdcaf

    public static void main(String[] args) {
        String s = "abcdcaf";
        System.out.println(s.charAt(getFirstNonRepeatingCharacter(s)));
        System.out.println(s.charAt(getFirstNonRepeatingCharacter1(s)));


        //input: diaper, abc, test, cba, repaid
        //output: [[diaper, repaid], [abc, cba]]
        ArrayList<String> input = new ArrayList<>();
        input.add("diaper");
        input.add("abc");
        input.add("test");
        input.add("cba");
        input.add("repaid");
        System.out.println(forwardReversePairs(input));

        //characters: !nub nstun
        //document: sunt bun!
        String s1 = "!nub nstun";
        String s2 = "sunt bun!";
        System.out.println(generateDocument(s1, s2));

        //absesba - palindrom
        String str = "absesba";
        System.out.println(isPalindrome(str));

        //input: I am the best!
        //output: best! the am I
        String str1 = "I am the best!";
        System.out.println(reverseWords(str1));

        //AAAAAAAAAAAAABBCCCCDD
        //9A4A2B4C2D2
        String input1 = "AAAAAAAAAAAAABBCCCCDD";
        System.out.println(rle(input1));

        //input1: "abcd"
        //input2: "bcdabcda" sau "cdab". "acdb" nu este permutare
        String st1 = "abcd";
        String st2 = "bcda";
        System.out.println(stringPermutation(st1, st2));
    }

    public static Integer getFirstNonRepeatingCharacter(String s) {
        Map<Character, Integer> mapCharacters = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (!mapCharacters.containsKey(ch)) {
                mapCharacters.put(ch, 1);
            } else {
                mapCharacters.put(ch, mapCharacters.get(ch) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (mapCharacters.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static Integer getFirstNonRepeatingCharacter1(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            boolean foundDuplicate = false;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    foundDuplicate = true;
                }
            }
            if (!foundDuplicate) {
                return i;
            }
        }
        return -1;
    }

    //input: diaper, abc, test, cba, repaid
    //output: [[diaper, repaid], [abc, cba]]
    public static ArrayList<ArrayList<String>> forwardReversePairs(ArrayList<String> input) {
        Set<String> set = new HashSet<>(input);
        ArrayList<ArrayList<String>> pairs = new ArrayList<>();
        String reversWord;
        for (String word : input) {
            reversWord = new StringBuilder(word).reverse().toString();
            if (set.contains(reversWord)) {
                ArrayList<String> foundPair = new ArrayList<>();
                foundPair.add(word);
                foundPair.add(reversWord);
                set.remove(word);
                set.remove(reversWord);
                pairs.add(foundPair);
            }
        }
        return pairs;
    }

    //characters: !nub nstun
    //document: sunt bun!
    public static boolean generateDocument(String characters, String document) {
        Map<Character, Integer> mapCharacters = new HashMap<>();
        for (Character ch : characters.toCharArray()) {
            if (!mapCharacters.containsKey(ch)) {
                mapCharacters.put(ch, 1);
            } else {
                mapCharacters.put(ch, mapCharacters.get(ch) + 1);
            }
        }
        for (Character ch : document.toCharArray()) {
            if ((!mapCharacters.containsKey(ch)) || (mapCharacters.get(ch) == 0)) {
                return false;
            }
            mapCharacters.put(ch, mapCharacters.get(ch) - 1);
        }
        return true;
    }

    //absesba - palindrom
    public static boolean isPalindrome(String str) {
        String reverseString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseString += str.charAt(i);
        }
        if (str.equals(reverseString)) {
            return true;
        }
        return false;
    }

    public static boolean isPalindrome1(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //input: I am the best!
    //output: best! the am I

    //parcurgem string-ul
    //atat timp e diferit de spatiu, construim cuvintele si le bagam intr-o lista
    //inversam lista
    public static String reverseWords(String str) {
        ArrayList<String> words = new ArrayList<>();
        int startOfWord = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                words.add(str.substring(startOfWord, i));
                startOfWord = i + 1;
            }
        }
        words.add(str.substring(startOfWord));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    //AAAAAAAAAAAAABBCCCCDD
    //9A4A2B4C2D2
    public static String rle(String input) {
        ArrayList<Character> encodedString = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1) && count < 9) {
                count++;
            } else {
                encodedString.add(Character.forDigit(count, 10));
                encodedString.add(input.charAt(i));
                count = 1;
            }
        }
        return encodedString.toString();
    }

    //input1: "abcd"
    //input2: "bcdabcda" sau "cdab". "acdb" nu este permutare
//    String st1 = "abcd"
//    String st2 = "bcda"

    public static boolean stringPermutation(String s1, String s2) {
        String duplicateSecondString = s2 + s2;
        int i = 0;
        int j = 0;
        while (s1.charAt(i) != s2.charAt(j) && j < s2.length()) {
            j++;
        }
        while ((s1.charAt(i) == duplicateSecondString.charAt(j)) && i < s1.length()) {
            i++;
            j++;
        }
        if (i == s1.length()) {
            return true;
        }
        return false;
    }
}
