package Arrays.Medium;

import java.util.Arrays;

public class NextPermutation {
    /*
     * A permutation of an array of integers is an arrangement of its members into a
     * sequence or linear order.
     * 
     * For example, for arr = [1,2,3], the following are all the permutations of
     * arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
     * The next permutation of an array of integers is the next lexicographically
     * greater permutation of its integer. More formally, if all the permutations of
     * the array are sorted in one container according to their lexicographical
     * order, then the next permutation of that array is the permutation that
     * follows it in the sorted container. If such arrangement is not possible, the
     * array must be rearranged as the lowest possible order (i.e., sorted in
     * ascending order).
     * 
     * For example, the next permutation of arr = [1,2,3] is [1,3,2].
     * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
     * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does
     * not have a lexicographical larger rearrangement.
     * Given an array of integers nums, find the next permutation of nums.
     * 
     * The replacement must be in place and use only constant extra memory.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     * Example 2:
     * 
     * Input: nums = [3,2,1]
     * Output: [1,2,3]
     * Example 3:
     * 
     * Input: nums = [1,1,5]
     * Output: [1,5,1]
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     */

    public static void swap(int arr[], int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public static void reverse(int arr[], int low, int high) {
        while (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    /**
     * Next Permutation Algorithm - Detailed Explanation:
     * 
     * The goal is to find the lexicographically next greater permutation.
     * If no such permutation exists, return the smallest permutation (sorted ascending).
     * 
     * Algorithm Steps:
     * 
     * Step 1: Find the breakpoint (pivot)
     * - Traverse from right to left to find the first index 'i' where nums[i] < nums[i+1]
     * - This is the "breakpoint" or "pivot" - the rightmost character that can be increased
     * - If no such index exists, the array is in descending order (largest permutation)
     * 
     * Step 2: Find the next greater element
     * - If breakpoint exists, find the smallest number on the right side that is greater than nums[breakpoint]
     * - This ensures we get the next lexicographically greater permutation, not just any greater one
     * 
     * Step 3: Swap and reverse
     * - Swap the breakpoint with the found element
     * - Reverse the suffix (from breakpoint+1 to end) to get the smallest possible arrangement
     * 
     * Example: [1,2,3] → [1,3,2]
     * Step 1: breakpoint at index 1 (nums[1]=2 < nums[2]=3)
     * Step 2: find next greater than 2, which is 3 at index 2
     * Step 3: swap(2,3) → [1,3,2], reverse suffix (nothing to reverse)
     * 
     * Example: [1,1,5] → [1,5,1]
     * Step 1: breakpoint at index 0 (nums[0]=1 < nums[1]=1? No, nums[1]=1 < nums[2]=5? Yes)
     * Actually: breakpoint at index 1 (nums[1]=1 < nums[2]=5)
     * Step 2: find next greater than 1, which is 5 at index 2
     * Step 3: swap(1,5) → [1,5,1], reverse suffix (nothing to reverse)
     */
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;
        
        // Step 1: Find the breakpoint (rightmost nums[i] < nums[i+1])  
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        
        // If no breakpoint found, array is in descending order (largest permutation)
        // So we reverse the entire array to get the smallest permutation
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        // Step 2: Find the smallest number greater than nums[ind] from the right
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }
        
        // Step 3: Reverse the suffix to get the next smallest arrangement
        reverse(nums, ind + 1, n - 1);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 5 };
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
