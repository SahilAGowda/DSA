package Arrays.Easy;

import java.util.*;

public class MoveZeroes {
    /*
    ?Given an integer array nums, move all 0's to the end of it while maintaining
     * the relative order of the non-zero elements.
     * 
     * Note that you must do this in-place without making a copy of the array.
     * 
     * Example 1:
     * 
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Example 2:
     * 
     * Input: nums = [0]
     * Output: [0]
     * 
     */
    // public static void moveZeroes(int[] nums) {
    // int count = 0, index = 0;
    // for (int i = 0; i < nums.length; i++) {
    // if (nums[i] != 0) {
    // nums[index++] = nums[i];
    // } else {
    // count++;
    // }
    // }
    // for (int i = nums.length - count; i < nums.length; i++) {
    // nums[index++] = 0;
    // }
    // System.out.println(Arrays.toString(nums));
    // }

    public static void moveZeroes(int nums[]) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Perform Swap Operation
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 0, 6, 0, 3, 1, 3, 4, 0 };
        moveZeroes(arr);
    }
}
