package generalArrays;

import java.util.List;

public class MoveElementToEnd {

    //input: [2,1,2,2,2,3,4,2,2]
    //sa mutam toti doii la sfarsit

    //sol1
    //initial i este 0 si j este pe ultimul element
    //parcurgem lista cu pointerul i si vedem daca elementul curent e 2
    //atat timp cat elementul de la j este 2, fac j--
    //daca elementul de la i este 2 interschimb i cu j
    //O(N)T O(1)S
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            while (i < j && array.get(j) == toMove) {
                j--;
            }
            if (array.get(i) == toMove) {
                swap(i, j, array);
            }
        }
        return array;
    }

    public static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(i);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

    //sol2
    //ne luam un array gol
    //parcurgem array-ul de input si punem in array-ul gol toate elementele diferite de 2
    //apoi punem in array-ul gol atatea elemente de 2 pana umplem array-ul (pentru ca va fi de aceeasi lungime cu array-ul de input)
    //O(N)T, O(N)S

    //sol3
    //parcurgem array-ul
    //fiecare element care nu este 2, il shiftam pana inaintea primului 2 din array
    //O(N2) T (parcurgere + shiftare) O(1)S

    //sol4
    //sortam array-ul, si asa punem toti doii unul langa altul
    //apoi trebuie cumva sa ii shiftam pe toti la final
    //O(N2)T O(N)S
}
