package com.company;

import java.util.ArrayList;

public class DeckDealer {
    // In this option -> No matter that every player gets the same amount of cards.
    // It is possible to play game even if number of cards is not divided with number of players.
    public static void dealCards(ArrayList<Card> deckOfCards, ArrayList<Player> players) {
        int i=0;
        int j=0;
        for (Card card : deckOfCards) {
            if (i > (deckOfCards.size() / Player.numOfPlayers) - 1) {
                i = 0;
                j++;
            }
            players.get(j).drawPile.push(card);
            i++;
        }
        printPlayersCard(players);
    }
    public static void printPlayersCard(ArrayList<Player> players) {
        System.out.println("Players cards: ");
        for (Player pl : players) {
            System.out.print(pl.getName() + " (" + pl.playerCardCounter() + "): ");
            for (Card card : pl.drawPile) {
                System.out.print(card.getValueOfCard() + " of " + card.getSuit() + "; ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
