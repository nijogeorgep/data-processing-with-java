/**
 *
 */
package com.cloudwalker.generics;

/**
 * @author nijogeorgep
 *
 */
public class Holder<T> {

    private T t;

    /**
     * @param t
     */
    public Holder(T t) {
        this.t = t;
    }

    public static <T> void printObject(T t) {
        System.out.println("***" + t + "***");
    }

    /**
     * @return the t
     */
    public T getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(T t) {
        this.t = t;
    }

    public void printObject() {
        System.out.println("***" + t + "***");
    }

}
