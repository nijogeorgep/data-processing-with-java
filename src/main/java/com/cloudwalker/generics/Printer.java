/**
 *
 */
package com.cloudwalker.generics;

/**
 * @author nijogeorgep
 *
 */
public class Printer<T extends String> {

    public void print(T t) {
        System.out.println(t.toUpperCase());
    }
}
