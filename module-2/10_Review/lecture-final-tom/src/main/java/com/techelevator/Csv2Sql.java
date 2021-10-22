package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class Csv2Sql {

    public static void main(String[] args) {
        // Read in the CSV file
        final String fileName = "sample_csv.csv";
        final String outputFileName = "sample.sql";

        try (PrintWriter outputFile = new PrintWriter(outputFileName); Scanner fileStreamer = new Scanner(new File(fileName));) {

            for (int lineCount = 1; fileStreamer.hasNext(); lineCount++) {
                String sql = "";
                String currentLine = fileStreamer.nextLine();
                //  Also, skip the headers
                if (lineCount != 1) {
                    // For each line of data, generate a SQL statement
                    String[] row = currentLine.split(",");

                    sql += "INSERT INTO attendance " +
                                 "VALUES (DEFAULT, ";

                    for (int i = 0; i < row.length; i++) {
                        sql += row[i];
                        if (i != row.length - 1) {
                            sql += ", ";
                        }
                    }
                    sql += ");";
                }
                if (!sql.isEmpty()) {
                    outputFile.println(sql);
                }
            }

        } catch (IOException e) {
            System.out.println("File problems...");
            System.out.println(e.getMessage());
        }


    }
}
