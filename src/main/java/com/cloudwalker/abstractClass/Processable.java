/**
 *
 */
package com.cloudwalker.abstractClass;

/**
 * @author nijogeorgep
 *
 */
public interface Processable {
    default void processInParallel() {
        System.out.println("Default parallel");
    }
}
