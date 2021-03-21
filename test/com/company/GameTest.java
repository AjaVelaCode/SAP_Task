package com.company;


import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void playRound_WhenComparingTwoCards_TheHigherCardShouldWin() {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        player1.addCardToDrawPile(new Card(5) ); // player 1 has higher card
        player2.addCardToDrawPile(new Card(4) );

        Player winner = Game.playRound(players);

        assertEquals(player1, winner);
    }

    @Test
    public void playRound_WhenComparingTwoCardsOfTheSameValue_TheWinnerOfTheNextRoundShouldWin4Cards(){
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        // Added cards: first different then equal
        player1.addCardToDrawPile(new Card(7) ); // player 1 has higher card
        player2.addCardToDrawPile(new Card(6) );
        player1.addCardToDrawPile(new Card(4) );
        player2.addCardToDrawPile(new Card(4) );

        Player winner = Game.playRound(players);
        int actualNumOfWinnerCards = winner.playerCardCounter();
        int expectedNumOfWinnerCards = 4;

        assertEquals(actualNumOfWinnerCards, expectedNumOfWinnerCards);
    }
}