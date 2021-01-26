/**
 *
 */
package com.cloudwalker.inheritance.composition;

/**
 * @author nijogeorgep
 *
 */
public class Cabinet {
    private String model;
    private String manufacturer;
    private String powerSupply;
    private Dimensions dimensions;

    /**
     * @param model
     * @param manufacturer
     * @param powerSupply
     * @param dimensionsl
     */
    public Cabinet(String model, String manufacturer, String powerSupply, Dimensions dimensionsl) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.powerSupply = powerSupply;
        this.dimensions = dimensionsl;
    }

    public void pressPowerButton() {
        System.out.println("Power Button Pressed");
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
     * @return the powerSupply
     */
    public String getPowerSupply() {
        return powerSupply;
    }

    /**
     * @return the dimensions
     */
    public Dimensions getDimensions() {
        return dimensions;
    }


}
