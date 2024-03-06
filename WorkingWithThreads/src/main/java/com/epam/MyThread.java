package com.epam;

public class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
        this.start();
    }
    @Override
    public void run() {
        try
        {
            for(int i = 0; i < 5; i++)
            {
                System.out.println("The "+ name + " is running...");
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(name + "Interrupted");
        }
    }
}
