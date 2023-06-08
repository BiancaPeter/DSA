package generalArrays;

import java.util.Arrays;

public class MinimumWaitingTime {

    //input: [3,2,1,2,6]


    //sol1 pentru fiecare element din array, calculez suma de la inceput pana inainte de acel element
    // si adun la o suma totala care reprezinta min witing time
    //O(N2)T O(1) S

    //sol2
    //luam un array ajutator in care punem sumele pana la fiecare task
    //parcurgem array-ul de input si adaugam la acceeasi pozitie in cel ajutator:
    // suma dintre elemntul de la pozitia -1 din array-ul ajutator + elementul de la pozitia -1 din array-ul initial
    //adaug aceasta suma la o suma totala
    //O(NlogN)T O(N)S


    //sol3
    //parcurg duratele sortate
    //pentru fiecare durata, vad cate task-uri mai sunt dupa ea.
    //inmultuesc numarul de task-uri cu durata curenta si adun la o suma totala
    //pentru ca toate task-urile de dupa vor trebui sa astepte dupa durata curenta
    //O(NlogN)T O(1)S

    public static int minWatingTime(int[] tasks) {
        Arrays.sort(tasks);
        int totalWaitingTime = 0;
        for (int i = 0; i < tasks.length; i++) {
            int duration = tasks[i];
            int tasksLeft = tasks.length - i - 1;
            totalWaitingTime += duration * tasksLeft;

        }
        return totalWaitingTime;
    }
}

