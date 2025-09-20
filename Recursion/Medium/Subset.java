package Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    /*
     * Given an integer array nums of unique elements, return all possible subsets
     * (the power set).
     * 
     * The solution set must not contain duplicate subsets. Return the solution in
     * any order.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,2,3]
     * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * Example 2:
     * 
     * Input: nums = [0]
     * Output: [[],[0]]
     * 
     */
    public static void findSubset(int ind, List<List<Integer>> ans, int arr[], ArrayList<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for (int i = ind; i < arr.length; i++) {
            if (i != ind && arr[i] == arr[i - 1])
                continue;
            ds.add(arr[i]);
            findSubset(i + 1, ans, arr, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubset(0, ans, nums, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        List<List<Integer>> res = subsets(arr);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
