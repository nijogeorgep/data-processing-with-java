/**
 *
 */
package com.cloudwalker.inheritance.composition;

/**
 * @author nijogeorgep
 *
 */
public class Car extends Vehicle {
    private int doors;
    private int engineCapacity;

    /**
     * @param name
     * @param doors
     * @param engineCapacity
     */
    public Car(String name, int doors, int engineCapacity) {
        super(name);
        this.doors = doors;
        this.engineCapacity = engineCapacity;
    }


}
