package BinarySearch.BinarySearchOn2DArray;

public class RowsWithMax1 {
    /*
     * You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each
     * row of the array is sorted in non-decreasing order. Your task is to find and
     * return the index of the first row that contains the maximum number of 1s. If
     * no such row exists, return -1.
     * 
     * Note:
     * 
     * The array follows 0-based indexing.
     * The number of rows and columns in the array are denoted by n and m
     * respectively.
     * Examples:
     * 
     * Input: arr[][] = [[0,1,1,1], [0,0,1,1], [1,1,1,1], [0,0,0,0]]
     * Output: 2
     * Explanation: Row 2 contains the most number of 1s (4 1s). Hence, the output
     * is 2.
     * Input: arr[][] = [[0,0], [1,1]]
     * Output: 1
     * Explanation: Row 1 contains the most number of 1s (2 1s). Hence, the output
     * is 1.
     * Input: arr[][] = [[0,0], [0,0]]
     * Output: -1
     * Explanation: No row contains any 1s, so the output is -1.
     * Constraints:
     * 1 ≤ arr.size(), arr[i].size() ≤ 103
     * 0 ≤ arr[i][j] ≤ 1
     * 
     * 
     */

    public static int findFirstOccurances(int arr[], int elem) {
        int low = 0;
        int ans = -1;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= elem) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr[0].length;

        int count_max = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            int count_ones = findFirstOccurances(arr[i], 1) != -1 ? n - findFirstOccurances(arr[i], 1) : 0;
            if (count_ones > count_max) {
                count_max = count_ones;
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int nums[][]={{0,1,1,1}, {0,0,1,1}, {1,1,1,1}, {0,0,0,0}};
        System.out.println(rowWithMax1s(nums));
    }
}
