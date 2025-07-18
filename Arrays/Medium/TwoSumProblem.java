package Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {

  /*
   * 
   * 1. Two Sum
   * Hint
   * Given an array of integers nums and an integer target, return indices of the
   * two numbers such that they add up to target.
   * 
   * You may assume that each input would have exactly one solution, and you may
   * not use the same element twice.
   * 
   * You can return the answer in any order.
   * 
   * 
   * 
   * Example 1:
   * 
   * Input: nums = [2,7,11,15], target = 9
   * Output: [0,1]
   * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
   * Example 2:
   * 
   * Input: nums = [3,2,4], target = 6
   * Output: [1,2]
   * Example 3:
   * 
   * Input: nums = [3,3], target = 6
   * Output: [0,1]
   * 
   * 
   * Constraints:
   * 
   * 2 <= nums.length <= 104
   * -109 <= nums[i] <= 109
   * -109 <= target <= 109
   * Only one valid answer exists.
   * 
   * 
   * Follow-up: Can you come up with an algorithm that is less than O(n2) time
   * complexity?
   * 
   * 
   * 
   */
  /**
   * Brute-force approach:
   * For each pair of indices (i, j), check if nums[i] + nums[j] == target.
   * If so, return their indices. Time Complexity: O(n^2), Space: O(1).
   */
  public static int[] twoSum(int[] nums, int target) {
    int arr[] = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          arr[0] = i;
          arr[1] = j;
          return arr; // Return immediately when found
        }
      }
    }
    return arr; // If not found, returns default [0,0]
  }

  /**
   * HashMap approach:
   * For each element, check if (target - nums[i]) exists in the map.
   * If yes, return indices. Otherwise, put nums[i] and its index in the map.
   * Time Complexity: O(n), Space: O(n).
   */
  public static int[] HashMapTwoSumApproach(int nums[], int target) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    int arr[] = new int[2];
    for (int i = 0; i < nums.length; i++) {
      int temp = target - nums[i];
      if (hm.containsKey(temp)) {
        arr[0] = i;
        arr[1] = hm.get(temp);
      }
      hm.put(nums[i], i);
    }
    return arr;

  }

  public static void main(String[] args) {
    int arr[] = { 2, 7, 11, 15 };
    int target = 9;

    System.out.println(Arrays.toString(twoSum(arr, target)));
    System.out.println(Arrays.toString(HashMapTwoSumApproach(arr, target)));
  }
}
