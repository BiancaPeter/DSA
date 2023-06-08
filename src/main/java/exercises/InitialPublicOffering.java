//package exercises;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class InitialPublicOffering {
//    public static void main(String[] args) {
//        // <user id, number of shares, bidding price, timestamp>
//
//        List<Integer> bid1 = new ArrayList<>();
//        bid1.add(1);
//        bid1.add(5);
//        bid1.add(5);
//        bid1.add(0);
//
//        List<Integer> bid2 = new ArrayList<>();
//        bid2.add(2);
//        bid2.add(7);
//        bid2.add(8);
//        bid2.add(1);
//
//        List<Integer> bid3 = new ArrayList<>();
//        bid3.add(3);
//        bid3.add(7);
//        bid3.add(5);
//        bid3.add(1);
//
//        List<Integer> bid4 = new ArrayList<>();
//        bid4.add(4);
//        bid4.add(10);
//        bid4.add(3);
//        bid4.add(3);
//
//        List<List<Integer>> bids = new ArrayList<>();
//        bids.add(bid1);
//        bids.add(bid2);
//        bids.add(bid3);
//        bids.add(bid4);
//
//        int totalShares = 18;
//
//        getUnallottedUsers(bids, totalShares);
//
//    }
//
//    public static List<Integer> getUnallottedUsers(List<List<Integer>> bids, int totalShares) {
//        int maxPrice = Integer.MIN_VALUE;
//        List<List<Integer>> usersWithMaxPrice = new ArrayList<>();
//        List<Integer> unallottedUsers = new ArrayList<>();
//
//        //am adaugat toate Id-urile useri-lor intr-o lista de Id-uri
//        for (int i = 0; i < bids.size(); i++) {
//            unallottedUsers.add(bids.get(i).get(0));
//        }
//
//        while (totalShares != 0) {
//            //am gasit pretul maxim
//            for (int i = 0; i < bids.size(); i++) {
//                if (bids.get(i).get(2) > maxPrice) {
//                    maxPrice = bids.get(i).get(2);
//                }
//            }
//            //am creat lista cu userii cu cel mai mare pret
//            for (int i = 0; i < bids.size(); i++) {
//                if (bids.get(i).get(2) == maxPrice) {
//                    usersWithMaxPrice.add(bids.get(i));
//                }
//            }
//            //am sortat userii cu cel mai mare pret al ofertei dupa timpul de ofertare
//            Collections.sort(usersWithMaxPrice.get(3));
//
//            int numberOfSharesUser = totalShares;
//            while ((totalShares != 0) || (numberOfSharesUser != 0)) {
//                for (int i = 0; i < usersWithMaxPrice.size(); i++) {
//                    totalShares--;
//                    usersWithMaxPrice.get(i).set(1, usersWithMaxPrice.get(i).get(1) - 1);
//                    numberOfSharesUser = usersWithMaxPrice.get(i).get(1);
//                }
//            }
//
//        }
//        return unallottedUsers;
//    }
//}