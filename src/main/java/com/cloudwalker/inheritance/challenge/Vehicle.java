/**
 *
 */
package com.cloudwalker.inheritance.challenge;

/**
 * @author nijogeorgep
 *
 */
public class Vehicle {

    private String name;
    private String size;

    private int currentVelocity;
    private int currentDirection;


    /**
     * @param name
     * @param size
     */
    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;
        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction) {
        this.currentDirection = direction;
        System.out.println("Vehicle.steer(): Steering at " + currentDirection + " degrees");
    }

    public void move(int velocity, int direction) {
        currentDirection = direction;
        currentVelocity = velocity;
        System.out.println(
                "Vehicle.move(): Moving at " + currentVelocity + " in direction " + currentDirection);
    }

    public void stop() {
        this.currentVelocity = 0;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @return the currentVelocity
     */
    public int getCurrentVelocity() {
        return currentVelocity;
    }

    /**
     * @return the currentDirection
     */
    public int getCurrentDirection() {
        return currentDirection;
    }


}
