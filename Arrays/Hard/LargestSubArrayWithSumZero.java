package Arrays.Hard;

import java.util.HashMap;

public class LargestSubArrayWithSumZero {
    /*
     * 
     * Given an array arr[] containing both positive and negative integers, the task
     * is to find the length of the longest subarray with a sum equals to 0.
     * 
     * Note: A subarray is a contiguous part of an array, formed by selecting one or
     * more consecutive elements while maintaining their original order.
     * 
     * Examples:
     * 
     * Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
     * Output: 5
     * Explanation: The longest subarray with sum equals to 0 is [-2, 2, -8, 1, 7].
     * Input: arr[] = [2, 10, 4]
     * Output: 0
     * Explanation: There is no subarray with a sum of 0.
     * Input: arr[] = [1, 0, -4, 3, 1, 0]
     * Output: 5
     * Explanation: The longest subarray with sum equals to 0 is [0, -4, 3, 1, 0]
     * Constraints:
     * 1 ≤ arr.size() ≤ 106
     * −103 ≤ arr[i] ≤ 103
     * 
     * 
     * 
     */
    static int maxLength(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                max = i + 1;
            }
            if (hm.containsKey(prefixSum)) {
                int len = hm.get(prefixSum);
                max = Math.max(max, i - len);
            } else {
                hm.put(prefixSum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLength(nums));
    }
}
