/**
 *
 */
package com.cloudwalker.InnerClasses;

/**
 * @author nijogeorgep
 *
 */
public class MainGearBox {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GearBox jeepX = new GearBox(8);
        // GearBox.Gear first = jeepX.new Gear(1, 1.0);

        // Wrong inner class object creations->
        // GearBox.Gear second = new GearBox.Gear(2, 2.0);
        // GearBox.Gear third = new jeepX.Gear(3,3.0);

        /*
         * jeepX.addGear(1, 5.3); jeepX.addGear(2, 10.6); jeepX.addGear(3, 20.12); jeepX.addGear(4,
         * 40.24); jeepX.addGear(5, 80.48); jeepX.addGear(6, 160.96);
         */
        jeepX.operateClutch(true);
        jeepX.changeGear(1);
        jeepX.operateClutch(false);

        System.out.println(jeepX.wheelSpeed(1000));

        jeepX.changeGear(2);

        System.out.println(jeepX.wheelSpeed(3000));

        jeepX.operateClutch(true);
        jeepX.changeGear(3);
        jeepX.operateClutch(false);

        System.out.println(jeepX.wheelSpeed(6000));
    }

}
