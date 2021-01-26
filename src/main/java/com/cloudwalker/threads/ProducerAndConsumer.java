/**
 *
 */
package com.cloudwalker.threads;

/**
 * @author 553243
 *
 */
public class ProducerAndConsumer {

    private Object lock = new Object();

    private Integer[] buffer = new Integer[100];

    private int count;

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumer pac = new ProducerAndConsumer();

        Runnable runnable1 = () -> pac.produce();
        Runnable runnable2 = () -> pac.consume();

        Thread thread1 = new Thread(runnable1);
        thread1.start();

        Thread thread2 = new Thread(runnable2);
        thread2.start();

        thread1.join();
        thread2.join();

    }

    public void produce() {
        synchronized (lock) {
            while (buffer.length != 100) {

            }
            buffer[count++] = 1;
        }
    }

    public void consume() {
        synchronized (lock) {
            while (buffer.length == 100) {

            }
            buffer[count--] = 0;
        }
    }

}
