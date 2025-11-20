package org.jfree.starter.Chart;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Scanner;

//Create options for graph according to JChart settings available
//want lines showing interval min and max, etc, add labels, etc.
public class graphOptions {

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

            SaveLoadDataSets sl = new SaveLoadDataSets();
            dataPoints list = sl.ReadFile();

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

        SaveLoadDataSets sl = new SaveLoadDataSets();
        dataPoints list = sl.ReadFile();

        createLineChart lc = new createLineChart(list, axisY, axisX, dataSetName);



    }







}
