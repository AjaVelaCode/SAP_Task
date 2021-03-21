package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        // New deck
        DeckOfCards deck = new DeckOfCards(10);
        // New players
        ArrayList<Player> players = new ArrayList<>();
        System.out.println("Number of players in the game? ");
        Scanner sc = new Scanner(System.in);
        Player.numOfPlayers = sc.nextInt();
        if (Player.numOfPlayers < Player.MIN_PLAYER  || Player.numOfPlayers > deck.getNumberOfTotalCards())
            throw new IllegalArgumentException("Number of players should be between "
                    + Player.MIN_PLAYER + " and " + deck.getNumberOfTotalCards());
        if (deck.getNumberOfTotalCards() % Player.numOfPlayers != 0)
            throw new ArithmeticException("Players should get the same amount of cards.");
        for (int i=0; i<Player.numOfPlayers; i++){
            players.add(new Player("Player " + (i+1)));
        }
        // New game
        Game game = new Game(players, deck);
        // Game starts
        game.startGame();

    }
}
