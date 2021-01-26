/**
 *
 */
package com.cloudwalker.threads;

/**
 * @author 553243
 *
 */
public class RunDeadLock {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock = new DeadLock();

        Runnable runnable1 = () -> deadLock.a();
        Runnable runnable2 = () -> deadLock.b();

        Thread thread1 = new Thread(runnable1);
        thread1.start();

        Thread thread2 = new Thread(runnable2);
        thread2.start();

        // System.out.println("Thread 1 " + thread1.getState());
        // System.out.println("Thread 2 " + thread2.getState());
        // thread1.interrupt();

        // if(thread1.isInterrupted()) {
        // thread2.join();
        // }
        thread1.join();
        thread2.join();

        System.out.println("Thread 1 " + thread1.getState());
        System.out.println("Thread 2 " + thread2.getState());
        /*
         * A thread state. A thread can be in one of the following states:
         *
         * �NEW A thread that has not
         * yet started is in this state.
         * �RUNNABLE A thread executing in the Java virtual machine is in
         * this state.
         * �BLOCKED A thread that is blocked waiting for a monitor lock is in this state.
         * �WAITING A thread that is waiting indefinitely for another thread to perform a particular
         * action is in this state.
         * �TIMED_WAITING A thread that is waiting for another thread to
         * perform an action for up to a specified waiting time is in this state.
         * �TERMINATED A thread
         * that has exited is in this state.
         *
         * A thread can be in only one state at a given point in time. These states are virtual machine
         * states which do not reflect any operating system thread states
         *
         */
    }

}
