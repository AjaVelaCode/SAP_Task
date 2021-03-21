package com.company;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Game {

    public ArrayList<Player> players;

    public Game(ArrayList<Player> players, DeckOfCards deck){
        /*
        // optional:
        if (deck.getNumberOfTotalCards() % players.size() != 0)
            throw new IllegalArgumentException("Each player should get the same amount of cards.");
        */
        this.players = players;
        // Shuffle deck
        deck.shuffleDeck(new Random());
        System.out.println("Shuffling...");
        deck.printDeckOfCard();
        // Deal deck
        deck.dealDeck(players);
    }

    public void startGame() {
        System.out.println("*** Game Starts ***");
        Player roundWinner = null;
        // Loop until there is only one player
        while (this.players.size() > 1) {
            roundWinner = playRound(this.players);
            System.out.println("-> " + roundWinner.getName() + " wins this round. \n");
        }
        if (roundWinner != null)
        System.out.println("-> " + roundWinner.getName() + " WINS the game!");
        System.out.println("*** Game Over ***");
    }
    public static Player playRound(ArrayList<Player> players) {
        ArrayList<Player> playersToPlay = players;
        ArrayList<Card> cardsOnTable = new ArrayList<>();
        // Loop until one winner of the round
        while (playersToPlay.size() > 1) {
            ArrayList<Player> playersWithMaxCard = new ArrayList<>();
            Card maxCard = new Card(Card.MIN_CARD);
            Card cardOnTable;
            // Draw card from every player in order to find out which player has highest card
            for (Player player : playersToPlay) {
                cardOnTable = player.drawCard();
                System.out.println(player.getName() + " (" + (player.playerCardCounter() + 1) + "): "
                        + cardOnTable.getValueOfCard() + " of " + cardOnTable.getSuit());
                cardsOnTable.add(cardOnTable);
                // Comparing card:
                // If card is equal, add player to ArrayList of players with highest card
                if (cardOnTable.equals(maxCard)) {
                    playersWithMaxCard.add(player);

                }
                // If card is higher, first clear ArrayList of players with highest card and then add player to that ArrayList
                else if (cardOnTable.higherValue(maxCard)) {
                    playersWithMaxCard.clear();
                    playersWithMaxCard.add(player);
                    maxCard = cardOnTable;
                }
            }

            // Check is there a player with no cards -> kick them out of game
            // To avoid ConcurrentModificationException, iterator is used
            for (Iterator<Player> itr = players.iterator(); itr.hasNext();){
                Player p = itr.next();
                if (p.playerCardCounter() == 0 && !(playersWithMaxCard.size() == 1 && playersWithMaxCard.get(0) == p)) {
                    itr.remove();
                    System.out.println("-> " + p.getName() + " is out of the game!");
                    playersWithMaxCard.remove(p);
                }
            }

            // Keep playing if there are players with same max value card.
            if (playersWithMaxCard.size() > 1){
                System.out.println("-> No winner in this round \n");
            }
            playersToPlay = playersWithMaxCard;
        }
        // Only one player left in the round -> Winner takes all cards from the table
        Player roundWinner = playersToPlay.get(0);
        roundWinner.addCardsToDiscardPile(cardsOnTable);
        cardsOnTable.clear();
        return roundWinner;
    }
}
