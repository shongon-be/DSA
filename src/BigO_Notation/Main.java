package BigO_Notation;

public class Main {
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

    public static void main(String[] args) {
        printItems(5);
        printItemsInNestedLoop(5);

        printItemsInCaseOfDropConstants(5);
    }
}
