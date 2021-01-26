/**
 *
 */
package com.cloudwalker.InnerClasses;

import com.cloudwalker.InnerClasses.Computer.HardDrive;

/**
 * @author nijogeorgep
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LocalClassDemo classDemo = new LocalClassDemo();
        classDemo.process(0);

        // InnerClass

        Computer computer = new Computer();

        HardDrive drive = computer.new HardDrive();

        drive.printSN("49uy23j82d49023");
    }
}
