package org.jfree.starter.Chart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class dataIO {
    dataSets dataSet;

    public dataIO() {
    }

    public dataIO(dataSets dataSet) {
        this.dataSet = dataSet;
    }


    public void SaveArray() {

        String fileName = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("New file name: ");
        fileName = scanner.next();

        try {
            FileWriter myWriter = new FileWriter("data/" + fileName);
            myWriter.write(fileName + "\n");
            myWriter.write(dataSet.getLength() + "\n");
            myWriter.write(dataSet.getDataType() + "\n");
            myWriter.write(dataSet.getAxisY() + "\n");
            myWriter.write(dataSet.getAxisX() + "\n");
            //create toString for dataSets
            myWriter.write(dataSet.dataToString());

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            System.out.println("Data set has not been initialized or loaded.");
        }

    }

    //does this work?
    public dataSets ReadFile() {
        try {
            Scanner scanner = new Scanner(System.in);

        String fileName = "";


        System.out.println("Please enter the data set file name: ");
        fileName = scanner.next();

        File myObj = new File("data/" + fileName);
        //File myObj = new File("data/" + fileName);

        // create new dataSets set and add information from scanner into new dataset.
        Scanner myReader = new Scanner(myObj);
            String name = "";


            name = myReader.nextLine();
            int dataType = myReader.nextInt();

            //might need to add myReader.nextLine() to skip over integer line or something.
            String labelY = myReader.nextLine();
            String labelX = myReader.nextLine();
            myReader.nextLine();
            dataSets array = new dataSets(name, labelY, labelX, dataType);

            //create if else statements for specific data type
            if (dataType == 1) {
                while (myReader.hasNextInt()) {
                    int axisX= myReader.nextInt();
                    int axisY = myReader.nextInt();
                    array.addElement(axisX, axisY);
                }
                return array;
            }
            else if (dataType == 2) {
                while (myReader.hasNextLine()) {
                    double axisX= myReader.nextDouble();
                    double axisY = myReader.nextDouble();
                    array.addElement(axisX, axisY);
                }
                return array;
            }
            else if (dataType == 3) {
                while (myReader.hasNextLine()) {
                    float axisX= myReader.nextFloat();
                    float axisY = myReader.nextFloat();
                    array.addElement(axisX, axisY);
                }
                return array;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File does not exist or is not readable.");

        }

        return null;
    }

    public void viewSavedDataSets() {
        String dir = "data";

        File directory = new File(dir);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File fl : files) System.out.println(fl.getName());
        }
    }



}
