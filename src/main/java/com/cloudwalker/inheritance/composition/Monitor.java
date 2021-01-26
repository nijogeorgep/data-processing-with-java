/**
 *
 */
package com.cloudwalker.inheritance.composition;

/**
 * @author nijogeorgep
 *
 */
public class Monitor {
    private String model;
    private String manufacturer;
    private int size;
    // Composition- Monitor HAS-A Resolution
    private Resolution resolution;

    /**
     * @param model
     * @param manufacturer
     * @param size
     * @param resolution
     */
    public Monitor(String model, String manufacturer, int size, Resolution resolution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.resolution = resolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println("Drawing pixel at " + x + " , " + y + " in color " + color);
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the resolution
     */
    public Resolution getResolution() {
        return resolution;
    }


}
