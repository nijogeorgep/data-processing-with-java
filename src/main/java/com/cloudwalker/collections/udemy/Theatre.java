/**
 *
 */
package com.cloudwalker.collections.udemy;

import java.util.*;

/**
 * @author nijogeorgep
 *
 */
public class Theatre {
    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {

        @Override
        public int compare(Seat seat1, Seat seat2) {
            if (seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if (seat1.getPrice() > seat2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        }
    };
    private final String theatreName;
    // private Collection<Seat> seats = new LinkedList<>();

    // HashSet is unordered
    // private Collection<Seat> seats = new HashSet<>();

    // LinkedHashSet is ordered
    // private Collection<Seat> seats = new LinkedHashSet<>();

    // throws ClassCastException - Can't be used in the lower hierarchy
    // private Collection<Seat> seats = new TreeSet<>();
    private List<Seat> seats = new ArrayList<>();

    /**
     * @param theatreName
     */
    public Theatre(String theatreName, int numOfRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numOfRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;

                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 16.00;
                } else if ((row > 'F') || (seatNum < 4 && seatNum > 9)) {
                    price = 8.00;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    /**
     * @return the theatreName
     */
    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        /*
         * int low = 0; int high = seats.size() - 1;
         *
         * while (low <= high) { System.out.print("."); int mid = (low + high) / 2; Seat midVal =
         * seats.get(mid); int cmp = midVal.getSeatNumber().compareTo(seatNumber);
         *
         * if (cmp < 0) { low = mid + 1; } else if (cmp > 0) { high = mid - 1; } else { return
         * seats.get(mid).reserve(); } }
         *
         * System.out.println("There is no seat " + seatNumber); return false;
         */

        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        /*
         * for (Seat seat : seats) { System.out.print("."); if (seat.getSeatNumber().equals(seatNumber))
         * { requestedSeat = seat; break; } }
         *
         * if (requestedSeat == null) { System.out.println("Seat " + seatNumber + " isn't Available");
         * return false; }
         *
         * return requestedSeat.reserve();
         */
    }

    // For Testing
    /*
     * public void getSeats() { for (Seat seat : seats) { System.out.println(seat.getSeatNumber()); }
     * }
     */

    public Collection<Seat> getSeats() {
        return seats;
    }
}
