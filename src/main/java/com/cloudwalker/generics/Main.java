/**
 *
 */
package com.cloudwalker.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nijogeorgep
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Holder<String> stringHolder = new Holder<String>("NIJO");
        Holder<Integer> integerHolder = new Holder<Integer>(100);

        stringHolder.printObject();

        integerHolder.printObject();

        Holder.printObject("GEORGE");
        // OR
        Holder.<String>printObject("GEORGE");

        Holder.printObject(2000);
        // OR
        Holder.<Integer>printObject(2000);


        // List<Object> list = new ArrayList<String>();
        List<? extends Object> list = new ArrayList<String>();

        Printer<String> printerList = new Printer<>();

        // Printer<Byte> printerByteList = new Printer<>();

        shout(30);
        shout("Hellooo");

    }

    public static <T> void shout (T thingToShout){
        System.out.println(thingToShout+"!!!!");
    }

}
