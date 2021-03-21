package com.company;


import java.util.Objects;

public class Card implements Comparable<Card> {
    public static final int MIN_CARD = 1;
    public static final int MAX_CARD = 14;
    public enum Suits{
        CLUBS,
        SPADES,
        HEARTS,
        DIAMONDS
    }
    private int valueOfCard;
    private Suits suit;

    public Card(int valueOfCard){
        if (valueOfCard < MIN_CARD) throw new IllegalArgumentException("Card minimum is"+ MIN_CARD);
        if (valueOfCard > MAX_CARD) throw new IllegalArgumentException("Card maximum is "+ MAX_CARD);
        this.valueOfCard = valueOfCard;
    }
    public Card(int valueOfCard, Suits suit){
        if (valueOfCard < MIN_CARD) throw new IllegalArgumentException("Card minimum is"+ MIN_CARD);
        if (valueOfCard > MAX_CARD) throw new IllegalArgumentException("Card maximum is "+ MAX_CARD);
        this.valueOfCard = valueOfCard;
        this.suit = suit;
    }

    public int getValueOfCard() {
        return valueOfCard;
    }
    public Suits getSuit() {
        return suit;
    }
    public boolean higherValue( Card card){
        return card != null && this.getValueOfCard() > card.getValueOfCard();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return valueOfCard == card.valueOfCard;
    }
    @Override
    public int hashCode() {
        return Objects.hash(valueOfCard);
    }

    @Override
    public int compareTo(Card o) {
        if (o == null) return 1;
        return Integer.compare(this.getValueOfCard(), o.getValueOfCard());
    }
}
