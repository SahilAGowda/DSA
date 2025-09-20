package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    /*
     * Given an integer array nums that may contain duplicates, return all possible
     * subsets (the power set).
     * 
     * The solution set must not contain duplicate subsets. Return the solution in
     * any order.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,2,2]
     * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
     * Example 2:
     * 
     * Input: nums = [0]
     * Output: [[],[0]]
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     */
     public static void findSubset(int ind, int arr[], List<List<Integer>> ans, ArrayList<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for(int i=ind;i<arr.length;i++){
            if(i!=ind && arr[i]==arr[i-1]) continue;
            ds.add(arr[i]);
            findSubset(i+1,arr,ans,ds);
            ds.remove(ds.size()-1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubset(0, nums, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2 };
        List<List<Integer>> res = subsetsWithDup(arr);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
