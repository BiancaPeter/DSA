package generalArrays;

public class LongestPeak {

    //1,2,3,4,5,0,10,6,5,-1,-3,2,3

    //sol
    //gasesc fiecare peak (stanga < peak > dreapta)
    //pentru fiecare peak ma duc in stanga si in dreapta cat timp cobor si retin de cate ori m-am dus
    //daca m-am dus de mai multe ori decat un max, inlocuiesc max cu de cate ori m-am dus
    //complexitate O(N)T O(1)S
    public static int longestPeak(int[] arr) {
        int maxLength = 0;
        int currentLength = 0;
        int left = 0;
        int right = 0;
        int i = 1;
        while (i < arr.length - 2) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                left = i - 2;
                while (left >= 0 && arr[left] < arr[left + 1]) {
                    left--;
                }
                right = i + 2;
                while (right < arr.length && arr[right] < arr[right - 1]) {
                    right++;
                }
            }
            currentLength = right - left - 1;
            if (maxLength < currentLength) {
                maxLength = currentLength;
            }
            i = right;
        }
        return maxLength;
    }
}

