package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SpongeBobTest {

    @Test
    public void spongeBob_preserves_string_length() {
        // Arrange
        SpongeBob objectUnderTest = new SpongeBob();
        String input = "giraffe";

        // Act
        String output = objectUnderTest.covertToSpongeBobCase(input);

        // Assert
        Assert.assertEquals(input.length(), output.length());
    }

    @Test
    public void spongeBob_changes_the_string() {
        // Arrange
        SpongeBob objectUnderTest = new SpongeBob();
        String input = "giraffe";

        // Act
        String output = objectUnderTest.covertToSpongeBobCase(input);

        // Assert
        Assert.assertNotEquals(input, output);
    }

}
