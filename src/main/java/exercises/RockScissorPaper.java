package exercises;

import java.util.Scanner;

public class RockScissorPaper {
    //Implementeaza o solutia de a juca piatra-foarfece-hartie cu computerul cu o limita de 5 runde
    //Dupa terminarea jocului se va afisa pe ecran cine este jucatorul castigator!
    //Dacă ambii jucători au același gest, runda se repetă până
    //gesturile diferă. Piatra fiind în stare să strice foarfeca, va câștiga dacă aceste două gesturi au fost făcute. Dacă s-a
    //făcut foarfecă și hârtie, câștigă foarfeca (căci poate tăia hârtia), iar dacă se face piatră și hârtie, câștigă hârtia, căci
    //poate împacheta piatra.

    public static void main(String[] args) {
        String[] moves = {"rock", "scissor", "paper"};
        int round = 0;
        playGame(moves, round);
    }

    public static String generateComputerMove(String[] moves) {
        int randIndex = (int) Math.random() * 4;
        return moves[randIndex];
    }

    public static String generatePlayerMove() {
        Scanner console = new Scanner(System.in);
        System.out.print("Choose from rock, scissor or paper: ");
        String word = console.nextLine();
        return word;
    }

    public static int[] playRound(String[] moves) {
        String computerMove = generateComputerMove(moves);
        String playerMove = generatePlayerMove();
        //scoreOfRound[0] - computerScore
        //scoreOfRound[1] - playerScore
        int[] scoreOfRound = {0, 0};
        if (playerMove.equals(computerMove)) {
            scoreOfRound[0]++;
            scoreOfRound[1]++;
        } else if ((playerMove.equals("rock") && computerMove.equals("paper")) || (playerMove.equals("paper") && computerMove.equals("scissor")) || (playerMove.equals("scissor") && computerMove.equals("rock"))) {
            scoreOfRound[0]++;
        } else {
            scoreOfRound[1]++;
        }
        return scoreOfRound;
    }

    public static void playGame(String[] moves, int round) {
        int[] score;
        int computerScore = 0;
        int playerScore = 0;
        while (round < 5) {
            score = playRound(moves);
            computerScore = computerScore + score[0];
            playerScore = playerScore + score[1];
            round++;
        }
        if (computerScore == playerScore) {
            System.out.println("it's a tie, so one more round will be played ");
            playRound(moves);
        } else if (computerScore < playerScore) {
            System.out.println("The winner is player ");
        } else {
            System.out.println("The winner is computer ");
        }
    }
}
