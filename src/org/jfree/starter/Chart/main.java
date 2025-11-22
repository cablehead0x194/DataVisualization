package org.jfree.starter.Chart;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static dataPoints[] list = new dataPoints[10];

    public static dataPoints createDataSet() {
        Scanner scanner = new Scanner(System.in);
        String name ="";
        String date = "";
        int length = 0;
        boolean valid = false;

        System.out.println("Enter name of data elements: ");
        name = scanner.next();
        scanner.nextLine();

        System.out.println("Enter number of data points: ");
        do {
            try {
                length = scanner.nextInt();
                scanner.nextLine();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
            }
        }   while (!valid);


        dataPoints array = new dataPoints(name, length);
        return array;
    }

    /**
     * Method to add data points to existing array
     * no return needed.
     * Need to make the array accesible but immutable
     */
    public static void addDataPoints(dataPoints array) {



        try {
            Scanner scanner = new Scanner(System.in);
            dataPoints list = array;
            double points = 0.0;
            String date = "";

            //need to add exception for wrong input type and try again message.
            for (int i = 0; i < array.getArray().length; ++i) {
                System.out.println("Enter data point: ");
                points = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Enter date (DD/MM/YYYY): ");
                date = scanner.next();

                array.addElement(points, date);
            }
        }
        catch (NullPointerException e) {
            System.out.println("Data set has not been initialized or loaded.");
        }
    }

    //to view data set
    public static void printDataPoints (dataPoints list) {
        try {
            list.printArray();
        }
        catch (NullPointerException e) {
            System.out.println("There are no data sets loaded to the program.");
        }
    }

    public static void SaveObjectArrayStart(dataPoints list) {
        SaveLoadDataSets sl = new SaveLoadDataSets(list);
        sl.SaveArray();
    }

    public static dataPoints loadDataSet() {
        SaveLoadDataSets sl = new SaveLoadDataSets();
        return sl.ReadFile();
    }

    public static void loadSets() {
        SaveLoadDataSets ls =  new SaveLoadDataSets();
        ls.viewSavedDataSets();
    }

    public static void grOptionsMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Chart Creation Menu ===");
            System.out.println("1. Create Bar Chart");
            System.out.println("2. Create Line Chart");
            System.out.println("0. Return to main menu.");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    graphOptions bgr = new graphOptions();
                    bgr.selectionBar();
                case 2:
                    graphOptions cgr = new graphOptions();
                    cgr.selectionLineChart();
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        while (choice != 0) ;
    }

    public static void saveLocally(dataPoints newSave) {
        int i = 0;
        try {
            while (list[i] != null) {
                ++i;
            }
            list[i] = newSave;
        }
        catch (NullPointerException e) {
            System.out.println("Too many working data sets.");
        }
    }

    public static void loadedSetNames() {
       int i = 0;
       if (list[0] == null) { System.out.println("There are no data sets loaded."); }
        while (list[i] != null) {
            System.out.println(list[i].getName());
            ++i;
        }
    }



    public static void main(String[] args) {



        //create menu to select
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Create Data Set");
            System.out.println("2. View Data Set");
            System.out.println("3. Add to Data Set");
            System.out.println("4. View Loaded Graphs List");
            System.out.println("5. Save Data Set");
            System.out.println("6. Load Data Set");
            System.out.println("7. View Saved Data Sets");
            System.out.println("8. Select and Create Graph");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dataPoints newList = createDataSet();
                    saveLocally(newList);
                    break;
                case 2:
                    printDataPoints(list[0]);
                    break;
                case 3:
                    addDataPoints(list[0]);
                    break;
                case 4:
                    loadedSetNames();
                    break;
                case 5:
                    SaveObjectArrayStart(list[0]);
                    break;
                case 6:
                    saveLocally(loadDataSet());
                    break;
                case 7:
                    loadSets();
                    break;
                case 8:
                    grOptionsMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);


    }
}
