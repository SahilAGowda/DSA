package BinarySearch.BinarySearchOn2DArray;

class MedianInARowWiseSortedArray {
    /*
     * Given a row-wise sorted matrix mat[][] of size n*m, where the number of rows
     * and columns is always odd. Return the median of the matrix.
     * 
     * Examples:
     * 
     * Input: mat[][] = [[1, 3, 5],
     * [2, 6, 9],
     * [3, 6, 9]]
     * Output: 5
     * Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9].
     * Hence, 5 is median.
     * Input: mat[][] = [[2, 4, 9],
     * [3, 6, 7],
     * [4, 7, 10]]
     * Output: 6
     * Explanation: Sorting matrix elements gives us [2, 3, 4, 4, 6, 7, 7, 9, 10].
     * Hence, 6 is median.
     * Input: mat = [[3], [4], [8]]
     * Output: 4
     * Explanation: Sorting matrix elements gives us [3, 4, 8]. Hence, 4 is median.
     * Constraints:
     * 1 ≤ n, m ≤ 400
     * 1 ≤ mat[i][j] ≤ 2000
     */
    public static int minimum(int mat[][], int col) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] < min) {
                min = mat[i][col];
            }
        }
        return min;
    }

    public static int maximum(int mat[][], int col) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
            }
        }
        return max;
    }

    public static int UpperBound(int arr[], int tar) {
        int low = 0;
        int high = arr.length - 1;
        // if the array is not there in the range so ans shoudl be set to the length
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > tar) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int checkSmaller(int mat[][], int mid) {
        int cnt = 0;
        for (int i = 0; i < mat.length; i++) {
            cnt += UpperBound(mat[i], mid);
        }
        return cnt;
    }

    public static int median(int[][] mat) {
        // Find out the range
        int req = (mat.length * mat[0].length) / 2;
        int low = minimum(mat, 0);
        int high = maximum(mat, mat[0].length - 1);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int smaller = checkSmaller(mat, mid);
            if (smaller <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int nums[][]={{1, 3, 5},{2, 6, 9},{3, 6, 9}};
        System.out.println(median(nums));
    }
}
