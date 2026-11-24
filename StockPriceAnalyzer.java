
import java.util.Arrays;
import java.util.Scanner;

public class StockPriceAnalyzer {

    static Scanner sc = new Scanner(System.in);

    static int[] prices;
    static int n = 0;

    // 1. Input Stock Prices
    static void inputPrices() {

        System.out.print("Enter number of days: ");
        n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid number of days.");
            n = 0;
            return;
        }

        prices = new int[n];

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            prices[i] = sc.nextInt();
        }

        System.out.println("Stock prices entered successfully!");
    }

    // 2. Display Stock Prices
    static void displayPrices() {

        System.out.println("Stock Prices:");

        for (int i = 0; i < n; i++) {
            System.out.print(prices[i] + " ");
        }

        System.out.println();
    }

    // 3. Bubble Sort - Ascending Order
    static int[] sortAscending() {

        int[] arr = Arrays.copyOf(prices, n);

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    // 4. Bubble Sort - Descending Order
    static int[] sortDescending() {

        int[] arr = Arrays.copyOf(prices, n);

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] < arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    // 5. Binary Search
    static void binarySearch(int key) {

        int[] arr = sortAscending();

        int low = 0;
        int high = n - 1;
        boolean found = false;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {

                System.out.println("Stock price found: " + key);
                found = true;
                break;
            }

            else if (arr[mid] < key) {

                low = mid + 1;
            }

            else {

                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Stock price not found!");
        }
    }

    // 6. Find Maximum Price
    static void findMaximum() {

        int max = prices[0];

        for (int i = 1; i < n; i++) {

            if (prices[i] > max) {
                max = prices[i];
            }
        }

        System.out.println("Maximum Stock Price: " + max);
    }

    // 7. Find Minimum Price
    static void findMinimum() {

        int min = prices[0];

        for (int i = 1; i < n; i++) {

            if (prices[i] < min) {
                min = prices[i];
            }
        }

        System.out.println("Minimum Stock Price: " + min);
    }

    // 8. Calculate Average Price
    static void calculateAverage() {

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += prices[i];
        }

        double average = (double) sum / n;

        System.out.println("Average Stock Price: " + average);
    }

    // 9. Main Method
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== STOCK PRICE ANALYZER =====");

            System.out.println("1. Enter Stock Prices");
            System.out.println("2. Display Stock Prices");
            System.out.println("3. Sort Prices (Ascending)");
            System.out.println("4. Sort Prices (Descending)");
            System.out.println("5. Search Stock Price");
            System.out.println("6. Find Maximum Price");
            System.out.println("7. Find Minimum Price");
            System.out.println("8. Calculate Average Price");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice == 1) {

                inputPrices();
            }

            else if (choice >= 2 && choice <= 8 && n == 0) {

                System.out.println("Please enter stock prices first!");
            }

            else {

                switch (choice) {

                    case 2:
                        displayPrices();
                        break;

                    case 3:
                        System.out.println("Ascending Order:");
                        System.out.println(Arrays.toString(sortAscending()));
                        break;

                    case 4:
                        System.out.println("Descending Order:");
                        System.out.println(Arrays.toString(sortDescending()));
                        break;

                    case 5:
                        System.out.print("Enter price to search: ");
                        int key = sc.nextInt();
                        binarySearch(key);
                        break;

                    case 6:
                        findMaximum();
                        break;

                    case 7:
                        findMinimum();
                        break;

                    case 8:
                        calculateAverage();
                        break;

                    case 9:
                        System.out.println("Thank you for using Stock Price Analyzer!");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }

        } while (choice != 9);

        sc.close();
    }
}
