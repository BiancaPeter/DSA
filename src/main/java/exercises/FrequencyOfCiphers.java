package exercises;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfCiphers {
    public static void main(String[] args) {
        String number = "7772200";
        getFrequencyOfCiphers(number);
    }

    public static void getFrequencyOfCiphers(String number) {
        Map<Character, Integer> ciphers = new HashMap<>();
        for (Character ch : number.toCharArray()) {
            if (!ciphers.containsKey(ch)) {
                ciphers.put(ch, 1);
            } else {
                ciphers.put(ch, ciphers.get(ch) + 1);
            }
        }
        for (Character key : ciphers.keySet()) {
            System.out.println("The cipher " + key + " found " + ciphers.get(key) + " times in the given number.");
        }
    }
}
