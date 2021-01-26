/**
 *
 */
package com.cloudwalker.inheritance;

/**
 * @author nijogeorgep
 *
 */
public class Dog extends Animal {

    private int eys;
    private int legs;
    private int teeth;
    private int tail;
    private String coat;


    /**
     * @param name
     * @param height
     * @param weight
     * @param eys
     * @param legs
     * @param teeth
     * @param tail
     * @param coat
     */
    public Dog(String name, int height, int weight, int eys, int legs, int teeth, int tail,
               String coat) {
        super(name, 1, 1, height, weight);
        this.eys = eys;
        this.legs = legs;
        this.teeth = teeth;
        this.tail = tail;
        this.coat = coat;
    }

    protected void bark() {
        System.out.println("Woof");
    }

    private void chew() {
        System.out.println("Dog.chew() called");
    }

    public void walk() {
        System.out.println("Dog.walk() called");
        super.move(5);
    }

    public void run() {
        System.out.println("Dog.run() called");
        move(10);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.cts.java8.inheritance.Animal#eat()
     */
    @Override
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }


    /*
     * (non-Javadoc)
     *
     * @see com.cts.java8.inheritance.Animal#move(int)
     */
    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        movelegs(speed);
        super.move(speed);
    }

    private void movelegs(int speed) {
        System.out.println("Dog.moveLegs() called " + speed);
    }

    /**
     * @return the eys
     */
    public int getEys() {
        return eys;
    }

    /**
     * @param eys the eys to set
     */
    public void setEys(int eys) {
        this.eys = eys;
    }

    /**
     * @return the legs
     */
    public int getLegs() {
        return legs;
    }

    /**
     * @param legs the legs to set
     */
    public void setLegs(int legs) {
        this.legs = legs;
    }

    /**
     * @return the teeth
     */
    public int getTeeth() {
        return teeth;
    }

    /**
     * @param teeth the teeth to set
     */
    public void setTeeth(int teeth) {
        this.teeth = teeth;
    }

    /**
     * @return the tail
     */
    public int getTail() {
        return tail;
    }

    /**
     * @param tail the tail to set
     */
    public void setTail(int tail) {
        this.tail = tail;
    }

    /**
     * @return the coat
     */
    public String getCoat() {
        return coat;
    }

    /**
     * @param coat the coat to set
     */
    public void setCoat(String coat) {
        this.coat = coat;
    }

}
