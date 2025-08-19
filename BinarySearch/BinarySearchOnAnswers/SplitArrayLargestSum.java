package BinarySearch.BinarySearchOnAnswers;

// ! This problem is also known as the partition painter problem 

public class SplitArrayLargestSum {
    /*
     * Given an integer array nums and an integer k, split nums into k non-empty
     * subarrays such that the largest sum of any subarray is minimized.
     * 
     * Return the minimized largest sum of the split.
     * 
     * A subarray is a contiguous part of the array.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [7,2,5,10,8], k = 2
     * Output: 18
     * Explanation: There are four ways to split nums into two subarrays.
     * The best way is to split it into [7,2,5] and [10,8], where the largest sum
     * among the two subarrays is only 18.
     * Example 2:
     * 
     * Input: nums = [1,2,3,4,5], k = 2
     * Output: 9
     * Explanation: There are four ways to split nums into two subarrays.
     * The best way is to split it into [1,2,3] and [4,5], where the largest sum
     * among the two subarrays is only 9.
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] <= 106
     * 1 <= k <= min(50, nums.length)
     */
    public static int helper(int nums[], int pages) {
        int student = 1;
        int page = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + page <= pages) {
                page += nums[i];
            } else {
                student++;
                page = nums[i];
            }
        }
        return student;
    }

    public static int summation(int nums[]) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static int maximum(int nums[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static int findMin(int nums[], int k) {
        int low = maximum(nums);
        int high = summation(nums);
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (helper(nums, mid) <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[]={7,2,5,10,8};
        int k =2;
        System.out.println(findMin(nums, k));
    }
}
