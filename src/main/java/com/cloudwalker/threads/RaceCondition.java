/**
 *
 */
package com.cloudwalker.threads;

/**
 * @author 553243
 *
 */
public class RaceCondition {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        NumberWrapper wrapper = new NumberWrapper(0L);

        Runnable runnable1 = () -> {
            for (int i = 0; i < 1_000; i++) {
                wrapper.incrementValue();
            }
        };

        /*
         * Thread thread = new Thread(runnable1);
         *
         * thread.start();
         *
         * thread.join();
         */

        Thread[] threads = new Thread[1_000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable1);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("Value is " + wrapper.getValue());
    }

}
