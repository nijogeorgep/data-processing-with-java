/**
 *
 */
package com.cloudwalker.enums;

/**
 * @author nijogeorgep
 *
 */
public class EnumsMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Volume.HIGH);
        System.out.println(Volume.HIGH.name());

        for (Volume volume : Volume.values()) {
            System.out.print(volume.name() + ",");
        }

        Volume volLevel = Volume.valueOf("LOW");
        System.out.println("\n" + volLevel);

        System.out.println(Volume.HIGH.ordinal());
        System.out.println(Volume.MEDIUM.ordinal());
        System.out.println(Volume.LOW.ordinal());

        System.out.print(Volume.HIGH.printDescription());
    }

}
