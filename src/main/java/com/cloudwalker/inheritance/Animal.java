/**
 *
 */
package com.cloudwalker.inheritance;

/**
 * @author nijogeorgep
 *
 */
public class Animal {
    private String name;
    private int brain;
    private int body;
    private int height;
    private int weight;

    /**
     * @param name
     * @param brain
     * @param body
     * @param height
     * @param weight
     */
    public Animal(String name, int brain, int body, int height, int weight) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.height = height;
        this.weight = weight;
    }

    public void eat() {
        System.out.println("Animal.eat() called");
    }

    public void move(int speed) {
        System.out.println("Animal.move() called, Animal is moving at speed " + speed);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the brain
     */
    public int getBrain() {
        return brain;
    }

    /**
     * @param brain the brain to set
     */
    public void setBrain(int brain) {
        this.brain = brain;
    }

    /**
     * @return the body
     */
    public int getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(int body) {
        this.body = body;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

}
