package com.manmohan.TestNgSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TryCatch {

    public static void main(String arg[]) throws FileNotFoundException {




        throwing();


    }

    public static void throwing() throws FileNotFoundException {

       // bfbfbdfsdfbbjfsdf

               // bjksdbfdddj

        //InputStream inputStream = null;
       // File file = new File(classLoader.getResource("fileTest.txt").getFile());
        //inputStream = new FileInputStream(file);


        try{
            System.out.println("hello");


        } catch(Exception e){
            e.getStackTrace();
            System.out.println("hello2");
        }

        try{
            System.out.println("hello");

            System.out.println("hello2");
        } catch(Exception e){
            e.getStackTrace();
        }

        try{
            System.out.println("hello");

            System.out.println("hello2");
        } catch(Exception e){
            e.getStackTrace();
        }

    }

}
