package Arrays.Easy;

import java.util.HashMap;

public class LongestSubarrayWithSum {

    /*
     * Given an array arr[] containing integers and an integer k, your task is to
     * find the length of the longest subarray where the sum of its elements is
     * equal to the given value k. If there is no subarray with sum equal to k,
     * return 0.
     * 
     * Examples:
     * 
     * Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
     * Output: 6
     * Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2,
     * 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
     * Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
     * Output: 5
     * Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
     * Input: arr[] = [10, -10, 20, 30], k = 5
     * Output: 0
     * Explanation: No subarray with sum = 5 is present in arr[].
     */

    /**
     * Finds the length of the longest subarray with sum equal to k.
     *
     * Approach:
     * - Uses prefix sum and a HashMap to store the first occurrence of each prefix
     * sum.
     * - For each index i, calculate the running sum (prefix sum) up to i.
     * - If the prefix sum equals k, the subarray from 0 to i has sum k.
     * - Otherwise, check if (prefix sum - k) has been seen before:
     * - If yes, it means the subarray between the previous index (where prefix sum
     * - k was seen) and i has sum k.
     * - Update the maximum length accordingly.
     * - Store the first occurrence of each prefix sum in the HashMap to maximize
     * the subarray length.
     *
     * Example:
     * arr = [10, 5, 2, 7, 1, -10], k = 2
     * Prefix sums: [10, 15, 17, 24, 25, 15]
     * At i=2, sum=17, rem=15. 15 was seen at i=1, so subarray (2-1)=1 to 2 has sum
     * 2.
     * At i=5, sum=15, rem=13. 13 not seen, but sum==k never true, so max length is
     * 2.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    // User function Template for Java

    // Sliding window -> work only for positive
    
    class Solution {
        public int longestSubarray(int[] arr, int k) {
            // code here
            int start = 0;
            int max = 0;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i]; // Add the CUrrent Element

                while (sum > k && start < arr.length) {
                    sum -= arr[start]; // removing an element from start
                    start++;
                }
                if (sum == k) {
                    max = Math.max(max, i - start + 1);
                }
            }
            return max;
        }
    }

    public static int longestSubarray(int[] arr, int k) {
        // prefix sum + hashmap
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            // If sum from 0 to i is k, update max
            if (sum == k) {
                max = Math.max(max, i + 1);
            }
            int rem = sum - k;
            // If (sum - k) seen before, subarray between previous index+1 and i sums to k
            if (hm.containsKey(rem)) {
                int len = hm.get(rem);
                max = Math.max(i - len, max);
            }
            // Store first occurrence of sum
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 5, 2, 7, 1, -10 };
        int k = 2;
        System.out.println(longestSubarray(arr, k));
    }
}
