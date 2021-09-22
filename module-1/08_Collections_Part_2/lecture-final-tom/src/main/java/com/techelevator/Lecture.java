package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Create a new / empty Map:
		//    key     value
		// Map<Integer, String> zipToCity = new LinkedHashMap<Integer, String>(); // order of insertion
		// Map<Integer, String> zipToCity = new TreeMap<Integer, String>(); // keep KEYS sorted
		Map<Integer, String> zipToCity = new HashMap<Integer, String>();  // WHO KNOWS, but it's fast

		zipToCity.put(15222, "Dahntahn");
		zipToCity.put(15203, "Souside");
		zipToCity.put(15201, "Hipsters");
		zipToCity.put(15233, "Norside");

		System.out.println(zipToCity.size());

		//  Get takes in a Key, and returns a Value!
		String area = zipToCity.get(15222);
		System.out.println(area);

		// Iterate through all of the KEYS
		for (Integer zip : zipToCity.keySet()) {

			// Use the KEY to get the VALUE
			String neighborhood = zipToCity.get(zip);

			// Print aht the KEY and its corresponding VALUE
			System.out.println(zip + " is the zip code for: " + neighborhood);
		}

		System.out.println("\n\nUPDATED:");
		zipToCity.put(15201, "Larrytahn");
		for (Integer zip : zipToCity.keySet()) {
			System.out.println(zip + " is the zip code for: " + zipToCity.get(zip));
		}


		System.out.println("================================");
		System.out.println("================================");

		if(zipToCity.containsKey(90210)) {
			System.out.println(zipToCity.get(90210) + " rolling like a celebrity");
		} else {
			System.out.println("Beverly Hills doesn't exist!");
		}

//		String example = zipToCity.get(90210);
//		if (example == null) {
//			System.out.println("Beverly Hills doesn't exist!");
//		}

		System.out.println("####################");
		System.out.println("        SET");
		System.out.println("####################");
		System.out.println();

		// SET: unordered list -> NO DUPLICATES ALLOWED
		Set<String> instructors = new HashSet<String>();
		// size : 0

		instructors.add("Tom");
		// size: 1

		instructors.add("Tom");
		// size: 1

		instructors.add("Walt");
		// size: 2

		instructors.remove("Tom");
		// size: 1

		instructors.contains("Tom"); // false


		for (String instructor : instructors) {
			System.out.println(instructor + " works at TE PGH");
		}



		Map<String, String> example = new HashMap<>();
		example.put("Boot Camp", "Tech Elevator");
		String value = example.get("boot camp");




		System.exit(0);

		System.out.println("####################");
		System.out.println("        STACK");
		System.out.println("####################");
		System.out.println();

		Stack<String> browserHistory = new Stack<String>();
		browserHistory.push("www.techelevator.com");
		browserHistory.push("www.techelevator.com/pittsburgh");
		browserHistory.push("www.google.com");
		browserHistory.push("www.reddit.com");

		String previousPage = "";

		// Processing a stack
		while(browserHistory.size() > 0) {
			System.out.println("Number of pages visited: " + browserHistory.size());
			previousPage = browserHistory.pop();
			System.out.println(previousPage);
		}

		System.exit(0);


		System.out.println("####################");
		System.out.println("        QUEUE");
		System.out.println("####################");
		System.out.println();

		Queue<String> todos = new LinkedList<String>();
		todos.offer("Wash the dishes");
		todos.offer("Sweep the leg");
		todos.offer("Sweep the floor");
		todos.offer("Wake up");
		todos.offer("Grab a brush");

		String nextTodo = "";

		// Processing things in a Queue
		while(todos.size() > 0) {
			System.out.println("Current size: " + todos.size());
			nextTodo = todos.poll();
			System.out.println("Completed: " + nextTodo);
			System.out.println("Current size: " + todos.size());
		}

		System.out.println("Finished all my To-Dos!");

	}

}
