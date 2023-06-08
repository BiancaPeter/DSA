package exercises;

import java.util.HashSet;
import java.util.Set;

public class CodeValidation {
    //Avem o aplicatie in care vrem sa stocam cod-urile produselor in baza de date, doar ca am observat ca din cauza validarii,
    //unele coduri nu se stocheaza bine. Cod-urile sunt citite dintr-un fisier si sunt stocate apoi in baza de date.
    //Ai putea sa faci o validare a codurilor citite din fisier inainte sa fie salvate in DB?
    //Codurile sunt formate din 7 caractere cu urmatorul format: AANNNYY, unde
    //          AA reprezinta 2 caractere alfanumerica,
    //          NNN reprezinte 3 cifre.
    //          AA si NNN reprezinta impreuna ID-ul produsului.
    //          YY este un sufix aleator, unde putem avea orice caractere.
    public static void main(String[] args) {
        String code = "AR568!8";
        if (isValid(code)) {
            System.out.println("The code is valid.");
        } else {
            System.out.println("The code isn't valid.");
        }
    }

    public static boolean isValid(String code) {
        String alphanumerics = "ABCDEFGHIJKLMOPQRSTUVWXYZ0123456789";
        String ciphers = "0123456789";
        String characters = "ABCDEFGHIJKLMOPQRSTUVWXYZ0123456789!@#$%^&*";

        Set<Character> alphanumericsSet = new HashSet<>();
        Set<Character> ciphersSet = new HashSet<>();
        Set<Character> charactersSet = new HashSet<>();

        for (Character al : alphanumerics.toCharArray()) {
            alphanumericsSet.add(al);
        }
        for (Character ci : ciphers.toCharArray()) {
            ciphersSet.add(ci);
        }
        for (Character ch : characters.toCharArray()) {
            charactersSet.add(ch);
        }

       return (alphanumericsSet.contains(code.charAt(0))&&alphanumericsSet.contains(code.charAt(1))
        && ciphersSet.contains(code.charAt(2))&&ciphersSet.contains(code.charAt(3))&&ciphersSet.contains(code.charAt(4))
        && charactersSet.contains(code.charAt(5))&&charactersSet.contains(code.charAt(6)));
    }
}
