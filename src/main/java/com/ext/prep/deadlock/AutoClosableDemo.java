package com.ext.prep.deadlock;

import com.ext.prep.beans.Employee;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AutoClosableDemo {
    static  FileConnect fileConnect = new FileConnect();
//-----------------------------------------------------
    public static void main(String[] args)  {
        serve();
    }

//------------------------------------------
    //Service
    static void serve(){
        try {
            readeFileData();
            addNewDataInfile();
            deleteDataFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //----------------------------------------------------
    //Access
    public static void readeFileData() throws Exception {
        fileConnect.show();

    }

    public static void addNewDataInfile() throws Exception{
        fileConnect.show();

    }

    public static void deleteDataFromFile() throws Exception{
        fileConnect.show();

    }
}
