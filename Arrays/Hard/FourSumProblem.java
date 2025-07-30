package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumProblem {

    /*
     * Given an array nums of n integers, return an array of all the unique
     * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     *  
     * 0 <= a, b, c, d < n
     * a, b, c, and d are distinct.
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * You may return the answer in any order.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,0,-1,0,-2,2], target = 0
     * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * Example 2:
     * 
     * Input: nums = [2,2,2,2,2], target = 8
     * Output: [[2,2,2,2]]
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */

    public  static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        res.add(temp);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1,0,-1,0,-2,2};
        int nums2[]={2,2,2,2,2};
        System.out.println(fourSum(nums, 0));
        System.out.println(fourSum(nums2, 8));
    }
}
