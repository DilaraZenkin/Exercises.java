package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class DateFashionTest {

    @Test

    public void test_two_or_under_the_two() {
        //Arrange
        DateFashion df = new DateFashion();
        int input1 = 5;
        int input2 = 2;

        //Act
        int output = df.getATable(input1, input2);

        //Assert
        Assert.assertEquals("Input: dateFashion(5, 2)",0, output);
    }

    @Test

    public void test_max_and_min_numbers() {
        //Arrange
        DateFashion df = new DateFashion();
        int input1 = 10;
        int input2 = 1;

        //Act
        int output = df.getATable(input1, input2);

        //Assert
        Assert.assertEquals("Input: dateFashion(10, 1)",0, output);
    }

    @Test

    public void test_eight_or_more() {
        DateFashion df = new DateFashion();
        int input1 = 8;
        int input2 = 8;

        int output = df.getATable(input1, input2);
        Assert.assertEquals("Input: dateFashion(8, 8)", 2, output);
    }

    @Test

    public void test_five_or_more() {
        DateFashion df = new DateFashion();
        int input1 = 5;
        int input2 = 10;

        int output = df.getATable(input1, input2);
        Assert.assertEquals("Input: dateFashion(5, 10)",2, output);
    }

    @Test

    public void test_otherwise() {
        DateFashion df = new DateFashion();
        int input1 = 5;
        int input2 = 5;

        int output = df.getATable(input1, input2);
        Assert.assertEquals("Input: dateFashion(5, 5)",1, output);
    }
}
