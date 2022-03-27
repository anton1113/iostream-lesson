package com.arash.edu.io;

import java.io.InputStream;

public class Application {

    private static final RemoteReader REMOTE_READER = new RemoteReader();

    private static final String FILENAME = "protocol.txt";
    private static final String TEXT_URL = "https://www.rfc-editor.org/rfc/rfc2616.txt";

    public static void main(String[] args) {
        printHttpProtocol();
    }

    private static void printHttpProtocol() {
        InputStream textInputStream = REMOTE_READER.read(TEXT_URL);
        InputStreamPrinter inputStreamPrinter = new InputStreamPrinter();
        inputStreamPrinter.printBuffered(textInputStream);
    }

    private static void writeToFileHttpProtocol() {
        InputStream textInputStream = REMOTE_READER.read(TEXT_URL);
        InputStreamFileWriter inputStreamFileWriter = new InputStreamFileWriter(FILENAME, false);
        inputStreamFileWriter.write(textInputStream);
    }
}
