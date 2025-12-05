package org.jfree.starter.Chart;

import java.util.LinkedList;
import java.util.Scanner;

public class dataSets <T> {
    private String name = "";
    private LinkedList<dataPoint> arr;
    private int dataY;
    private String labelY;
    private String labelX;
    private int dataType;

    //add input for labelX and Y
    //constructor for an array of data points
    public dataSets(String name, String labelY, String labelX, int dataType) {
        this.name = name;
        this.labelY = labelY;
        this.labelX = labelX;
        this.dataType = dataType;
        arr = new LinkedList<dataPoint>();

    }

    public String getSetName() {
        return this.name;
    }

    //methods
    //add
    public void addElement(T dataX, T dataY) {
                dataPoint input = new dataPoint(dataX, dataY);
                arr.add(input);
    }


    public int getDataType() {
        return this.dataType;
    }

    public dataPoint getElement(int index) { return arr.get(index); }

    public dataPoint getElementByDate(String dataY) { return null; }

    public void setElement(int index, double value) {}

    public String getName() {
        return name;
    }

    public int getLength() {
        return arr.size();
    }

    public LinkedList<dataPoint> getArray() {
        return arr;
    }

    public void printArray() {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).getAxisXx() + ": " + arr.get(i).getAxisYy());
        }
    }
    public String getAxisY() {
        return labelY;
    }

    public String getAxisX() {
        return labelX;
    }


    public String dataToString() {
        String str = "";
        for (int i = 0; i < arr.size(); i++) {
            str += arr.get(i).getAxisYy() +" "+ arr.get(i).getAxisXx() + "\n";
            //System.out.println(arr.get(i).getAxisYy() + " " + arr.get(i).getAxisXx());
        }

        return str;


    }














}
