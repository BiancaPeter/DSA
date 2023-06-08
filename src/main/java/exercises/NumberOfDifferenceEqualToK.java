package exercises;

public class NumberOfDifferenceEqualToK {
    //De cate ori gasesti o diferenta egala cu k intr-un array de n elemente?
    //input: arr=[5, 7, 3, 6, 11, 8]        [3, 5, 6, 7, 8, 11]

    //sortam
    //parcurgem cu 2 pointeri

    public static void main(String[] args) {
        int k = 2;
        int[] arr = {5, 7, 3, 6, 11, 8};
        System.out.println(getNumberOfDifferenceEqualTo(k, arr));
    }

    public static int getNumberOfDifferenceEqualTo(int k, int[] arr) {
        int count = 0;
        int i = 0;
        int j = 1;
        quickSort(arr, 0, arr.length - 1);
        while (j < arr.length) {
            if (arr[j] - arr[i] == k) {
                count++;
                if (j - i > 1) {
                    i++;
                }else{
                    i++;
                    j++;
                }
            } else if (arr[j] - arr[i] < k) {
                j++;
            } else if (arr[j] - arr[i] > k) {
                i++;
            }
        }
        return count;
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(arr, begin, end);
            quickSort(arr, begin, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    public static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
