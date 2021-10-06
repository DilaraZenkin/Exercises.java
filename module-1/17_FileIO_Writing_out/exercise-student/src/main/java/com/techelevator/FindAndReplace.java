package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        int maxLines;
        String inputFilePath;

        Scanner input = new Scanner(System.in);
        System.out.println("What is the search word?");
        String searchName = input.nextLine();


        System.out.println("What is the replacement word?");
        String replacementWord  = input.nextLine();

        System.out.println("What is the source file?");
        String fileName  = input.nextLine();

        System.out.println("What is the destination file?");
        String destinationFile  = input.nextLine();

        File newSourceFile = new File(fileName);
        File newDestinationFile= new File(destinationFile);

    }
    }


