package string;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseWordsInString {

    //input: I am the best!
    //output: best! the am I

    //sol1
    //split dupa space, introducem intr-un array cuvintele splituite,
    // parcurgem lista de la coada la cap si construim un nou string rezultat
    //O(N) - N lungimea string-ului, O(N)S

    //sol2
    //parcurgem string-ul
    //atat timp e diferit de spatiu, construim cuvintele si le bagam intr-o lista
    //inversam lista

    public String reverseWords(String string){
        ArrayList<String> words = new ArrayList<>();
        int startOfWord = 0;
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character==' '){
                words.add(string.substring(startOfWord,i));
                startOfWord = i+1;
            }

        }
        words.add(string.substring(startOfWord));

        Collections.reverse(words);
        return String.join(" ", words);
    }

    //cum inversam o lista?
    //sol1: parcurgem de la coada la cap
    //sol2:
    //cu 2 pointer, unul la inceput, unul la sfarsit - cel de la inceput il increteam, cel de la sf il decrementam
    //inversam elementele de la i si j la fiecare pas

}
