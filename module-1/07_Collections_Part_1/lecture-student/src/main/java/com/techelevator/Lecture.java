package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		String[] insts = new String[3];
		insts[0] = "Tom";
		insts[1] = "Tom";
		insts[2] = "Walt";
		System.out.println(insts);

		List<String> instructors = new ArrayList<String>();

		// Wrapper classes

		int v = 5;
		Integer ii = 1;
		ii = v;

		// Boxing: int -> Integer
		// Unboxing: Integer -> int
		// Autoboxing / Autounboxing

		List<Integer> fibList = new ArrayList<Integer>();
		List<Double> averages = new ArrayList<Double>();
		List<Character> letters = new ArrayList<Character>();
		

		int lagA = 0;
		int lagB = 1;
		int limit = 17;
		for (int current = lagA + lagB; current < limit; current = lagA + lagB) {
			fibList.add(current);
			lagA = lagB;
			lagB = current;
		}



		instructors.add("Tom");
		instructors.add("Tom");
		instructors.add("Walt");
		instructors.add("Beth");
		System.out.println(instructors);


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// Array!
		System.out.println("ARRAY:");
		for (int i = 0; i < insts.length; i++) {
			System.out.println(insts[i]);
		}

		// List!
		System.out.println("LIST:");
		for (int i = 0; i < instructors.size(); i++) {
			System.out.println(instructors.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		// 0     1    2     3
		// Tom, Tom, Walt, Beth
		instructors.add(1, "Andrew");

		for (int i = 0; i < instructors.size(); i++) {

			System.out.print("Index " + i + ": ");
			System.out.println(instructors.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		instructors.remove(2);
		for (int i = 0; i < instructors.size(); i++) {
			System.out.print("Index " + i + ": ");
			System.out.println(instructors.get(i));
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean foundBeth = instructors.contains("Beth");
		if (foundBeth) {
			System.out.println("Beth's here!");
		} else {
			System.out.println("Beth is gone! :(");
		}



		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		 //            0123456789
		String lang = "JavaScript";
		lang.indexOf("JAVA"); // -1

		int andyIndex = instructors.indexOf("Jennifer");
		System.out.println(andyIndex);


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] instructorsAsArray = instructors.toArray(new String[0]);
		instructorsAsArray[2] = "Jennifer";


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(instructors);
		for (int i = 0; i < instructors.size(); i++) {
			System.out.print("Index " + i + ": ");
			System.out.println(instructors.get(i));
		}



		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");


		Collections.reverse(instructors);
		for (int i = 0; i < instructors.size(); i++) {
			System.out.print("Index " + i + ": ");
			System.out.println(instructors.get(i));
		}

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		// foreach
		//        instructor   in  instructors
		System.out.println("===========\nLIST:");
		for (String instructor : instructors) {
			System.out.println(instructor);
		}

		System.out.println("===========\nARRAY:");
		int myOwnIndex = 0;
		for (String inst : insts) {
			System.out.print(myOwnIndex + ": ");
			System.out.println(inst);
			myOwnIndex++;
		}

		System.exit(0);

	}
}
