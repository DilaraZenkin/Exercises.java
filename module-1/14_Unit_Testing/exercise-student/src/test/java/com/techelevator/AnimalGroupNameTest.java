package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {

    @Test

    public void test_getHerd_giraffe_sarcasm_case() {
        // Arrange
        AnimalGroupName agn = new AnimalGroupName();
        String input = "gIrAFfe";

        // Act
        String output = agn.getHerd(input);


        // Assert
        Assert.assertEquals("Tower", output);
    }
    @Test

    public void test_getHerd_with_empty_string() {
        //Arrange
        AnimalGroupName agn = new AnimalGroupName();
        String input = "";

        //Act
        String output = agn.getHerd(input);

        //Assert
        Assert.assertEquals("unknown", output);
    }

    @Test

    public void test_getHerd_with_null () {
        AnimalGroupName agn= new AnimalGroupName();
        String input = null;

        String output = agn.getHerd(input);

        Assert.assertEquals("unknown", output);
    }
}
