package Arrays.Hard;

import java.util.HashMap;

public class CountSubarrayWithXorK {
    /*
     * Given an array of integers arr[] and a number k, count the number of
     * subarrays having XOR of their elements as k.
     * 
     * Examples:
     * 
     * Input: arr[] = [4, 2, 2, 6, 4], k = 6
     * Output: 4
     * Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4,
     * 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
     * Input: arr[] = [5, 6, 7, 8, 9], k = 5
     * Output: 2
     * Explanation: The subarrays having XOR of their elements as 5 are [5] and [5,
     * 6, 7, 8, 9]. Hence, the answer is 2.
     * Input: arr[] = [1, 1, 1, 1], k = 0
     * Output: 4
     * Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
     * Constraints:
     * 
     * 1 ≤ arr.size() ≤ 105
     * 0 ≤ arr[i] ≤105
     * 0 ≤ k ≤ 105
     */

    public static long subarrayXor(int arr[], int k) {
        // code here
        long count = 0;
        int prefixSum = 0;
        HashMap<Integer, Long> hm = new HashMap<>();
        hm.put(0, 1L);
        for (int i = 0; i < arr.length; i++) {
            prefixSum ^= arr[i];
            if (hm.containsKey(prefixSum ^ k)) {
                count += hm.get(prefixSum ^ k);
            }

            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0L) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[]={4, 2, 2, 6, 4};
        System.out.println(subarrayXor(nums, 6));
    }
}
