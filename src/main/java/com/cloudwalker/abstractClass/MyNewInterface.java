/**
 * <p>
 * You can't instantiate an interface directly, it has to be implemented by a class to use it.
 * </p>
 * <p>
 * An interface cannot be marked as final.
 * </p>
 */
package com.cloudwalker.abstractClass;

/**
 * @author nijogeorgep
 * <p>
 * *         <p>
 * You can't instantiate an interface directly, it has to be implemented by a class to use
 * it.
 * </p>
 * <p>
 * An interface cannot be marked as final.
 * </p>
 */
public interface MyNewInterface {
    public int getNumber();

    public int getSum();

    default void processInParallel() {
        System.out.println("Default parallel");
    }
}
