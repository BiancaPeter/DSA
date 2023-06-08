package generalArrays;

public class SearchInSortedMatrix {

    //input
    //1, 4, 7, 12,15,1000
    //2, 5, 19,31,32,1001
    //3, 8, 24,33,35,1002
    //40,41,42,44,45,1003

    //44

    //pornim din coltul dreapta sus
    //cat timp row < arr.length && col >= 0
    //daca el cautat este mai mic decat el curent, mergem pe coloana la stanga
    //daca el cautat este mai mare decat el curent, mergem pe linie in jos
    //O(N+M)T, O(1)S
    public static int[] searchInSorted(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length;
        while (row < matrix.length && col >= 0) {
            if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                return new int[]{row, col};
            }
        }
        return new int[]{-1, -1};
    }
}
