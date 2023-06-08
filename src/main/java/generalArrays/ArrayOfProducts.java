package generalArrays;

public class ArrayOfProducts {
    //input: 5,1,4,2
    //output: 8,40,10,20 - de ex: 8 este 1*4*2

    //sol1 - brute force
    //parcurgem elementele din array
    //pentru fiecare element - parcurgem celelalte element si calculam produsul - il punem la pozitia i intr-un array rezultat
    //complexitate - O(N2) timp si O(N) spatiu

    //sol2
    //fac produsul tuturor numelor din array
    //mai parcurg o data si impart produsul la numarul la care sunt si pun rezultatul in array-ul rezultat
    //complexitate - O(N) T si O(N) spatiu

    //sol3 - construim toate produsele din stanga fiecarui element si toate prod din reapta fiecarui element
    //inmultim , pentru fiecare element, produsul din st cu produsul din dreapta
    //O(N) TS
    public static int[] arrayProducts(int[] arr) {
        int[] leftProducts = new int[arr.length];
        int[] rightProducts = new int[arr.length];
        int[] result = new int[arr.length];
        int productLeft = 1;
        int productRight = 1;
        for (int i = 0; i < arr.length; i++) {
            leftProducts[i] = productLeft;
            productLeft = productLeft * arr[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            rightProducts[i] = productRight;
            productRight = productRight * arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }
        return result;
    }
}

