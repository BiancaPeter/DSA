package string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    //input: "abcdcaf"
    //sol1
    //O(N2)T, O(1)
    public static Integer getFirstNOnRepeating(String s) {
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

    //O(N)T O(1)S
    public static Integer getFirstNOnRepeating2(String s) {
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

    public static void main(String[] args) {
        String s = "abcdcaf";
        System.out.println(getFirstNOnRepeating2(s));
        System.out.println(getFirstNOnRepeating(s));
    }
}
