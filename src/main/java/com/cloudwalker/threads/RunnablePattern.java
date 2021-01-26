package com.cloudwalker.threads;
/**
 *
 */

/**
 * @author 553243
 *
 */
public class RunnablePattern {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("I'm running in " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);
        thread.setName("MyThread");

        thread.start(); // -> I'm running in MyThread
        //thread.run(); //No No -> I'm running in main
    }

}
