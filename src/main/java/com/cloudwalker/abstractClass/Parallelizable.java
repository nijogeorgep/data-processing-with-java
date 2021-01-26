/**
 *
 */
package com.cloudwalker.abstractClass;

/**
 * @author nijogeorgep
 *
 */
public interface Parallelizable {

    static void log(String s) {
        System.out.println(s);
    }

    default void processInParallel() {
        System.out.println("Parallelizable parallel");
    }
}
