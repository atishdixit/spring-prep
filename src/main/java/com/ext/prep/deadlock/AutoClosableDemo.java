package com.ext.prep.deadlock;

public class AutoClosableDemo {

    public static void main(String[] args)  {
        try (FileConnect fileConnect = new FileConnect()){
            fileConnect.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
