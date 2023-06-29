package com.ext.prep.deadlock;

public class FileConnect implements AutoCloseable{

    public void show(){
        System.out.println("Hello");
    }
    @Override
    public void close() throws Exception {
        System.out.println("I will close my self dont take bother");
    }
}
