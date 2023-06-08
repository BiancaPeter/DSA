package exercises;

import java.util.HashMap;
import java.util.Map;

public class MostRepeatedCharacter {
    // Gaseste caracterul care se repeta de cele mai multe ori intr-un string
    // affsthfaaf
    public static void main(String[] args) {
        String s = "affsthfaaf";
        System.out.println(getMostRepeatedCharacter(s));
    }
    //O(N) T - parcurgem inputul in primul for
    //       - al doilea for parcurge mapa cu max 26 de elemente(avem max 26 key-caractere) (O(1))
    //O(1) S - mapa are max 26 de elemente
    public static Character getMostRepeatedCharacter(String s) {
        Map<Character, Integer> mapCharacters = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (!mapCharacters.containsKey(ch)) {
                mapCharacters.put(ch, 1);
            } else {
                mapCharacters.put(ch, mapCharacters.get(ch) + 1);
            }
        }
        int maxRepeatedCharacter = 0;
        Character foundCharacter = null;
        for (Character key : mapCharacters.keySet()) {
            if (mapCharacters.get(key) > maxRepeatedCharacter) {
                maxRepeatedCharacter = mapCharacters.get(key);
                foundCharacter = key;
            }
        }
        return foundCharacter;
    }
}
