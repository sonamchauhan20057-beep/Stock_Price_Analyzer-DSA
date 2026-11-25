
import java.util.Scanner;

public class StockPriceAnalyzer {

    static int[] prices;
    static int n;

    // 1. Input Stock Prices
    public static void inputPrices(Scanner sc) {

        System.out.print("Enter number of days: ");
        n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of days must be positive.");
            n = 0;
            prices = null;
            return;
        }

        prices = new int[n];

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            prices[i] = sc.nextInt();
        }

        System.out.println("Stock prices stored successfully!");
    }

    // 2. Display Stock Prices
    public static void displayPrices() {

        System.out.println("\nStock Prices:");

        for (int i = 0; i < n; i++) {
            System.out.print(prices[i] + " ");
        }

        System.out.println();
    }

    // 3. Sort Prices in Ascending Order using Bubble Sort
    public static void sortAscending() {

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (prices[j] > prices[j + 1]) {

                    int temp = prices[j];

                    prices[j] = prices[j + 1];

                    prices[j + 1] = temp;
                }
            }
        }

        System.out.println("Prices sorted in Ascending Order:");
        displayPrices();
    }

    // 4. Sort Prices in Descending Order using Bubble Sort
    public static void sortDescending() {

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (prices[j] < prices[j + 1]) {

                    int temp = prices[j];

                    prices[j] = prices[j + 1];

                    prices[j + 1] = temp;
                }
            }
        }

        System.out.println("Prices sorted in Descending Order:");
        displayPrices();
    }

    // 5. Binary Search
    public static void binarySearch(int key) {

        // Binary Search requires ascending order
        sortAscendingWithoutDisplay();

        int left = 0;
        int right = n - 1;
        boolean found = false;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (prices[mid] == key) {

                System.out.println("Stock price found at index: " + mid);
                found = true;
                break;
            }

            else if (prices[mid] < key) {

                left = mid + 1;
            }

            else {

                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Stock price not found!");
        }
    }

    // Helper method for ascending sorting
    public static void sortAscendingWithoutDisplay() {

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (prices[j] > prices[j + 1]) {

                    int temp = prices[j];
                    prices[j] = prices[j + 1];
                    prices[j + 1] = temp;
                }
            }
        }
    }

    // 6. Find Maximum Price
    public static void findMaximum() {

        int max = prices[0];

        for (int i = 1; i < n; i++) {

            if (prices[i] > max) {
                max = prices[i];
            }
        }

        System.out.println("Maximum Stock Price: " + max);
    }

    // 7. Find Minimum Price
    public static void findMinimum() {

        int min = prices[0];

        for (int i = 1; i < n; i++) {

            if (prices[i] < min) {
                min = prices[i];
            }
        }

        System.out.println("Minimum Stock Price: " + min);
    }

    // 8. Calculate Average Price
    public static void calculateAverage() {

        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum = sum + prices[i];
        }

        double average = (double) sum / n;

        System.out.println("Average Stock Price: " + average);
    }

    // 9. Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== STOCK PRICE ANALYZER =====");

        inputPrices(sc);

        if (n == 0) {
            sc.close();
            return;
        }

        int choice;

        do {

            System.out.println("\n===== MAIN MENU =====");

            System.out.println("1. Display Stock Prices");
            System.out.println("2. Sort Prices (Ascending)");
            System.out.println("3. Sort Prices (Descending)");
            System.out.println("4. Search Stock Price");
            System.out.println("5. Find Maximum Price");
            System.out.println("6. Find Minimum Price");
            System.out.println("7. Calculate Average Price");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayPrices();
                    break;

                case 2:
                    sortAscending();
                    break;

                case 3:
                    sortDescending();
                    break;

                case 4:
                    System.out.print("Enter price to search: ");
                    int key = sc.nextInt();
                    binarySearch(key);
                    break;

                case 5:
                    findMaximum();
                    break;

                case 6:
                    findMinimum();
                    break;

                case 7:
                    calculateAverage();
                    break;

                case 8:
                    System.out.println("Thank you for using Stock Price Analyzer!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}

