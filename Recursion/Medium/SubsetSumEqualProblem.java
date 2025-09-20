package Recursion.Medium;

import java.util.ArrayList;

public class SubsetSumEqualProblem {
    /*
     * Given an array of positive integers arr[] and a value sum, determine if there
     * is a subset of arr[] with sum equal to given sum.
     * 
     * Examples:
     * 
     * Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
     * Output: true
     * Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
     * Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
     * Output: false
     * Explanation: There is no subset with target sum 30.
     * Input: arr[] = [1, 2, 3], sum = 6
     * Output: true
     * Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
     * Constraints:
     * 1 <= arr.size() <= 200
     * 1<= arr[i] <= 200
     * 1<= sum <= 104
     */
    public static boolean findSum(int ind,int arr[],int sum,int s,ArrayList<Integer>ds){
        if(ind==arr.length){
            if(sum==s){
                return true;
            }
            return false;
        }
        if(s>sum) return false;
        ds.add(arr[ind]);
        if(findSum(ind+1,arr,sum,s+arr[ind],ds)) return true;
        ds.remove(ds.size()-1);
        return findSum(ind+1,arr,sum,s,ds);
        
        
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        return findSum(0,arr,sum,0,new ArrayList<>());
    }
    public static void main(String[] args) {
        int arr[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        System.out.println(isSubsetSum(arr, sum));
    }
}
