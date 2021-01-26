/**
 *
 */
package com.cloudwalker.abstractClass;

/**
 * @author 553243
 *
 */
public class Task implements Processable, Parallelizable {
    public static void main(String args[]) {
        Task t = new Task();
        t.processInParallel();

        // Interface static methods are not inherited, you must prefix the method with the interface
        // name:
        Parallelizable.log("Static Log method form interface");
    }

    @Override
    public void processInParallel() {
        // TODO Auto-generated method stub
        Processable.super.processInParallel();
    }
}
