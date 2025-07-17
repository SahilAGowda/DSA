package Arrays.Easy;

public class MaximumConsectiveOnes {
    /*
     * Given a binary array nums, return the maximum number of consecutive 1's in
     * the array.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive
     * 1s. The maximum number of consecutive 1s is 3.
     * Example 2:
     * 
     * Input: nums = [1,0,1,1,0,1]
     * Output: 2
     * 
     */

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(count, max);
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {1,0,1,1,0,1,1,1,0};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
