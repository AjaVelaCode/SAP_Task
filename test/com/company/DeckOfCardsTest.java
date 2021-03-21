package com.company;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {
    @Test
    public void deckSize() {
        int numOfDifferentCard = 10;
        int expectedDeckSize = 40;
        DeckOfCards deck = new DeckOfCards(numOfDifferentCard);
        int actualDeckSize = deck.deckOfCards.size();

        assertEquals(expectedDeckSize, actualDeckSize);
    }

    @Test
    public void deck_ShuffleDeck(){
        int numOfDifferentCard = 10;
        DeckOfCards deckOriginal = new DeckOfCards(numOfDifferentCard);
        DeckOfCards deckShuffled = new DeckOfCards(numOfDifferentCard);

        deckShuffled.shuffleDeck(new Random());
        assertNotEquals(deckShuffled.deckOfCards, deckOriginal.deckOfCards);
    }

    @Test
    public void deck_IfNumberOfDifferentCardsLessThanOrEqualTo0_ExceptionIsThrown(){
        assertThrows(IllegalArgumentException.class, () -> new DeckOfCards(0));
    }

}