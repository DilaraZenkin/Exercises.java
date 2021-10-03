package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {

    @Test
    public void test_str_is_null() {

        //Arrange
        StringBits sb = new StringBits();
        String input = null;

        //Act
        String output = sb.getBits(input);

        //Assert
        Assert.assertEquals("", output);

    }

    @Test
    public void test_str_length_is_multiple_of_two() {

        //Arrange
        StringBits sb = new StringBits();
        String input = "Hi";

        //Act
        String output = sb.getBits(input);

        //Assert
        Assert.assertEquals("H", output);

    }

    @Test
    public void test_str_length_is_not_multiple_of_two() {

        //Arrange
        StringBits sb = new StringBits();
        String input = "Heeololeog";

        //Act
        String output = sb.getBits(input);

        //Assert
        Assert.assertEquals("Hello", output);

    }

    @Test
    public void test_str_have_space() {

        //Arrange
        StringBits sb = new StringBits();
        String input = "Hi World";

        //Act
        String output = sb.getBits(input);

        //Assert
        Assert.assertEquals("H ol", output);

    }
    @Test
    public void test_str_is_empty() {

        //Arrange
        StringBits sb = new StringBits();
        String input = "";

        //Act
        String output = sb.getBits(input);

        //Assert
        Assert.assertEquals("", output);

    }
}
