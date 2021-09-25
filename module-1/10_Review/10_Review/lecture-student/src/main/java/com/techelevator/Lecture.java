package com.techelevator;

import java.time.Period;
import java.util.HashSet;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		Set<Integer> uniqueNumbers = new HashSet<>();

		Set<String> names = new HashSet<>();

		uniqueNumbers.add(1);
		uniqueNumbers.add(10);
		uniqueNumbers.add(10);
		uniqueNumbers.add(100);

		names.add("Walt");
		names.add("Tom");
		names.add("Tom");

		Person walt = new Person ("Walt", "last name");
		Person tom = new Person ("tom", "last name2");

		walt.print();

		tom.print();

		printHelloWorld();


		// {1, 10, 100}
		// {"Walt", "Tom"}

		// {"public", "import", "class", "void" }

		// [ "Walt", "Tom", "Nick", "Howie", "Zach" ]

	}

}
