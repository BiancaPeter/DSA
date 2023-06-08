package string;

import java.util.*;

public class ForwardReversePairs {

    //input: diaper, abc, test, cba, repaid
    //output: [[diaper, repaid], [abc, cba]]

    //O(N*M)TS
    public static ArrayList<ArrayList<String>> forwardReversePairs(ArrayList<String> strings) {
        Set<String> set = new HashSet<>(strings);
        ArrayList<ArrayList<String>> pairs = new ArrayList<>();
        for (String stringWord : strings) {
            String reverse = new StringBuilder((stringWord)).reverse().toString();
            if (set.contains(reverse)) {
                ArrayList<String> foundPair = new ArrayList<>();
                foundPair.add(stringWord);
                foundPair.add(reverse);
                pairs.add(foundPair);
                set.remove(stringWord);
                set.remove(reverse);
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("diaper");
        input.add("abc");
        input.add("test");
        input.add("cba");
        input.add("repaid");

        System.out.println(forwardReversePairs(input));
    }
}
