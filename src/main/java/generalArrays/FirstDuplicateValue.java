package generalArrays;

import java.util.HashSet;

public class FirstDuplicateValue {

    public static int firstDuplicateValue(int[] array) {
        int minimDuplicateIndex = array.length;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    minimDuplicateIndex = Math.min(minimDuplicateIndex, j);
                }
            }
        }
        if (minimDuplicateIndex == array.length) {
            return -1;
        }
        return array[minimDuplicateIndex];
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 4, 4, 7, 3, 9};
        System.out.println(firstDuplicateValue(arr));
        System.out.println(firstDuplicateValue2(arr));
    }

    public static int firstDuplicateValue2(int[] array) {
        HashSet<Integer> visited = new HashSet<>();
        for (int value : array) {
            if (visited.contains(value)) {
                return value;
            }
            visited.add(value);
        }
        return -1;
    }
}
