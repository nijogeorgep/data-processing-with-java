package com.cloudwalker.clone;

public class PointTwo extends PointOne {

    private Integer z;

    public PointTwo(PointTwo point) {
        super(point);
        this.z = point.z;
    }

    public PointTwo(int i, int j, int k) {
        super(i,j);
        this.z = k;
    }
}
