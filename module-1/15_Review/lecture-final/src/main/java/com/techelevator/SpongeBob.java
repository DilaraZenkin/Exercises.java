package com.techelevator;

import java.util.Random;

public class SpongeBob {

    public String covertToSpongeBobCase(String input) {
        Random generator = new Random();
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            String thisLetter = input.substring(i, i+1);

            boolean rando = generator.nextBoolean();
            if(rando) {
                output = output + thisLetter.toUpperCase();
            } else {
                output = output + thisLetter.toLowerCase();
            }

        }

        return output;
    }

}
