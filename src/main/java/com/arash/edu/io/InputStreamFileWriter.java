package com.arash.edu.io;

import java.io.*;

public class InputStreamFileWriter {

    private static final String RESOURCES_FOLDER_PATH = "src/main/resources";

    private final String filename;
    private final FileWriter fw;

    public InputStreamFileWriter(String filename, boolean append) {
        this.filename = String.format("%s%s%s", RESOURCES_FOLDER_PATH, File.separator, filename);
        try {
            this.fw = new FileWriter(this.filename, append);
        } catch (IOException e) {
            throw new RuntimeException("Unable to create FileWriter, " + e);
        }
    }

    public void write(InputStream inputStream) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                count++;
                fw.append(line);
                fw.append("\n");
                line = reader.readLine();
            }
            System.out.println("Wrote " + count + " lines to '" + filename + "'");
        } catch (IOException e) {
            System.err.println("Unable to write input stream, " + e.getClass() + ", " + e.getMessage());
        }
    }
}
