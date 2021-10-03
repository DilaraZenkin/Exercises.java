package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;

public class WordCountTest {

    @Test
    public void test_words_is_random0() {

        WordCount wc = new WordCount();
        String[] input = {"a", "b", "a", "c", "b"};
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("a", 2);
        testMap.put("b", 2);
        testMap.put("c", 1);

        Map<String, Integer> methodTotal = wc.getCount(input);

        Assert.assertEquals(testMap, methodTotal);
        // String [] input = {"a", "b", "a", "c", "b"};
        // Map<wc> input1 = {("a": 2) , ("b" : 2) , ("c" : 1 ) };


    }

    @Test
    public void test_words_is_empty() {

        WordCount wc = new WordCount();
        String[] input = {};
        Map<String, Integer> testMap = new HashMap<>();


        Map<String, Integer> methodTotal = wc.getCount(input);

        Assert.assertEquals(testMap, methodTotal);


    }

    @Test
    public void test_words_is_random1() {

        WordCount wc = new WordCount();
        String[] input = {"ba", "black", "ba", "sheep"};
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("ba", 2);
        testMap.put("black", 1);
        testMap.put("sheep", 1);

        Map<String, Integer> methodTotal = wc.getCount(input);

        Assert.assertEquals(testMap, methodTotal);
    }

    @Test
    public void test_words_is_random2() {

        WordCount wc = new WordCount();
        String[] input = {"apple", "banana", "apple", "circle", "banana", "fruit", "apple", "dill", "apple"};
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("apple", 4);
        testMap.put("banana", 2);
        testMap.put("circle", 1);
        testMap.put("fruit", 1);
        testMap.put("dill", 1);

        Map<String, Integer> methodTotal = wc.getCount(input);

        Assert.assertEquals(testMap, methodTotal);
    }

    @Test
    public void test_words_is_null() {

        WordCount wc = new WordCount();
        String[] input = null;
        Map<String, Integer> testMap = new HashMap<>();
        //testMap.put(input);
        //testMap.put("b", 2);
        //testMap.put("c", 1);

        Map<String, Integer> methodTotal = wc.getCount(input);

        Assert.assertEquals(testMap, methodTotal);
    }

    @Test
    public void test_words_are_same() {

        WordCount wc = new WordCount();
        String[] input = {"ask", "ask", "ask", "ask", "ask"};
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("ask", 5);
        //testMap.put("b", 2);
        //testMap.put("c", 1);

        Map<String, Integer> methodTotal = wc.getCount(input);

        Assert.assertEquals(testMap, methodTotal);
    }
}
