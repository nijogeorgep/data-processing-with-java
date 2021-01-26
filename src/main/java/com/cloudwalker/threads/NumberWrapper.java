/**
 *
 */
package com.cloudwalker.threads;

/**
 * @author 553243
 *
 */
public class NumberWrapper {

    private Object key = new Object();
    private Long value;

    public NumberWrapper(long l) {
        this.value = l;
    }

    /**
     * @return the value
     */
    public Long getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Long value) {
        this.value = value;
    }


    public Long incrementValue() {
        synchronized (key) {
            return value = value + 1; // read and write happens, get the value increments it and result
            // copied back to value again
        }
    }

}
