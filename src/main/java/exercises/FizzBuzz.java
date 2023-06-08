package exercises;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        // Scrie un program care afiseaza numerele de la 1 la N. Daca numarul este multiplu de 3, sa se afiseze Fizz,
        // daca este multiplu de 5 sa se afiseze Buzz, daca e multiplu si de 3 si de 5 (ex: 15) sa se afiseze FizzBuzz,
        // in restul cazurilor sa se afiseze numarul.
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the number up to which you want to check the multiple of 3, 5 and 15: ");
        int n = console.nextInt();
        checkMultiple(n);
    }

    public static void checkMultiple(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}
