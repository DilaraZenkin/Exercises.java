package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {

    @Test

    public void test_one_less_than_multiple_of_20() {

        //Arrange
        Less20 less = new Less20();
        int input = 39;

        //Act

        boolean output = less.isLessThanMultipleOf20(input);

        //Assert

        Assert.assertTrue(output);


    }

    @Test

    public void test_two_less_than_multiple_of_20() {

        //Arrange
        Less20 less = new Less20();
        int input = 38;

        //Act

        boolean output = less.isLessThanMultipleOf20(input);

        //Assert

        Assert.assertTrue(output);
    }

    @Test

    public void test_one_less_than_multiple_of_20_second() {

        //Arrange
        Less20 less = new Less20();
        int input = 21;

        //Act

        boolean output = less.isLessThanMultipleOf20(input);

        //Assert

        Assert.assertFalse(output);
    }

    @Test

    public void test_multiple_of_20() {

        //Arrange
        Less20 less = new Less20();
        int input = 40;

        //Act

        boolean output = less.isLessThanMultipleOf20(input);

        //Assert

        Assert.assertFalse(output);
    }

    @Test

    public void test_two_less_than_multiple_of_20_second() {

        //Arrange
        Less20 less = new Less20();
        int input = 42;

        //Act

        boolean output = less.isLessThanMultipleOf20(input);

        //Assert

        Assert.assertFalse(output);
    }
}
