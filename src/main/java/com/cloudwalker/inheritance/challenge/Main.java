/**
 *
 */
package com.cloudwalker.inheritance.challenge;

/**
 * @author nijogeorgep
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Compass compass = new Compass(36);
        compass.steer(45);
        compass.accelerate(30);
        compass.accelerate(20);

    }

}
