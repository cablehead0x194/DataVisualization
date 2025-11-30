package org.jfree.starter.Chart;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static dataSets[] list = new dataSets[10];

    public static dataSets createDataSet() {
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


        dataSets array = new dataSets(name, length);
        return array;
    }

    /**
     * Method to add data points to existing array
     * no return needed.
     * Need to make the array accesible but immutable
     */
    public static void addDataPoints(dataSets array) {



        try {
            Scanner scanner = new Scanner(System.in);
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
    public static void printDataPoints() {
        try {
        Scanner input = new Scanner(System.in);

        System.out.println("Select locally loaded data set: ");
        loadedSetNames();
        int setNo = input.nextInt();

        list[setNo].dataToString();

        }
        catch (NullPointerException e) {
            System.out.println("There are no data sets loaded to the program.");
        }
    }

    public static void saveLocalArray() {
        System.out.println("Select local data set to save: ");
        loadedSetNames();
        Scanner scanMe = new Scanner(System.in);
        int loadThis = scanMe.nextInt();
        dataIO sl = new dataIO(list[loadThis]);
        sl.SaveArray();
    }

    public static dataSets loadDataSet() {
        dataIO sl = new dataIO();
        return sl.ReadFile();
    }

    public static void viewAllSets() {
        dataIO ls =  new dataIO();
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
                    chartCreation bgr = new chartCreation();
                    bgr.selectionBar();
                case 2:
                    chartCreation cgr = new chartCreation();
                    cgr.selectionLineChart();
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        while (choice != 0) ;
    }

    public static void saveLocally(dataSets newSave) {
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
            System.out.print(i+". ");
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
            System.out.println("4. View Loaded Data Sets");
            System.out.println("5. Save Data Set");
            System.out.println("6. Load Data Set");
            System.out.println("7. View Saved Data Sets");
            System.out.println("8. Select and Create Graph");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    dataSets newList = createDataSet();
                    saveLocally(newList);
                    break;
                case 2:
                    printDataPoints();
                    break;
                case 3:
                    //modify so it adds data points to specified local data set
                    addDataPoints(list[0]);
                    break;
                case 4:
                    loadedSetNames();
                    break;
                case 5:
                    //modify so it saves request local data set not just list[0]
                    saveLocalArray();
                    break;
                case 6:
                    dataSets loadUp = loadDataSet();
                    saveLocally(loadUp);
                    break;
                case 7:
                    viewAllSets();
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
