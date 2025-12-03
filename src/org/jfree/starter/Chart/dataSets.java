package org.jfree.starter.Chart;

import java.util.LinkedList;

public class dataSets {
    private String name = "";
    private LinkedList<dataPoint> arr;
    private int length;
    private int dataY;

    //constructor for an array of data points
    public dataSets(String name, int length) {
        this.name = name;
        this.length = length;
        arr = new LinkedList<dataPoint>();

    }

    //methods
    //add
    public void addElement(double number, String dataY) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == null) {
                dataPoint input = new dataPoint(dataY, number);
                arr.add(i, input);
            }
        }
    }

    public dataPoint getElement(int index) { return arr.get(index); }

    public dataPoint getElementByDate(String dataY) { return null; }

    public void setElement(int index, double value) {}

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public LinkedList<dataPoint> getArray() {
        return arr;
    }

    public void printArray() {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).getDate() + ": " + arr.get(i).getPoint());
        }
    }


    public String dataToString() {
        String str = "";
        for (int i = 0; i < arr.size(); i++) {
            str += arr.get(i).getPoint()+1 +" "+ arr.get(i).getDate() + "\n";
            System.out.println(arr.get(i).getPoint() + " " + arr.get(i).getDate());
        }

        return str;


    }














}
