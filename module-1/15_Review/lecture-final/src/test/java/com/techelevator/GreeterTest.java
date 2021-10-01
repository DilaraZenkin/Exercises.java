package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class GreeterTest {

    @Test
    public void this_is_a_test_this_is_only_a_test() {
        Assert.fail("Replace this placeholder with some good tests");
    }

    @Test
    public void greetingAndTime_test() {
        Greeter greeterUnderTest = new Greeter();             // Arrange
        String output = greeterUnderTest.greetingAndTime();   // Act

        // Assert
        Assert.assertNotNull(output);
        Assert.assertEquals(72, output.length());
    }

}