package com.techelevator.scanner;

import java.io.File;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        RTNValidator rtn = new RTNValidator();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter path to RTN file >>> ");
        String rtnFilePath = keyboard.nextLine();

        File rtnFile = new File(rtnFilePath);
        try {
            Scanner fileInput = new Scanner(rtnFile);

            while(fileInput.hasNextLine()) {
                String currentLine = fileInput.nextLine();
                boolean isValid = rtn.checksumIsValid(currentLine);

                System.out.print(currentLine + " is ");
                if(isValid) {
                    System.out.println("VALID!");
                } else {
                    System.out.println("NOT VALID!");
                }
            }
        } catch (Exception e) {
            System.out.println("Couldn't open " + rtnFile.getName());
        }

        System.out.println("Done!");
    }
}
