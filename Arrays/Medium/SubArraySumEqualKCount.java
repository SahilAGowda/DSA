package Arrays.Medium;

import java.util.HashMap;

public class SubArraySumEqualKCount {
    /*
     * Given an array of integers nums and an integer k, return the total number of
     * subarrays whose sum equals to k.
     * 
     * A subarray is a contiguous non-empty sequence of elements within an array.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,1,1], k = 2
     * Output: 2
     * Example 2:
     * 
     * Input: nums = [1,2,3], k = 3
     * Output: 2
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     */

    //  Brute
    //  public static int subArray(int arr[],int k){
    //     int count=0,sum=0;
    //     for(int i=0;i<arr.length;i++){
    //         sum=0;
    //         for(int j=i;j<arr.length;j++){
    //             sum+=arr[j];
    //             if(sum==k){
    //                 count++;
    //             }
    //         }
    //     }

    //     return count;
    //  }

    public static int subArray(int arr[],int k){
        // Prefix sum + HashMap
        int count=0,sum=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k){
                count++;
            }
            int rem = sum-k;
            if(hm.containsKey(rem)){
                count+=hm.get(rem);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }

     public static void main(String[] args) {
        int arr[] = {1,2,3};
        int k =3;
        System.out.println(subArray(arr, k));
     }
}
