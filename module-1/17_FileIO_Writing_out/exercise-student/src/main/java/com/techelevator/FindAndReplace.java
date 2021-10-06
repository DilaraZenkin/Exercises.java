package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FindAndReplace {
        public static void main(String[] args) {

                // create scanner object
                Scanner input = new Scanner(System.in);
                System.out.println("What is the search word?");
                String searchName = input.nextLine();

                System.out.println("What is the replacement word?");
                String replacementWord = input.nextLine();

                System.out.println("What is the source file?");
                String fileName = input.nextLine();

                System.out.println("What is the destination file?");
                String destinationFile = input.nextLine();

                try {
                        // create FileWriter object
                        FileWriter fileOut = new FileWriter(destinationFile);
                        // create BufferedWriter object
                        BufferedWriter bw = new BufferedWriter(fileOut);
                        // create scanner object
                        Scanner inputScanner = new Scanner(new File(fileName));

                        // check next line present or not
                        while (inputScanner.hasNextLine()) {
                                // read each line
                                String data = inputScanner.nextLine();

// write data to the destination file
                                bw.write(data.replace(searchName, replacementWord));
                                bw.newLine();
                        }
                        bw.flush();
                        bw.close();
                        inputScanner.close();
                        System.out.println("Given word replaced successfully!");
                } catch (IOException e) {
                        System.out.println(e.getMessage());
                }
        }
}

//    public static void main(String[] args) {
//        String getText;
//        String putText;
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("What is the search word?");
//        String searchName = input.nextLine();
//
//
//        System.out.println("What is the replacement word?");
//        String replacementWord  = input.nextLine();
//
//        System.out.println("What is the source file?");
//        String fileName  = input.nextLine();
//
//        System.out.println("What is the destination file?");
//        String destinationFile  = input.nextLine();
//
//        File newSourceFile = new File(fileName);
//        File newDestinationFile= new File(destinationFile);
//
//        try{
//            Scanner inputScanner = new Scanner(newSourceFile);
//            PrintWriter writer = new PrintWriter(newDestinationFile);
//
//            while(inputScanner.hasNextLine()){
//                String currentLine = inputScanner.nextLine();

//                bw.write(data.replace(searchName, replacementWord));
//                                bw.newLine();
//}
//
//
//
//                writer.println(currentLine);
//            }
//
//            writer.flush();
//            writer.close();
//        }
//         catch (FileNotFoundException e) {
//            System.out.println("File not found!");
//
//        }
//    }
//    }










