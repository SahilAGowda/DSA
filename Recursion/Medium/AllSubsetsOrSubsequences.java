package Recursion.Medium;

import java.util.ArrayList;
import java.util.Collections;

public class AllSubsetsOrSubsequences {
    /*
     * Given an array arr[] of distinct positive integers, your task is to find all
     * its subsets. The subsets should be returned in lexicographical order.
     * 
     * Examples:
     * 
     * Input: arr = [1, 2, 3]
     * Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
     * Explanation:
     * The subsets of [1, 2, 3] in lexicographical order are:
     * [], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]
     * Input: arr = [1, 2]
     * Output: [[], [1], [1, 2], [2]]
     * Explanation:
     * The subsets of [1, 2] in lexicographical order are:
     * [], [1], [1, 2], [2]
     * Input: arr = [10]
     * Output: [[], [10]]
     * Explanation: For the array with a single element [10], the subsets are [ ]
     * and [10].
     * Constraints :
     * 1 ≤ arr.size() ≤ 10
     * 1 ≤ arr[i] ≤ 10
     */
    private static void subsequences(int ind, int arr[], int n, ArrayList<ArrayList<Integer>> res,
            ArrayList<Integer> ds) {
        if (ind >= n) {
            // System.out.println(ds);
            Collections.sort(ds);
            res.add(new ArrayList<>(ds));
            return;
        }
        // take the element
        ds.add(arr[ind]);
        subsequences(ind + 1, arr, n, res, ds);

        // remove the element 0
        ds.remove(ds.size() - 1);
        subsequences(ind + 1, arr, n, res, ds);
    }

    public static ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        int n = arr.length;
        // Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        subsequences(0, arr, n, res, new ArrayList<>());
        Collections.sort(res, (a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return a.size() - b.size();
        });

        return res;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        res = subsets(arr);
        System.out.println(res);
    }
}
