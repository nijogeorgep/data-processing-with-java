/**
 *
 */
package com.cloudwalker.interfaces;

/**
 * @author nijogeorgep
 *
 */
public class FunctionlInterfaceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * new Thread(new Runnable() {
         *
         * @Override public void run() { System.out.println("New Thread Created"); } }).start();
         */

        new Thread(() -> {
            System.out.println("New Thread Created");
        }).start();
    }

}
