package com.techelevator.filewriting;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class FileWritingExample {

    public static void main(String[] args) {
        File f = new File("example_output.txt");
        File o = new File("example_output2.txt");

        try (Scanner input = new Scanner(f); PrintWriter pw = new PrintWriter(o)) {
            while(input.hasNextLine()) {
                String line = input.nextLine();
                line = line.replace("appeared", "shows up");
                pw.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error!");
        }

    }

    public static void main2(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a phrase >>> ");
        String input = keyboard.nextLine();
        MapsExample m = new MapsExample();
        Map<String, Integer> outputMap = m.countOccurrences(input);

        File outputFile = new File("example_output.txt");

        // try-with-resources (closeable)
        try (PrintWriter pw = new PrintWriter(new FileWriter(outputFile, true))) {
            int max = -1;
            String mostCommonKey = "";
            for(String key : outputMap.keySet()) {
                int value = outputMap.get(key);

                if(value > max) {
                    max = value;
                    mostCommonKey = key;
                }
            }

            pw.println("The most commonly occurring letter in: \"" + input + "\" is: " + mostCommonKey + "!");
            pw.println("It appeared " + max + " times!");

        } catch (IOException e) {
            System.out.println("Couldn't open the file!");
        }

    }

}
