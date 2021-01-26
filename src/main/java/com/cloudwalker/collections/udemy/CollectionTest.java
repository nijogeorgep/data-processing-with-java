/**
 *
 */
package com.cloudwalker.collections.udemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author nijogeorgep
 *
 */
public class CollectionTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Theatre newTheatre = new Theatre("Ganga", 10, 20);

        // newTheatre.getSeats();

        if (newTheatre.reserveSeat("D12")) {
            System.out.println("Proceed to Payment");
        } else {
            System.out.println("Sorry, Seat is taken");
        }

        if (newTheatre.reserveSeat("F13")) {
            System.out.println("Proceed to Payment");
        } else {
            System.out.println("Sorry, Seat is taken");
        }

        if (newTheatre.reserveSeat("F13")) {
            System.out.println("Proceed to Payment");
        } else {
            System.out.println("Sorry, Seat is taken");
        }

        List<Seat> seatCopy = new ArrayList<>(newTheatre.getSeats());
        Collections.reverse(seatCopy);
        printList(seatCopy);

        List<Seat> priceSeats = new ArrayList<>(newTheatre.getSeats());
        priceSeats.add(new Seat("A00", 18.00));
        priceSeats.add(new Seat("B00", 18.00));
        Collections.sort(priceSeats, newTheatre.PRICE_ORDER);
        printList(priceSeats);

        /*
         * seatCopy.get(1).reserve(); if(newTheatre.reserveSeat("D12")) {
         * System.out.println("Please pay for A02"); } else {
         * System.out.println("Seat already reserved"); }
         */



        /*
         * Collections.reverse(seatCopy); //Collections.shuffle(seatCopy);
         * System.out.println("printing seatCopy"); printList(seatCopy);
         * System.out.println("Printing newTheatre.seats"); printList(newTheatre.seats);
         *
         *
         * Seat minSeat = Collections.min(seatCopy); Seat maxSeat = Collections.max(seatCopy);
         * System.out.println("Min Sear Number "+ minSeat.getSeatNumber());
         * System.out.println("Max Sear Number "+ maxSeat.getSeatNumber());
         *
         * Collections.shuffle(seatCopy); System.out.println("printing shuffled seatCopy");
         * printList(seatCopy); sortedList(seatCopy); System.out.println("printing sorted seatCopy");
         * printList(seatCopy);
         *
         * List<Seat> newList = new ArrayList<>(newTheatre.seats.size()); Collections.copy(newList,
         * newTheatre.seats);
         */
    }

    private static void printList(List<Seat> seatCopy) {
        for (Seat seat : seatCopy) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("==========================================================");
    }


    /*
     * public static void sortedList(List<? extends Seat> list) { for (int i = 0; i < list.size() - 1;
     * i++) { for (int j = i + 1; j < list.size(); j++) { if (list.get(i).compareTo(list.get(j)) > 0)
     * { Collections.swap(list, i, j); } } } }
     */
}
