package com.epam;

public class MyNewThread implements Runnable {

    private String name;

    public MyNewThread(String name) {
        this.name = name;
        Thread thread = new Thread(this);
        thread.start();
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
