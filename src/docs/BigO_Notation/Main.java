package docs.BigO_Notation;

public class Main {

    // O(1)
    public static int addItems(int n) {
        return n + n;
    }

    // O(log N)
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // O(N)
    public static void printItems(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }
    // O(N^2)
    public static void printItemsInNestedLoop (int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }

        }
    }


    // Drop Constants
    public static void printItemsInCaseOfDropConstants (int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }

        for (int j = 0; j < n; j++) {
            System.out.println(j);
        }
    }

    // Drop Non-Dominants
    public static void printItemsInCaseOfDropNonDominants(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }

        for (int k = 0; k < n; k++) {
            System.out.println(k);
        }
    }

    public static void main(String[] args) {
        // O(1)
        System.out.println(addItems(5));
        // O(logN)
        System.out.println(binarySearch(new int[] {1,2,3,4,5,6,7,8}, 7));
        // O(N)
        printItems(5);
        // O(N^2)
        printItemsInNestedLoop(5);

        printItemsInCaseOfDropConstants(5);
        printItemsInCaseOfDropNonDominants(5);

    }
}
