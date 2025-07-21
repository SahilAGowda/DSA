package Arrays.Medium;

import java.util.Arrays;
// import java.util.HashSet;
// import java.util.Set;

public class LongestConsecutiveSequence {
    /*
     * Given an unsorted array of integers nums, return the length of the longest
     * consecutive elements sequence.
     * 
     * You must write an algorithm that runs in O(n) time.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [100,4,200,1,3,2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
     * Therefore its length is 4.
     * Example 2:
     * 
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
     * Output: 9
     * Example 3:
     * 
     * Input: nums = [1,0,1,2]
     * Output: 3
     * 
     */
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) {
            return 0;
        }
        int count = 1;
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i + 1] - nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }


    // public int longestConsecutive(int[] nums) {
    //     Set<Integer>st = new HashSet<>();
    //     for(int n:nums){
    //         st.add(n);
    //     }
    //     int max=0;
    //     for(int n:st){
    //         if(!st.contains(n-1)){
    //              int len =1;
    //             while(st.contains(n+len)){
    //                 len++;
    //             }
    //             max = Math.max(len,max);
    //         }
    //     }
    //     return max;
    // }
    public static void main(String[] args) {
        int arr[] = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(arr));
    }
}
