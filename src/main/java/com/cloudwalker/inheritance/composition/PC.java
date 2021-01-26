/**
 *
 */
package com.cloudwalker.inheritance.composition;

/**
 * @author nijogeorgep
 *
 */
public class PC {
    private Cabinet cabinet;
    private Motherboard motherboard;
    private Monitor monitor;

    /**
     * @param cabinet
     * @param motherboard
     * @param monitor
     */
    public PC(Cabinet cabinet, Motherboard motherboard, Monitor monitor) {
        this.cabinet = cabinet;
        this.motherboard = motherboard;
        this.monitor = monitor;
    }

    public void powerUp() {
        cabinet.pressPowerButton();
        motherboard.loadProgram("Windows 10");
        drawLogo();
    }

    private void drawLogo() {
        // Fancy Graphics
        monitor.drawPixelAt(200, 500, "RED");
    }


}
