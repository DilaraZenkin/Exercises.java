package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {
    @Test

    public void test_nums_is_null() {

        //Arrange
        Lucky13 lucky = new Lucky13();
        int[] input = null;

        //Act

        boolean output = lucky.getLucky(input);

        //Assert

        Assert.assertTrue(output);
    }

    @Test

    public void test_nums_contain_both() {

        //Arrange
        Lucky13 lucky = new Lucky13();
        int[] input = {1, 2, 3};

        //Act

        boolean output = lucky.getLucky(input);

        //Assert

        Assert.assertFalse(output);
    }

    @Test

    public void test_nums_contain_ones() {

        //Arrange
        Lucky13 lucky = new Lucky13();
        int[] input = {1, 5, 6, 8};

        //Act

        boolean output = lucky.getLucky(input);

        //Assert

        Assert.assertFalse(output);
    }

    @Test

    public void test_nums_has_not_both() {

        //Arrange
        Lucky13 lucky = new Lucky13();
        int[] input = {2,4,6,8,10};

        //Act

        boolean output = lucky.getLucky(input);

        //Assert

        Assert.assertTrue(output);
    }
    @Test

    public void test_nums_is_empty() {

        //Arrange
        Lucky13 lucky = new Lucky13();
        int[] input = {};

        //Act

        boolean output = lucky.getLucky(input);

        //Assert

        Assert.assertTrue(output);
    }
}
