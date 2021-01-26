package com.cloudwalker.clone;

/**
 * Copy constructors are special constructors in a class which takes argument for its own class type.
 * So, when you pass an instance of class to copy constructor, then constructor will return a new instance of class
 * with values copied from argument instance. It helps you to clone object with Cloneable interface.
 */
public class PointOne {

    private Integer x;
    private Integer y;

    public PointOne(PointOne point) {
        this.x = point.x;
        this.y = point.y;
    }

    public PointOne(int i, int j) {
        this.x = i;
        this.y = j;
    }

    public PointOne copyPoint(PointOne point) throws CloneNotSupportedException
    {
        if(!(point instanceof Cloneable)) {
            throw new CloneNotSupportedException("Invalid cloning");
        }
        //Can do multiple other things here
        return new PointOne(point.x, point.y);
    }
}
