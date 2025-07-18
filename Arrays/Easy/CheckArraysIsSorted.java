package Arrays.Easy;

public class CheckArraysIsSorted {

    /*
     * Questions :
     * Given an array nums, return true if the array was originally sorted in
     * non-decreasing order, then rotated some number of positions (including zero).
     * Otherwise, return false.
     * 
     * There may be duplicates in the original array.
     * 
     * Note: An array A rotated by x positions results in an array B of the same
     * length such that B[i] == A[(i+x) % A.length] for every valid index i.
     * 
     * 
     * Examples
     * Input: nums = [3,4,5,1,2]
     * Output: true
     * Explanation: [1,2,3,4,5] is the original sorted array.
     * You can rotate the array by x = 3 positions to begin on the element of value
     * 3: [3,4,5,1,2].
     * Example 2:
     * 
     * Input: nums = [2,1,3,4]
     * Output: false
     * Explanation: There is no sorted array once rotated that can make nums.
     * Example 3:
     * 
     * Input: nums = [1,2,3]
     * Output: true
     * Explanation: [1,2,3] is the original sorted array.
     * You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
     * 
     */


    //  Approach 1 :
    public static boolean check(int[] nums) {
        int culprit = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                culprit++;
            }
        }
        if (nums[0] < nums[nums.length - 1]) {
            culprit++;
        }
        return culprit <= 1;
    }


    // Approach 2 :
    // public boolean check(int[] nums) {
    //     int count = 0, n = nums.length;
        
    //     for (int i = 0; i < n; i++) {
    //         if (nums[i] > nums[(i + 1) % n]) //comparing the last element use mod operator
    //             count++;
    //         if (count > 1) 
    //             return false;
    //     }
        
    //     return true;
    // }

    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        if(check(arr)){
            System.out.println("Arrays is Sorted");
        }else{
            System.out.println("The Array is not Sorted");
        }
    }
}
