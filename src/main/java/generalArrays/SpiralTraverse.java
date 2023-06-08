package generalArrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    //1, 2, 3, 4
    //12,13,14,5
    //11,16,15,6
    //10,9, 8, 7

    //int[][]
    //a[i][j]

    //for (int i=0; i<rows; i++){
    //for(int j=0; j<cols; j++ {
    //sout(a[i][j]);
    //}
    //}

    //sR=0
    //eR=arr.length-1
    //sC=0
    //eC=arr[0].length-1

    //atat timp cat sR<=eR && sC<=eC

    //prima latura: for col sC->eC  : iau arr[sR][col]
    //latura din dreapta: for row sR+1->eR: iau arr[row][eC]
    //latura de jos: for col eC-1->sC: iau arr[eR][col]
    //latura din stanga: for row eR-1->sR: iau arr[row][sC]

    //sR++
    //eR--
    //sC++
    //eC--

    public static List<Integer> spiralTraverse(int[][] array) {
        ArrayList<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                result.add(array[startRow][col]);
            }
            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endCol]);
            }
            for (int col = endCol - 1; col >= startCol; col--) {
                result.add(array[endRow][col]);
            }
            for (int row = endRow - 1; row >= startRow; row--) {
                result.add(array[row][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return result;
    }
}
