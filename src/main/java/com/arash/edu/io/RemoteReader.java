package com.arash.edu.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RemoteReader {

    public InputStream read(String url) {
        try {
            return new URL(url).openStream();
        } catch (IOException e) {
            throw new RuntimeException("Unable to read from url " + url);
        }
    }
}
