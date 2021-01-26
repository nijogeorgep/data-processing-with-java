/**
 * If the local class is declared inside a method, it can access the variables and parameters of the
 * method ONLY if they are declared final or are effectively final.
 */
package com.cloudwalker.InnerClasses;

/**
 * @author nijogeorgep
 */
public class LocalClassDemo {
    private String serialNumber = "878Y68Y68656GR8";

    void process(int n) {
        // Local Class
        class Processor {
            public Processor() {
                System.out.println("Serial Number is " + serialNumber + " and " + n);
            }
        }
        // Local variable n defined in an enclosing scope must be final or effectively final
        // n=4;
    }
}
