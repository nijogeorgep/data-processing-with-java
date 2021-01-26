/**
 *
 */
package com.cloudwalker.inheritance;

/**
 * @author nijogeorgep
 *
 */
public class Huski extends Dog {

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
    public Huski(String name, int height, int weight, int eys, int legs, int teeth, int tail,
                 String coat) {
        super(name, height, weight, eys, legs, teeth, tail, coat);
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     *
     * @see com.cts.java8.inheritance.Dog#bark()
     */
    @Override
    protected void bark() {
        // TODO Auto-generated method stub
        super.bark();
        System.out.println("Woof Woof Woof");
    }


}
