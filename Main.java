import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the size of the array
        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        // Take user input for array elements
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Ask user for sorting order
        System.out.print("Enter sorting order (asc/desc): ");
        String order = scanner.next().toLowerCase();

        // Sort accordingly
        if (order.equals("asc")) {
            Arrays.sort(arr);
            System.out.println("Sorted in ascending order:");
        } else if (order.equals("desc")) {
            // Sort in ascending first, then reverse
            Arrays.sort(arr);
            reverseArray(arr);
            System.out.println("Sorted in descending order:");
        } else {
            System.out.println("Invalid input. Sorting in ascending order by default.");
            Arrays.sort(arr);
        }

        // Display the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
    public static void reverseArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


}
