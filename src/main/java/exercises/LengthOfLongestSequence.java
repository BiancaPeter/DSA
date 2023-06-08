package exercises;

public class LengthOfLongestSequence {
    //Afla lungimea celei mai lungi secvente de 1 dintr-un sir
    //Complexitate O(N)T

    //input: 553311118899911555111111333
    //output: 6
    public static void main(String[] args) {
        int[] arr = {5, 5, 3, 3, 1, 1, 1, 1, 8, 8, 9, 9, 9, 1, 1, 5, 5, 5, 1, 1, 1, 1, 1, 1, 3, 3, 3};
        System.out.println(getLengthOfLongestSequenceOf1(arr));
    }

    public static int getLengthOfLongestSequenceOf1(int[] arr) {
        int maxLength = 0;
        int length = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == 1) {
                length++;
                i++;
            } else {
                if (maxLength < length) {
                    maxLength = length;
                }
                i++;
                length = 0;
            }
        }
        return maxLength;
    }
}
