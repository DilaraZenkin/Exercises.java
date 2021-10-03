package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {

    @Test

    public void test_under_between_ranges_haveParty() {
        CigarParty cp = new CigarParty();
        int input = 30;
        boolean input1 = true;

        boolean output = cp.haveParty(input, input1);

        Assert.assertFalse(output);
    }

    @Test

    public void test_is_not_weekend() {
        CigarParty cp = new CigarParty();
        int input = 70;
        boolean input1 = false;

        boolean output = cp.haveParty(input, input1);
        Assert.assertFalse(output);
    }

    @Test

    public void test_is_weekend() {
        CigarParty cp = new CigarParty();
        int input = 70;
        boolean input1 = true;

        boolean output = cp.haveParty(input, input1);
        Assert.assertTrue(output);

    }

    @Test

    public void test_is_weekend_and_between_range() {
        CigarParty cp = new CigarParty();
        int input = 40;
        boolean input1 = true;

        boolean output = cp.haveParty(input, input1);
        Assert.assertTrue(output);

    }

    @Test

    public void test_is_not_weekend_and_between_range() {
        CigarParty cp = new CigarParty();
        int input = 40;
        boolean input1 = false;

        boolean output = cp.haveParty(input, input1);
        Assert.assertTrue(output);

    }

}
