package com.company;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {

    //private int numberOfDifferentValueCards;
    //private int numberOfSameValueCards;
    private int numberOfTotalCards;
    public ArrayList<Card> deckOfCards = new ArrayList<>();

    public DeckOfCards(int numberOfDifferentValueCards) {
        if (numberOfDifferentValueCards < 1 )
            throw new IllegalArgumentException("Number of different value cards should be positive ");
        for (int i = 1; i <= numberOfDifferentValueCards; i++) {
            for (Card.Suits cardSuits : Card.Suits.values()) {
                deckOfCards.add(new Card(i, cardSuits));
            }
        }
        //this.numberOfDifferentValueCards = numberOfDifferentValueCards;
        this.numberOfTotalCards = numberOfDifferentValueCards * Card.Suits.values().length;

        //printDeckOfCard();
    }

    public void shuffleDeck(Random random){
        DeckShuffle.shuffle(deckOfCards, random);
    }
    public void dealDeck(ArrayList<Player> players){
        DeckDealer.dealCards(deckOfCards, players);
    }
    public int getNumberOfTotalCards() {
        return numberOfTotalCards;
    }
    public void printDeckOfCard(){
        System.out.print("Deck Of Card: ");
        for (Card card : deckOfCards) {
            System.out.print(card.getValueOfCard() + " of " + card.getSuit() + "; ");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
