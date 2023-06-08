package generalArrays;

public class ValidateSubsequence {
    public static boolean validateSubsequence(int[] a, int[] b) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < a.length && p2 < b.length) {
            if (b[p2] == a[p1]) {
                p2++;
            }
            p1++;
        }
        return p2 == b.length;
    }

    public static void main(String[] args) {
        int[] array1 = {5, 1, 2, 6, 25, 5, -1, 8, 10};
        int[] array2 = {1, 6, -1, 10};
        System.out.println(validateSubsequence(array1, array2));
    }
}
