package Algorithms.BinarySearch;

public class BinarySearch {
    static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return mid;
            if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 10, 13, 18, 21};
        int target = 13;

        System.out.println(binarySearch(arr, target));
    }
}
