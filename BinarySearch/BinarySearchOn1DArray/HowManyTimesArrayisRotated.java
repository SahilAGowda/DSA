package BinarySearch.BinarySearchOn1DArray;

public class HowManyTimesArrayisRotated {
    /*
     * Given an increasing sorted rotated array arr[] of distinct integers. The
     * array is right-rotated k times. Find the value of k.
     * Let's suppose we have an array arr[] = [2, 4, 6, 9], if we rotate it by 2
     * times it will look like this:
     * After 1st Rotation : [9, 2, 4, 6]
     * After 2nd Rotation : [6, 9, 2, 4]
     * 
     * Examples:
     * 
     * Input: arr[] = [5, 1, 2, 3, 4]
     * Output: 1
     * Explanation: The given array is [5, 1, 2, 3, 4]. The original sorted array is
     * [1, 2, 3, 4, 5]. We can see that the array was rotated 1 times to the right.
     * Input: arr = [1, 2, 3, 4, 5]
     * Output: 0
     * Explanation: The given array is not rotated.
     * Constraints:
     * 1 ≤ arr.size() ≤105
     * 1 ≤ arr[i] ≤ 107
     * 
     * 
     */

    // ? Key point to remember just to find the minimum number index
    public static int findKRotation(int arr[]) {
        // Logic is we need to find the minimum index;

        int low = 0;
        int high = arr.length - 1;
        int index = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // search space is already sorted
            if (arr[low] <= arr[high]) {
                if (ans > arr[low]) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }
            // left part is sorted
            if (arr[low] <= arr[mid]) {
                if (ans > arr[low]) {
                    index = low;
                    ans = arr[low];

                }
                low = mid + 1;
            } else {
                if (ans > arr[mid]) {
                    index = mid;
                    ans = arr[mid];

                }
                high = mid - 1;
            }

        }
        return index;

    }

    public static void main(String[] args) {
        int nums[] = { 5, 1, 2, 3, 4, };
        System.out.println(findKRotation(nums));
    }
}
