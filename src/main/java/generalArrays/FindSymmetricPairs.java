package generalArrays;

import java.util.HashMap;
import java.util.Map;

public class FindSymmetricPairs {

    //[[1,2],[3,4],[5,9],[4,3],[9,5]]

    //sol1 brute force
    //comparam toate perechile intre ele: primul element din prima cu al doilea din a doua si al doilea din prima cu primul din a doua
    //O(N2)T

    //sol2
    //punem perechile intr-un set. Inainte sa le punem, le inversam si vedem daca este deja in set inversul perechii

    //sol3
    //parcurgem array
    //verificam daca valoarea de la cheia care este al doilea element din pereche este egala cu primul element din pereche
    //daca da, am gasit o noua pereche simetirca
    //daca nu, punem primul numar din fiecare pereche ca si cheie si al doilea ca si valoare in mapa
    //O(N)T O(N)S

    public static String findSymmetric(int[][] arr){
        Map<Integer,Integer> map = new HashMap<>();
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i][0];
            int second = arr[i][1];
            if (map.containsKey(second) && map.get(second) == first){
                result += "{" + String.valueOf(second) +"," + String.valueOf(first) + "}";
            }
            else{
                map.put(first,second);
            }
        }
        return result;
    }

}
