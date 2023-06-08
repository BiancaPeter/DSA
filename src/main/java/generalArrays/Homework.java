package generalArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Homework {
    public static void main(String[] args) {
        //Ex2
        //Cea mai mica diferenta dintre 2 array-uri
        //Daca ai 2 array-uri, gaseste elementele (unul din primul si celalalt din al doilea) care sa dea diferenta minima
        //
        //Input:
        //Arr1: [-1,5,10,21,28,3]
        //Arr2: [26,134,135,15,17]
        //
        //Output: [28,26]

        int[] arr1 = {-1, 5, 10, 20, 28, 3};
        int[] arr2 = {26, 134, 135, 15, 17};
        getSmallestDifferenceBetweenArrays(arr1, arr2);
        System.out.println(getSmallestDifferenceBetweenArrays2(arr1, arr2));

        //Ex1
        //Subsir de suma 0
        //Scrie o functie care sa determina daca exista un subsir cum suma 0 intr-un array.
        //
        //Input: [-5,-5,2,3,-1]
        //Output: true - subsitul [-5,2,3] are suma 0

        int[] a = {-5, -5, 2, 3, -1};
        System.out.println(getSubArrayWithSum0(a));
        System.out.println(getSubArrayWithSum02(a));


        //Ex. Determina castigatorul unui turneu.
        String[] ar1 = {"HTML", "C#"};
        String[] ar2 = {"C#", "Python"};
        String[] ar3 = {"Python", "HTML"};
        String[][] competitions = {ar1, ar2, ar3};
        int[] results = {0, 0, 1};
        getWinnerOfTournament(competitions, results);


        // Ex. Exista doua elemente din array a caror suma sa fie egala cu o valoare data?
        // input: [1, 2, 5, 7, 9]  12
        int[] arr = {1, 2, 5, 7, 9};
        int sum = 12;
        int element = twoNumberSum(arr, sum);
        if (element == 0) {
            System.out.println("nu exista doua numere in sirul dat a caror suma sa fie egala cu " + sum);
        } else {
            System.out.println("suma numerelor " + (sum - element) + " si " + element + ", din situl dat, este egala cu " + sum);
        }

        System.out.println("------------------");
        int[] response = twoNumberSum2(arr, sum);
        if (response[0] == 0 && response[1] == 0) {
            System.out.println("nu exista doua numere in sirul dat a caror suma sa fie egala cu " + sum);
        } else {
            System.out.println("suma numerelor " + response[0] + " si " + response[1] + ", din situl dat, este egala cu " + sum);
        }
    }

    //O(N2)
    public static void getSmallestDifferenceBetweenArrays(int[] arr1, int[] arr2) {
        int min = Integer.MAX_VALUE;
        int indexF = -1;
        int indexS = -1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if ((arr1[i] > arr2[j]) && (min > arr1[i] - arr2[j])) {
                    min = arr1[i] - arr2[j];
                    indexF = i;
                    indexS = j;
                }
                if ((arr1[i] < arr2[j]) && (min > arr2[j] - arr1[i])) {
                    min = arr2[j] - arr1[i];
                    indexF = i;
                    indexS = j;
                }
            }
        }
        System.out.println(arr1[indexF] + " " + arr2[indexS]);
    }

    public static List<Integer> getSmallestDifferenceBetweenArrays2(int[] arr1, int[] arr2) {
        //{-1, 3, 5, 10, 20, 28}
        //{ 15, 17, 26, 134, 135}
        int i = 0;
        int j = 0;
        int elem1 = 0;
        int elem2 = 0;
        int dif = Integer.MAX_VALUE;
        quickSort(arr1, 0, arr1.length - 1);
        quickSort(arr2, 0, arr2.length - 1);
        List<Integer> result = new ArrayList<>();
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                if (dif > arr2[j] - arr1[i]) {
                    dif = arr2[j] - arr1[i];
                    elem1 = arr1[i];
                    elem2 = arr2[j];
                }
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (dif > arr1[i] - arr2[j]) {
                    dif = arr1[i] - arr2[j];
                    elem1 = arr1[i];
                    elem2 = arr2[j];
                }
                j++;
            } else {
                result.add(arr1[i]);
                result.add(arr2[j]);
                return result;
            }
        }
        result.add(elem1);
        result.add(elem2);
        return result;
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


    public static boolean getSubArrayWithSum0(int[] a) {
        int sum;
        for (int i = 0; i < a.length - 1; i++) {
            sum = a[i];
            for (int j = i + 1; j < a.length; j++) {
                sum += a[j];
                if (sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean getSubArrayWithSum02(int[] a) {
        Set<Integer> setSum = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            sum += a[i];
            if (setSum.contains(sum)) {
                return true;
            } else {
                setSum.add(sum);
            }
        }
        return false;
    }


    public static void getWinnerOfTournament(String[][] competitions, int[] results) {
        //1. ne folosim de un array de String, teams, in care vom retine numele echipelor care castiga
        //   si de un array de int, points, in care vom retine punctele adunate de fiecare echipa castigatoare
        //2. parcurgem lista results si verificam daca echipa castigatoare se afla in lista de echipe castigatoare
        //   (echipa castigatoare (gazda/care joaca in deplasare) o determinam in functie de indexul i din for si 0/1 din results)
        //     daca se afla, retinem indexul la care se afla, apoi in array-ul points, la acelasi index, adaugam 3 puncte
        //     daca nu se afla, adaugam echipa in lista de echipe castigatoare, retinem indexul la care se afla, apoi in array-ul points, la acelasi index, adaugam 3 puncte
        //3. aflam indexul echipei care a obtinut cele mai multe puncte

        List<String> teams = new ArrayList<>();
        List<Integer> points = new ArrayList<>();
        points.add(0);
        points.add(0);
        points.add(0);

        int index;
        for (int i = 0; i < results.length; i++) {
            if (results[i] == 0) {
                if (teams.contains(competitions[i][1])) {
                    index = teams.indexOf(competitions[i][1]);
                    points.set(index, points.get(index) + 3);
                } else {
                    teams.add(competitions[i][1]);
                    index = teams.indexOf(competitions[i][1]);
                    points.set(index, points.get(index) + 3);
                }
            } else {
                if (teams.contains(competitions[i][0])) {
                    index = teams.indexOf(competitions[i][0]);
                    points.set(index, points.get(index) + 3);
                } else {
                    index = teams.indexOf(competitions[i][0]);
                    points.set(index, points.get(index) + 3);
                }
            }
        }
        int max = 0;
        int indexOfMax = -1;
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i) > points.get(i + 1)) {
                if (max < points.get(i)) {
                    max = points.get(i);
                    indexOfMax = i;
                } else if (max < points.get(i + 1)) {
                    max = points.get(i + 1);
                    indexOfMax = i + 1;
                }
            }
        }
        System.out.println("castigatorul este " + teams.get(indexOfMax) + " cu " + points.get(indexOfMax) + " puncte");
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

    //sort & pointer
    public static int[] twoNumberSum2(int[] arr, int sumTarget) {
        quickSort(arr, 0, arr.length - 1);
        int[] response = {0, 0};
        int l = 0;
        int r = arr.length - 1;
        int sum;
        while (l < r) {
            sum = arr[l] + arr[r];
            if (sum == sumTarget) {
                response[0] = arr[l];
                response[1] = arr[r];
                return response;
            }
            if (sum < sumTarget) {
                l++;
            } else {
                r--;
            }
        }
        return response;
    }

}
