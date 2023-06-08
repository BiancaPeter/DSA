package exercises;

public class ChangeMatrix {
    //Scrie o functie care schimba toata linia i si coloana j  dintr-o matrice in 0,
    // daca elementul de la i,j este 0

    //1. identificam in matrice pozitia fiecarui element egal cu zero si retinem pozitiile cu ajutorul
    // unei alte matrice (cu max n*m linii si 2 coloane) positions
    //2. pentru fiecare pozitie a elementelor 0 din matrix (retinute in positions), parcurgem matricea initiala, matrix,
    // si modificam cu valoarea zero elemetele aflate pe aceasi linie si aceasi coloana cu elementul 0 gasit initial
    public static void main(String[] args) {
        int[] l1 = {1, 2, 3, 4, 5};
        int[] l2 = {1, 2, 0, 4, 5};
        int[] l3 = {1, 2, 3, 4, 5};
        int[] l4 = {0, 2, 3, 4, 5};
        int[][] matrix = {l1, l2, l3, l4};
        getPositionsOf0ElementInMatrix(matrix);

    }

    public static void getPositionsOf0ElementInMatrix(int[][] matrix) {
        int[][] positions = new int[matrix.length * matrix[0].length][2];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    positions[k][0] = i;
                    positions[k][1] = j;
                    k++;
                }
            }
        }
        int nrOf0Elements = k;
        changeElementsOfMatrix(matrix, positions, nrOf0Elements);
    }

    public static void changeElementsOfMatrix(int[][] matrix, int[][] positions, int nrOf0Elements) {
        for (int k = 0; k < nrOf0Elements; k++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[positions[k][0]][j] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][positions[k][1]] = 0;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
