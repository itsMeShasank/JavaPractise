package com.epam;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new MyThread("1st Thread");
        new MyThread("2nd Thread");
        new MyThread("3rd Thread");

    }
}
