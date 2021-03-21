package com.company;


import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Player {

    public static int numOfPlayers;
    public final static int MIN_PLAYER = 2;
    private String name;
    public Stack<Card> drawPile = new Stack<>();
    public ArrayList<Card> discardPile = new ArrayList<>();

    public Player(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Card drawCard(){
        Card lastDrawnCard;
        // No cards in Draw Pile, Discard Pile is shuffled and moved to Draw Pile
        if (drawPile.size() == 0){
            // Discard Pile is empty, no card to return
            if (discardPile.size() == 0){
                return null;
            }
            DeckShuffle.shuffle(discardPile,new Random());
            addCardsToDrawPile(discardPile);
            deleteCardsFromDiscardPile();
        }
        lastDrawnCard = drawPile.pop();
        return lastDrawnCard;
    }
    public void addCardToDrawPile(Card card){drawPile.add(card);}
    public void addCardsToDrawPile(ArrayList<Card> discardPile){
        for (Card card : discardPile) {
            addCardToDrawPile(card);
        }
    }
    public void deleteCardsFromDiscardPile(){
        discardPile.clear();
    }

    public void addCardsToDiscardPile(ArrayList<Card> cardsOnTable){
        discardPile.addAll(cardsOnTable);
    }
    public int playerCardCounter (){
        return drawPile.size() + discardPile.size();
    }
}
