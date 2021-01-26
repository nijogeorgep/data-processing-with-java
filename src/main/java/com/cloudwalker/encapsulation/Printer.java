/**
 *
 */
package com.cloudwalker.encapsulation;

/**
 * @author nijogeorgep
 *
 */
public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    /**
     * @param tonerLevel
     * @param pagesPrinted
     * @param duplex
     */
    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel > -1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount < 0 && tonerAmount <= 100) {
            if (this.tonerLevel + tonerAmount > 100) {
                return -1;
            }
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;
        } else {
            return -1;
        }
    }

    public int print(int pages) {
        int pagesToPrint = pages;
        if (this.duplex) {
            // pagesToPrint /= 2;
            pagesToPrint = (pages / 2) + (pages % 2);
            System.out.println("Printing in Duplex Mode");
        }
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }

    /**
     * @return the pagesPrinted
     */
    public int getPagesPrinted() {
        return pagesPrinted;
    }


}
