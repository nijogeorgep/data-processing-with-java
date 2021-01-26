/**
 *
 */
package com.cloudwalker.enums;

/**
 * @author nijogeorgep
 *
 */
public enum Volume implements EnumInterface {
    HIGH(100) {
        public String printDescription() {
            return "HIGH VOLUME";
        }
    },
    MEDIUM(50) {
        public String printDescription() {
            return "MEDIUM VOLUME";
        }
    },
    LOW(10) {
        public String printDescription() {
            return "LOW VOLUME";
        }
    };

    private int value;

    /**
     * @param value
     */
    private Volume(int value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    // public abstract String printDescription();

}
