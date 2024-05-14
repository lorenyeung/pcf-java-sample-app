package com.lovepoem.test2;

public class BeanNotTest {
    public String haha() {
        System.out.println("111");
        System.out.println("111");
        System.out.println("111");
        System.out.println("111");
        System.out.println("111");
        System.out.println("111");
        System.out.println("111");
        return "";
    }

    public static void main(String[] args)  {
        System.out.println("this is main");
        while(true) {
            System.out.println("This is an infinite loop. Press Ctrl+C to terminate.");
                    try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                    try {
            // This will always throw an exception
            throw new LoggableException("This is an intentionally thrown exception");
        } catch (LoggableException e) {
            // Handle the exception gracefully
            System.out.println("Exception caught: " + e.getMessage());
        }
        }
    }
}
