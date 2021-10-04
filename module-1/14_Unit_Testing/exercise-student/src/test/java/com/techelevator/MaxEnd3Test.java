package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {

    @Test

    public void test_first_element_larger_than_others (){

        //Arrange
        MaxEnd3 me= new MaxEnd3();
        int[] input = {11, 5, 9};
        int[] input1 = {11, 11, 11};

        //Act
        int[] output = me.makeArray(input);

        //Arrange

        Assert.assertArrayEquals(input1, output );

    }

    @Test

    public void test_second_element_larger_than_others (){

        //Arrange
        MaxEnd3 me= new MaxEnd3();
        int[] input = {5, 11, 9};
        int[] input1 = {9, 9, 9};

        //Act
        int[] output = me.makeArray(input);

        //Arrange

        Assert.assertArrayEquals(input1, output );

    }

    @Test

    public void test_third_element_larger_than_others (){

        //Arrange
        MaxEnd3 me= new MaxEnd3();
        int[] input = {9, 5, 11};
        int[] input1 = {11, 11, 11};

        //Act
        int[] output = me.makeArray(input);

        //Arrange

        Assert.assertArrayEquals(input1, output );

    }
}
