package string;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    //characters: !nub nstun
    //document: sunt bun!

    //O(N+M)T, O(C)S, unde C este nr de caractere unice din characters,
    // N este lungimea lui characters, M este lungimea lui document
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
            if (!mapCharacters.containsKey(ch) || (mapCharacters.get(ch) == 0)) {
                return false;
            }
            mapCharacters.put(ch, mapCharacters.get(ch) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        String s1= "!nub nstun";
        String s2 = "sunt bun!";
        System.out.println(generateDocument(s1,s2));
    }
}
