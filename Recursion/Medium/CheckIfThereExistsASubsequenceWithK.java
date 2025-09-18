package Recursion.Medium;

import java.util.ArrayList;

public class CheckIfThereExistsASubsequenceWithK {
    /*
     * Given an array arr and target sum k, check whether there exists a subsequence
     * such that the sum of all elements in the subsequence equals the given target
     * sum(k).
     * 
     * 
     * Example:
     * 
     * Input: arr = [10,1,2,7,6,1,5], k = 8.
     * Output: Yes
     * Explanation: Subsequences like [2, 6], [1, 7] sum upto 8
     * 
     * Input: arr = [2,3,5,7,9], k = 100.
     * Output: No
     * Explanation: No subsequence can sum upto 100
     * Your Task:
     * You don't need to read or print anything. Your task is to complete the
     * boolean function checkSubsequenceSum() which takes N, arr and K as input
     * parameter and returns true/false based on the whether any subsequence with
     * sum K could be found.
     * 
     * 
     * Expected Time Complexity: O(N * K).
     * Expected Auxiliary Space: O(N * K).
     */
    private static boolean subsequences(int ind, int arr[], int n, int k, int sum, ArrayList<Integer> ds) {
        if (ind >= n) {
            return sum == k; // If sum equals K, we've found a valid subsequence
        }
        if (sum > k) {
            return false;
        }

        if (arr[ind] <= k) {
            ds.add(arr[ind]);
            sum += arr[ind];
            if (subsequences(ind + 1, arr, n, k, sum, ds))
                return true;
            sum -= arr[ind];
            ds.remove(ds.size() - 1);
        }
        if (subsequences(ind + 1, arr, n, k, sum, ds))
            return true;

        return false;
    }

    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
        return subsequences(0, arr, N, K, 0, new ArrayList<>());
    }
    public static void main(String[] args) {
        int arr[] = { 10, 1, 2, 7, 6, 1, 5 };
        int k = 8;
        boolean res = checkSubsequenceSum(arr.length, arr, k);
        System.out.println(res);
    }
}
