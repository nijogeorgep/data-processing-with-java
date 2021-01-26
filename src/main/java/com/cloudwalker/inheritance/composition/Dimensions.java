/**
 *
 */
package com.cloudwalker.inheritance.composition;

/**
 * @author nijogeorgep
 *
 */
public class Dimensions {
    private int width;
    private int height;
    private int depth;

    /**
     * @param width
     * @param height
     * @param depth
     */
    public Dimensions(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }


}
