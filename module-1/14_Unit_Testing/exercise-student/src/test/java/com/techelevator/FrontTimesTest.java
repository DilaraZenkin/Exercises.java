package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {

    @Test

    public void test_empty_string() {

        //Arrange
        FrontTimes ft = new FrontTimes();
        String input1 = "";
        int input2 = 6;

        //Act

        String output = ft.generateString(input1, input2);

        //Assert

        Assert.assertEquals("", output);




    }

    @Test

    public void test_length_under_three() {

        //Arrange
        FrontTimes ft = new FrontTimes();
        String input1 = "Ab";
        int input2 = 4;

        //Act

        String output = ft.generateString(input1, input2);

        //Assert

        Assert.assertEquals("AbAbAbAb", output);


}
    @Test

    public void test_equal_three() {

        //Arrange
        FrontTimes ft = new FrontTimes();
        String input1 = "Abc";
        int input2 = 3;

        //Act

        String output = ft.generateString(input1, input2);

        //Assert

        Assert.assertEquals("AbcAbcAbc", output);


    }

    @Test

    public void test_grater_than_three() {

        //Arrange
        FrontTimes ft = new FrontTimes();
        String input1 = "Dilara";
        int input2 = 2;

        //Act

        String output = ft.generateString(input1, input2);

        //Assert

        Assert.assertEquals("DilDil", output);




    }

    @Test

    public void test_is_null() {

        //Arrange
        FrontTimes ft = new FrontTimes();
        String input1 = null;
        int input2 = 6;

        //Act

        String output = ft.generateString(input1, input2);

        //Assert

        Assert.assertEquals("", output);


    }
    @Test

    public void test_zero_times() {

        //Arrange
        FrontTimes ft = new FrontTimes();
        String input1 = "Dilara";
        int input2 = 0;

        //Act

        String output = ft.generateString(input1, input2);

        //Assert

        Assert.assertEquals("", output);




    }
}
