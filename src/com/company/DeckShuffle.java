package com.company;

import java.util.List;
import java.util.Random;

public class DeckShuffle {
    // Fisher yates shuffle algorithm

    // Generic function to randomize a list in Java using Fisher–Yates shuffle
    public static<T> void shuffle(List<T> list, Random random)
    {
        // start from end of the list
        for (int i = list.size() - 1; i >= 1; i--)
        {
            // get a random index j such that 0 <= j <= i
            int j = random.nextInt(i + 1);

            // swap element at i'th position in the list with element at
            // randomly generated index j
            T obj = list.get(i);
            list.set(i, list.get(j));
            list.set(j, obj);
        }
    }
}
