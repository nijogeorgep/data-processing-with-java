/**
 *
 */
package com.cloudwalker.InnerClasses;

import java.util.ArrayList;

/**
 * @author nijogeorgep
 *
 */
public class GearBox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public GearBox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        for (int i = 0; i < maxGears; i++) {
            addGear(i, i * 5.3);
        }
    }

    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }

    public void addGear(int number, double ratio) {
        if ((number > 0) && (number <= maxGears)) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGear) {
        if ((newGear >= 0) && (newGear < this.gears.size()) && this.clutchIsIn) {
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " Selected!");
        } else {
            System.out.println("Grind!!!");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if (clutchIsIn) {
            System.out.println("Screaaam!!!!");
            return 0.0;
        }
        return revs * gears.get(currentGear).getGearRatio();
    }

    public class Gear {

        private int gearNumber;
        private double gearRatio;

        public Gear(int gearNumber, double gearRatio) {
            this.gearNumber = gearNumber;
            this.gearRatio = gearRatio;
        }

        public double driveSpeed(int revs) {
            return revs * (this.gearRatio);
        }

        public int getGearNumber() {
            return gearNumber;
        }

        public double getGearRatio() {
            return gearRatio;
        }
    }

}
