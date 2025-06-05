import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberSorter {

    private List<Double> numbers;
    private Scanner scanner;

    public NumberSorter() {
        this.numbers = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Main method to run the application.
     */
    public static void main(String[] args) {
        NumberSorter sorter = new NumberSorter();
        sorter.runApplication();
    }

    /**
     * Runs the main application loop.
     */
    public void runApplication() {
        System.out.println("Welcome to the Number Sorter!");
        getUserNumbers();
        if (numbers.isEmpty()) {
            System.out.println("No numbers were entered. Exiting.");
            return;
        }
        getSortOrderAndSort();
        displaySortedNumbers();
        generateSimpleReport();
        System.out.println("Thank you for using Number Sorter!");
        scanner.close();
    }

    /*
     * Gets numbers from the user.
     */
    private void getUserNumbers() {
        System.out.println("Enter numbers one by one. Type 'done' when finished:");
        String input;
        while (true) {
            System.out.print("Enter a number (or 'done'): ");
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                double number = Double.parseDouble(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid number or 'done'.");
            }
        }
    }

    /**
     * Gets the desired sort order from the user and performs the sort.
     */
    private void getSortOrderAndSort() {
        if (numbers.isEmpty()) {
            return; // No numbers to sort
        }

        while (true) {
            System.out.print("Sort in (A)scending or (D)escending order? (A/D): ");
            String choice = scanner.nextLine().trim().toUpperCase();
            if (choice.equals("A")) {
                Collections.sort(numbers);
                System.out.println("Numbers sorted in ascending order.");
                break;
            } else if (choice.equals("D")) {
                Collections.sort(numbers, Collections.reverseOrder());
                System.out.println("Numbers sorted in descending order.");
                break;
            } else {
                System.err.println("Invalid choice. Please enter 'A' for Ascending or 'D' for Descending.");
            }
        }
    }

    /**
     * Displays the sorted numbers.
     */
    private void displaySortedNumbers() {
        if (numbers.isEmpty()) {
            System.out.println("No numbers to display.");
            return;
        }
        System.out.println("Sorted numbers:");
        for (double number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println(); // New line after printing all numbers
    }

    /**
     * Optional: Generates a simple summary report.
     */
    private void generateSimpleReport() {
        if (numbers.isEmpty()) {
            return;
        }
        System.out.println("\n--- Summary Report ---");
        System.out.println("Total numbers entered: " + numbers.size());
        if (!numbers.isEmpty()) {
            double sum = 0;
            for (double num : numbers) {
                sum += num;
            }
            double average = sum / numbers.size();
            System.out.printf("Minimum value: %.2f%n", Collections.min(numbers));
            System.out.printf("Maximum value: %.2f%n", Collections.max(numbers));
            System.out.printf("Sum of numbers: %.2f%n", sum);
            System.out.printf("Average of numbers: %.2f%n", average);
        }
        System.out.println("--- End of Report ---");
    }
}
