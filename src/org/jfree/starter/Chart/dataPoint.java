package org.jfree.starter.Chart;


//need to allow dataPoint's data inputs to be more flexible

public class dataPoint {
    private String date = "";
    private double point;

        public dataPoint(String date, double point) {
            this.date = date;
            this.point = point;
        }

        public String getDate() {
        return date;
        }

    public double getPoint() {
        return point;
    }
}
