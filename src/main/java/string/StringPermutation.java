package string;

public class StringPermutation {

    //input1: "abcd"
    //input2: "bcdabcda" sau "cdab". "acdb" nu este permutare

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "bcda";
        System.out.println(stringPermutation(s1, s2));
    }

    public static boolean stringPermutation(String s1, String s2) {
        //1.dublam al doilea string
        //2.cautam in al doilea string indexul caracterului egal cu primul caracter din primul string
        //(dupa acest pas avem decalajul dintre cele doua stringuri)
        //3.parcurgem al doilea string duplicat cat timp caracterul curent din acest string este egal
        // cu caracterul curent din primul string
        // si cat timp nu am ajuns la finalul stringului s1
        //4.veriicam daca prin parcurgerea de mai sus am ajuns la finalul stringului s1, daca da inseamna
        // ca stringul s2 este permutare a stringului s1 (pentru ca succesiunea de caractere din s1 este
        // egala cu succesiunea de caractere din s2 dublat

        //O(N) T   O(N) S -pt ca ne folosim de un string ajutator, N-lungimea stringului
        //     sau O(1) S - pt ca ne raportam la nr de stringuri si nu la lungimea stringului???

        String duplicateSecondString = s2 + s2;
        int i = 0;
        int j = 0;
//        return s2.contains(s1);

        while ((s1.charAt(i) != s2.charAt(j)) && (j < s2.length())) {
            j++;
        }
        while ((i < s1.length()) && (s1.charAt(i) == duplicateSecondString.charAt(j))) {
            i++;
            j++;
        }
        if (i == s1.length()) {
            return true;
        }
        return false;
    }
    //sol1.2 - conteaza ordinea - generam manual toate permutarile lui s1 si  verificam daca gasim una egala cu s2
    //ne luam un string ajutator in care generam permutarile
    //initial, string-ul este format din ultimul caracter din s1 + substrig-ul de la 0 la penultimul caracter din s1
    //generez restul de permutari, adica fac un for care sa mearga de (lugimea string-ului s1 - 1) ori
    //verific daca s este egal cu s2 (daca avem permutare)
    //daca nu, modific s-ul (string-ul ajutator) - adica generez urmatoarea permutare - iau ultimul caracter din s si il pun primul, apoi concatenez cu substrign-ul de la 0 la penultimul caracter in s


    //sol2 -sortam cele 2 string-uri si le comparam - nu functioneaza pentru ca la noi conteaza ordinea in perutare

    //sol3 - pentru permutare in care nu conteaza ordinea
    //parcurgem s1
    //construim o mapa in care cheile sunt fiecare caracter din s1, iar valorile - de cate ori apare fiecare caracter in s1
    //parcurgem s2
    //daca un carcater din s2 nu este in mapa, iesim
    //daca nu, decrementam valoarea de la carcaterul la care suntem in s2 din mapa
    //la final, daca avem doar 0 ca valori in mapa, return true

}
