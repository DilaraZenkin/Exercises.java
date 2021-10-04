package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {
    @Test
    public void test_a_length_equal_zero()

    {
        //Arrange
        NonStart ns = new NonStart();
        String input1 = " ";
        String input2 = "code";

        //Act

        String output = ns.getPartialString(input1, input2);

        //Assert
        Assert.assertEquals("ode", output);

    }

    @Test
    public void test_b_length_equal_zero()

    {
        //Arrange
        NonStart ns = new NonStart();
        String input1 = "java";
        String input2 = "";

        //Act

        String output = ns.getPartialString(input1, input2);

        //Assert
        Assert.assertEquals("ava", output);

    }

    @Test
    public void test_not_length_equal_zero()

    {
        //Arrange
        NonStart ns = new NonStart();
        String input1 = "Hello";
        String input2 = "There";

        //Act

        String output = ns.getPartialString(input1, input2);

        //Assert
        Assert.assertEquals("ellohere", output);

    }

    @Test
    public void test_a_length_equal_one()

    {
        //Arrange
        NonStart ns = new NonStart();
        String input1 = "a";
        String input2 = "techelevator";

        //Act

        String output = ns.getPartialString(input1, input2);

        //Assert
        Assert.assertEquals("echelevator", output);

    }

    @Test
    public void test_b_length_equal_one()

    {
        //Arrange
        NonStart ns = new NonStart();
        String input1 = "love";
        String input2 = "b";

        //Act

        String output = ns.getPartialString(input1, input2);

        //Assert
        Assert.assertEquals("ove", output);

    }

    @Test
    public void test_a_and_b_length_equal_one()

    {
        //Arrange
        NonStart ns = new NonStart();
        String input1 = "a";
        String input2 = "b";

        //Act

        String output = ns.getPartialString(input1, input2);

        //Assert
        Assert.assertEquals("", output);

    }
}
