package org.jfree.starter.Chart;

import java.util.LinkedList;
import java.util.Scanner;

public class dataSets <T> {
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
    public void addElement(T dataX, T dataY) {
                dataPoint input = new dataPoint(dataX, dataY);
                arr.add(input);
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
            System.out.println(arr.get(i).getAxisXx() + ": " + arr.get(i).getAxisYy());
        }
    }


    public String dataToString() {
        String str = "";
        for (int i = 0; i < arr.size(); i++) {
            // str +=  +" "+ arr.get(i).getAxisXx() + "\n";
            //(arr.get(i).getAxisYy()+1).toString()
            System.out.println(arr.get(i).getAxisYy() + " " + arr.get(i).getAxisXx());
        }

        return str;


    }














}
