package org.jfree.starter.Chart;

import java.util.Scanner;

public class manipulateData {

    public void addDataPointsClass() {
        Scanner input = new Scanner(System.in);

        System.out.println("Select locally generated data set: ");
        main.loadedSetNames();
        int setNo = input.nextInt();
        dataSets array = main.list[setNo];

        int dataType = array.getDataType();

        if (dataType == 1) {
            addDataInteger(array);
        } else if (dataType == 2) {
            addDataFloat(array);
        } else if (dataType == 3) {
            addDataDouble(array);
        } else {
            System.out.println("Invalid selection");
        }

    }

    private void addDataInteger(dataSets set) {
        try {
            int pointsX;
            int pointsY;
            Scanner scanner = new Scanner(System.in);

            System.out.println("How many data points do you want to add?");
            int count = scanner.nextInt();
            //need to add exception for wrong input type and try again message.
            for (int i = 0; i < count; ++i) {
                System.out.println("Enter data point (x-axis): ");
                pointsX = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter date (y-axis): ");
                pointsY = scanner.nextInt();

                set.addElement(pointsX, pointsY);
            }
        }
        catch (NullPointerException e) {
            System.out.println("Data set has not been initialized or loaded.");
        }
    }

    private void addDataFloat(dataSets set) {
        try {
            float pointsX;
            float pointsY;
            Scanner scanner = new Scanner(System.in);

            System.out.println("How many data points do you want to add?");
            int count = scanner.nextInt();
            //need to add exception for wrong input type and try again message.
            for (int i = 0; i < count; ++i) {
                System.out.println("Enter data point (x-axis): ");
                pointsX = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter date (y-axis): ");
                pointsY = scanner.nextInt();

                set.addElement(pointsX, pointsY);
            }
        }
        catch (NullPointerException e) {
            System.out.println("Data set has not been initialized or loaded.");
        }
    }

    private void addDataDouble(dataSets set) {
        try {
            double pointsX;
            double pointsY;
            Scanner scanner = new Scanner(System.in);

            System.out.println("How many data points do you want to add?");
            int count = scanner.nextInt();
            //need to add exception for wrong input type and try again message.
            for (int i = 0; i < count; ++i) {
                System.out.println("Enter data point (x-axis): ");
                pointsX = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Enter date (y-axis): ");
                pointsY = scanner.nextInt();

                set.addElement(pointsX, pointsY);
            }
        }
        catch (NullPointerException e) {
            System.out.println("Data set has not been initialized or loaded.");
        }
    }
}
