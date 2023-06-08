package exercises;

import java.util.HashSet;
import java.util.Set;

public class FindPairOfSumX {
    public static void main(String[] args) {
        // Gaseste o perechile de suma x dintr-un array
        // input: [1, 2, 5, 7, 9]  12
        int[] arr = {1, 2, 5, 7, 9};
        int sum = 12;
        int element = twoNumberSum(arr, sum);
        if (element == 0) {
            System.out.println("nu exista doua numere in sirul dat a caror suma sa fie egala cu " + sum);
        } else {
            System.out.println("suma numerelor " + (sum - element) + " si " + element + ", din situl dat, este egala cu " + sum);
        }
    }
    public static int twoNumberSum(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(sum - arr[i])) {
                return arr[i];
            } else {
                set.add(arr[i]);
            }
        }
        return 0;
    }


}
