package com.company;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Random;
import com.company.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PlayerTest {

    @Test
    public void drawCard_IfPlayerWithAnEmptyDrawPileTriesToDrawACard_DiscardPileIsShuffledIntoTheDrawPile() {
        // new player for testing
        Player player = new Player("TestPlayer");
        int numOfDifferentCard = 10;
        DeckOfCards deck = new DeckOfCards(numOfDifferentCard);
        deck.shuffleDeck(new Random());
        // add cards to discard pile
        player.addCardsToDiscardPile(deck.deckOfCards);
        // Check if draw pile is empty
        Card drawnCard = player.drawCard();
        player.addCardToDrawPile(drawnCard);

        Collections.sort(player.drawPile);
        Collections.sort(deck.deckOfCards);

        assertArrayEquals(player.drawPile.toArray(), deck.deckOfCards.toArray());
    }
}