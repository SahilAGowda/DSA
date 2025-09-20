package Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    /*
     * Given a collection of candidate numbers (candidates) and a target number
     * (target), find all unique combinations in candidates where the candidate
     * numbers sum to target.
     * 
     * Each number in candidates may only be used once in the combination.
     * 
     * Note: The solution set must not contain duplicate combinations.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * Example 2:
     * 
     * Input: candidates = [2,5,2,1,2], target = 5
     * Output:
     * [
     * [1,2,2],
     * [5]
     * ]
     * 
     * 
     * Constraints:
     * 
     * 1 <= candidates.length <= 100
     * 1 <= candidates[i] <= 50
     * 1 <= target <= 30
     */
    // public static void findCombination(int ind, int arr[], int tar,
    // Set<List<Integer>> ans,
    // ArrayList<Integer> ds) {
    // if(ind==arr.length){
    // if(tar==0){
    // ans.add(new ArrayList<>(ds));
    // }
    // return;
    // }
    // if(arr[ind]<=tar){
    // ds.add(arr[ind]);
    // findCombination(ind+1,arr,tar-arr[ind],ans,ds);
    // ds.remove(ds.size()-1);
    // }
    // findCombination(ind+1,arr,tar,ans,ds);

    // }

    public static void findCombination(int ind, int arr[], int tar, List<List<Integer>> ans,
            ArrayList<Integer> ds) {
        if (tar == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > tar)
                break;
            ds.add(arr[i]);
            findCombination(i + 1, arr, tar - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // Set<List<Integer>> ans = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        List<List<Integer>> res = combinationSum2(arr, target);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
