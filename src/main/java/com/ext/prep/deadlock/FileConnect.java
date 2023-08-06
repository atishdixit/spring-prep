package com.ext.prep.deadlock;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileConnect implements AutoCloseable{

    public void show() throws IOException {
        System.out.println("Hello");
    }

    @Override
    public void close() throws IOException {
        System.out.println("I will close my self dont take bother");
    }
}
