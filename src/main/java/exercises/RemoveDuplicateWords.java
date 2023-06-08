package exercises;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateWords {
    public static void main(String[] args) {
        //parcurgem string-ul
        //atat timp cat e diferit de spatiu, construim cuvintele si le bagam intr-un set (pentru ca nu contine duplicate
        //construim un string cu elementele din set si afisam stringul

        //complexitate O(N) T, N-lungimea stringului initial
        //complexitate O(M) S, M-numarul de cuvinte neduplicate (avem o structura dedate ajutatoare Set)

        String s = "apa rece apa calda apa";
        System.out.println(removeDuplicateWords(s));
    }

    public static String removeDuplicateWords(String s) {
        Set<String> noDuplicateWords = new HashSet<>();
        int startOfWord = 0;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == ' ') {
                noDuplicateWords.add(s.substring(startOfWord, i));
                startOfWord = i + 1;
            }
        }
        noDuplicateWords.add(s.substring(startOfWord));

        return String.join(" ", noDuplicateWords);
    }

}
