package org.jfree.starter.Chart;


import java.util.Scanner;

//Create options for graph according to JChart settings available
//want lines showing interval min and max, etc, add labels, etc.
public class chartCreation {

        /*
        give options for type of chart.
        e.g. Area chart, barchart, gantt, histogram, line chart, pie chart,

        */

    //createBarChart(String title,
    // String categoryAxisLabel, - label for axis value
    // String valueAxisLabel, - label for axis value
    // CategoryDataset dataset, - data set for chart
    // PlotOrientation orientation, -> horizontal or vertice
    // boolean legend,-> is legend required
        void selectionBar () {
            String axisY;
            String axisX;
            String dataSetName;

            Scanner input = new Scanner (System.in);
            System.out.println("Name for category (Y) axis: ");
            axisY = input.nextLine();

            System.out.println("Name for category (X) axis: ");
            axisX = input.nextLine();

            System.out.println("Provide data set name: ");
            dataSetName = input.nextLine();

            dataIO sl = new dataIO();
            dataSets list = sl.ReadFile();

            createBarGraph bg = new createBarGraph(list, axisY, axisX, dataSetName);



        }

    void selectionLineChart () {
        String axisY;
        String axisX;
        String dataSetName;

        Scanner input = new Scanner (System.in);
        System.out.println("Name for category (Y) axis: ");
        axisY = input.nextLine();

        System.out.println("Name for category (X) axis: ");
        axisX = input.nextLine();

        System.out.println("Provide data set name: ");
        dataSetName = input.nextLine();

        dataIO sl = new dataIO();
        dataSets list = sl.ReadFile();

        createLineChart lc = new createLineChart(list, axisY, axisX, dataSetName);



    }







}
