package com.techelevator.filewriting;

import java.util.HashMap;
import java.util.Map;

public class MapsExample {

    //           key    value
    public Map<String, Integer> countOccurrences(String input) {
        Map<String, Integer> counter = new HashMap<String, Integer>();
        if(input == null || input.isEmpty()) { // it's always a good idea to validate that you're getting good input
            return counter;   // give them an empty map
        }

        // From this point down, we can assume we have valid input

        // Elevate Yourself
        input = input.toLowerCase();
        // elevate yourself

        String[] letters = input.split("|"); // this will put every individual letter into an array
        for(String letter : letters) { // go through the array, one letter at a time
            if(!letter.isBlank()) { // don't count empty space
                if(!counter.containsKey(letter)) {  // Process: Have we seen this letter before?
                    counter.put(letter, 1);         //      No? Then mark down that we've seen it 1 time
                } else {
                    int oldCount = counter.get(letter); // Yes? Then get the number of times we've seen it
                    int newCount = oldCount + 1;        //      Now add 1
                    counter.put(letter, newCount);      //      Now overwrite the old value with the new value
                }
            }
        }
        return counter;
    }

}
