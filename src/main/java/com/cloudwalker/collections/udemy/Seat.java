/**
 *
 */
package com.cloudwalker.collections.udemy;

/**
 * @author nijogeorgep
 *
 */
public class Seat implements Comparable<Seat> {

    private final String seatNumber;
    private double price;
    private boolean reserved = false;

    public Seat(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }

    /**
     * @return the seatNumber
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    public boolean reserve() {
        if (!this.reserved) {
            this.reserved = true;
            System.out.println("Seat " + seatNumber + " Reserved");
            return true;
        } else {
            return false;
        }
    }

    public boolean cancel() {
        if (this.reserved) {
            this.reserved = false;
            System.out.println("Seat " + seatNumber + " Reservation Cancelled");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Seat seat) {
        return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
    }
}
