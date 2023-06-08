package generalArrays;

public class ThreeLargestNumbers {
    //O(N)
    public static int[] findNumbers(int[] array) {
        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : array) {
            if (num > threeLargest[2]) {
                shiftAndInsert(threeLargest, num, 2);
            } else if (num > threeLargest[1]) {
                shiftAndInsert(threeLargest, num, 1);
            } else if (num > threeLargest[0]) {
                shiftAndInsert(threeLargest, num, 0);
            }
        }
        return threeLargest;
    }

    private static void shiftAndInsert(int[] threeLargest, int num, int i) {
        for (int j = 0; j < i; j++) {
            threeLargest[j] = threeLargest[j + 1];
        }
        threeLargest[i] = num;
    }


    public static void main(String[] args) {
        int[] array = {141, 1, 17, -7, -17, -27, 18, 561, 8, 7, 7,};
        int[] result = findNumbers(array);
        for (int num : result) {
            System.out.println(num);
        }
    }
}
