package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

	/*
	 * Given an array of strings, return a Map<String, Integer> with a key for
	 * each different string, with the value the number of times that string appears
	 * in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * getCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * getCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
	 * getCount([]) → {}
	 * getCount(["c", "b", "a"]) → {"c": 1, "b": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> getCount(String[] words) {
		Map<String, Integer> output = new HashMap<>();
		if(words != null && words.length > 0) {
			for(String word: words) {
				output.put(word, output.getOrDefault(word, 0) + 1);
			}
		}
		return output;
	}

	// TDD:  Test-Driven Development
	// Step 1: Write a test (that fails)
	// Step 2: Write code to make the test pass
	// Step 3: Refactor (if possible)

}