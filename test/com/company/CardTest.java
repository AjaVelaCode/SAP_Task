package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;





public class CardTest {

    @Test
    public void card_LessThan1_ExceptionIsThrown(){
        assertThrows(IllegalArgumentException.class, () -> new Card(0));
    }
    @Test
    public void card_HigherThan14_ExceptionIsThrown(){
        assertThrows(IllegalArgumentException.class, () -> new Card(15));

    }
}