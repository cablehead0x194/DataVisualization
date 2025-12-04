package org.jfree.starter.Chart;


//need to allow dataPoint's data inputs to be more flexible

public class dataPoint<T> {
    private T axisXx;
    private T axisYy;


        public dataPoint(T xx, T yy) {
            this.axisXx = xx;
            this.axisYy = yy;
        }

        public T getAxisXx() {
        return this.axisXx;
        }

    public T getAxisYy() {
        return axisYy;
    }

}
