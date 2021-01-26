/**
 *
 */
package com.cloudwalker.inheritance.composition;

/**
 * @author nijogeorgep
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Cabinet theCabinet = new Cabinet("220B", "Dell", "240V", new Dimensions(20, 20, 5));

        Monitor theMonitor = new Monitor("27 Inch HD", "LG", 27, new Resolution(1080, 1377));

        Motherboard theMotherboard = new Motherboard("TFR347", "intel", 4, 4, "v.2.04");

        PC thePc = new PC(theCabinet, theMotherboard, theMonitor);
        thePc.powerUp();
    }

}
