package BinarySearch.BinarySearchOn1DArray;

public class CountOccuranceOfDuplicates {
    /*
     * Given a sorted array, arr[] and a number target, you need to find the number
     * of occurrences of target in arr[].
     * 
     * Examples :
     * 
     * Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
     * Output: 4
     * Explanation: target = 2 occurs 4 times in the given array so the output is 4.
     * Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
     * Output: 0
     * Explanation: target = 4 is not present in the given array so the output is 0.
     * Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
     * Output: 3
     * Explanation: target = 12 occurs 3 times in the given array so the output is
     * 3.
     * Constraints:
     * 1 ≤ arr.size() ≤ 106
     * 1 ≤ arr[i] ≤ 106
     * 1 ≤ target ≤ 106
     */

    public static int firstOccurances(int arr[], int target) {
        int ans = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int lastOccurances(int arr[], int target) {
        int ans = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    static int countFreq(int[] arr, int target) {
        int first = firstOccurances(arr, target);
        if (first == -1)
            return 0;
        int last = lastOccurances(arr, target);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,2,2,2,3,4};
        int target=2;
        System.out.println(countFreq(nums, target));
    }

}
