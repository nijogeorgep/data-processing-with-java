/**
 *
 */
package com.cloudwalker.inheritance;

/**
 * @author nijogeorgep
 *
 */
public class Fish extends Animal {

    private int eys;
    private int fins;
    private int gills;

    /**
     * @param name
     * @param brain
     * @param body
     * @param height
     * @param weight
     * @param eys
     * @param fins
     * @param gills
     */
    public Fish(String name, int height, int weight, int eys, int fins, int gills) {
        super(name, 1, 1, height, weight);
        this.eys = eys;
        this.fins = fins;
        this.gills = gills;
    }

    private void rest() {
        System.out.println("Fish.swim() called");
    }

    private void moveMuscles() {
        System.out.println("Fish.moveMuscles() called");
    }

    private void moveBackFins() {
        System.out.println("Fish.moveBackFins() called");
    }

    public void swim(int speed) {
        moveMuscles();
        moveBackFins();
        super.move(speed);
    }
}
