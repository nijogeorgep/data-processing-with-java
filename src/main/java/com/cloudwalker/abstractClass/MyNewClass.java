/**
 *
 */
package com.cloudwalker.abstractClass;

/**
 * @author nijogeorgep
 *
 */
public class MyNewClass extends MyAbstarctClass {

    /*
     * (non-Javadoc)
     *
     * @see com.cts.java8.abstractClass.MyAbstarctClass#getNames()
     */
    @Override
    public void getNames() {
        System.out.println("getNames()");

    }

    @Override
    public int getNumber() {
        System.out.println("getNumber()");
        return 0;
    }

    @Override
    public int getSum() {
        System.out.println("getSum()");
        return 0;
    }

}
