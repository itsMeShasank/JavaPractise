package com.epam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;

public class Practise {

    static int i=100;
    public static void main(String[] args) throws IOException {

        int value = List.of(1,2,3,4)
                        .stream()
                                .reduce(0,(a,b) -> a+b);
        System.out.println(value);
        System.out.println("Hey");
        Fun1 f = new Fun1();
        f.fun();
        Practise p = new Practise();

        if(p instanceof  Fun1) {
            System.out.println("yupe");
        } else {
            System.out.println("nope");
        }

    }

    public void fun() throws IOException {
        System.out.println(i);
    }

    public static void method(){
        System.out.println("fun");
    }
}

class Fun1 extends Practise {

    private int ten = 10;
    private static String funn = "fun";

    public static void method(int a){}

    @Override
    public void fun() throws IOException{
        int tenVariable = 100;
        final int data = 10000;
        class InnerClass {
           void fun() {
               System.out.println(ten);
               System.out.println(tenVariable);
               System.out.println(funn);
               System.out.println(data);
           }
        }
        InnerClass innerClass = new InnerClass();
        innerClass.fun();
        this.i = 10000;
        System.out.println(this.i);
        //throw new RuntimeException();
    }
    protected void go(){}
}


