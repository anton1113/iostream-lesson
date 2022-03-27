package com.arash.edu.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamPrinter {

    public void printRaw(InputStream inputStream) {
        try {
            String text = new String(inputStream.readAllBytes());
            printMemUsage();
            System.out.println(text);
        } catch (IOException e) {
            System.err.println("Unable to print input stream, " + e.getClass() + ", " + e.getMessage());
        }
    }

    public void printBuffered(InputStream inputStream) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            while (line != null) {
                printMemUsage();
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Unable to print input stream, " + e.getClass() + ", " + e.getMessage());
        }
    }

    private void printMemUsage() {
        long memUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("mem usage: " + memUsage);
    }
}
