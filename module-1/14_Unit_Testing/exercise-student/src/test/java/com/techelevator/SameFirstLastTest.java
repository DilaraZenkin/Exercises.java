package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {

    @Test

    public void test_nums_is_null() {

        //Arrange
        SameFirstLast sfl = new SameFirstLast();
        int[] input = null;

        //Act

        boolean output = sfl.isItTheSame(input);

        //Assert

        Assert.assertFalse(output);
    }

    @Test

    public void test_nums_length_is_empty() {

        //Arrange
        SameFirstLast sfl = new SameFirstLast();
        int[] input = {};

        //Act

        boolean output = sfl.isItTheSame(input);

        //Assert

        Assert.assertFalse(output);
    }

    @Test

    public void test_first_and_last_nums_are_different() {

        //Arrange
        SameFirstLast sfl = new SameFirstLast();
        int[] input = {1,2,3,4,5,6};

        //Act

        boolean output = sfl.isItTheSame(input);

        //Assert

        Assert.assertFalse(output);
    }

    @Test

    public void test_first_and_last_nums_are_same() {

        //Arrange
        SameFirstLast sfl = new SameFirstLast();
        int[] input = {1,2,3,4,5,1};

        //Act

        boolean output = sfl.isItTheSame(input);

        //Assert

        Assert.assertTrue(output);
    }
    }

