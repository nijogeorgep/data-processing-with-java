/**
 *
 */
package com.cloudwalker.encapsulation;

/**
 * @author nijogeorgep
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Printer printer = new Printer(50, true);
        System.out.println("initial page printed : " + printer.getPagesPrinted());
        System.out.println("Pages Printed was " + printer.print(5));
        System.out.println("Pages Printed was " + printer.print(8));
        System.out.println(printer.addToner(10));

    }
}
