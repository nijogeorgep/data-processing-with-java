/**
 *
 */
package com.cloudwalker.inheritance;

/**
 * @author nijogeorgep
 *
 */
public class Person {

    private static String NAME;

    /**
     * Sets NAME
     */
    public Person(String name) {
        Person.NAME = name;
    }

    public void printName() {
        System.out.println("MyName is " + NAME);
    }

}
