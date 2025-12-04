package org.jfree.starter.Chart;

import java.util.Scanner;

public class manipulateData {

    public void addDataPointsClass() {
        Scanner input = new Scanner(System.in);

        System.out.println("Select locally generated data set: ");
        main.loadedSetNames();
        int setNo = input.nextInt();
        dataSets array = main.list[setNo];

        System.out.println("Select data type:\n1. Integer\n2. For up to 7 decimals of precion\n3. For up to 15 decimals of precision ");
        Scanner typeInput = new Scanner(System.in);
        int type = typeInput.nextInt();
        if (type == 1) {
            addDataInteger(array);
        } else if (type == 2) {
            addDataFloat(array);
        } else if (type == 3) {
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
