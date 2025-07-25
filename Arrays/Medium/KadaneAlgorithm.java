package Arrays.Medium;

public class KadaneAlgorithm {
    /*
     * Given an integer array nums, find the subarray with the largest sum, and
     * return its sum.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     * Example 2:
     * 
     * Input: nums = [1]
     * Output: 1
     * Explanation: The subarray [1] has the largest sum 1.
     * Example 3:
     * 
     * Input: nums = [5,4,-1,7,8]
     * Output: 23
     * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
     * 
     */
    public static int longestSubarray(int nums[]){
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                max = Math.max(sum,max);
            }
        }
        return max;
    }

    public static int KadaneApproach(int nums[]){
        int sum=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max = Math.max(sum,max);
            if(sum<0){
                sum=0;
            }
        }
        return max;
    }

    /**
     * CORRECTED Kadane's Algorithm - Alternative approach
     * Issue in original: max = Math.max(arr[i]+max, max) is wrong
     * Should be: max = Math.max(arr[i], arr[i]+max)
     * 
     * Logic: At each position, decide whether to:
     * 1. Start a new subarray from current element (arr[i])
     * 2. Extend the previous subarray (arr[i] + max)
     */
    public static int KadaneApproach2(int arr[]){
        int max = arr[0];  // max sum ending at current position
        int res = arr[0];  // overall maximum sum
        for(int i=1;i<arr.length;i++){
            max = Math.max(arr[i], arr[i] + max);  // FIXED: arr[i] vs arr[i]+max
            res = Math.max(res, max);
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        // System.out.println(longestSubarray(arr));
        System.out.println(KadaneApproach(arr));
        System.out.println(KadaneApproach2(arr));
        
    }
}
