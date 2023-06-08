package exercises;

public class FindMissingNumber {

    //Avem un array cu numerele de la 1, la n, mai putin unul dintre ele. Cum il afli pe cel care lipseste?
    //input: 5,1,4,2,6   1,2,4,5,6
    //output: 3

    //sol: sortam array-ul cu quickSort
    //     verificam daca diferenta dintre doua elemente consecutive este egala cu 1

    //complexitate O(NlogN)---

    public static int getMissingNumber(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        int dif = 1;
        int i = 0;
        while (dif == 1 && i < arr.length - 1) {
            dif = arr[i + 1] - arr[i];
            i++;
        }
        if (dif != 1) {
            return arr[i-1] + 1; //i-1 pt ca am incrementat i la linia 18
        }
        return 0;
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

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 6};
        System.out.println(getMissingNumber(arr));
    }
}
