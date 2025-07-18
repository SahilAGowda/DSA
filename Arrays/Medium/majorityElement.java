package Arrays.Medium;

import java.util.Arrays;

public class majorityElement {
    /*
     * Given an array nums of size n, return the majority element.
     * 
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You
     * may assume that the majority element always exists in the array.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     * 
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     * 
     * 
     * Constraints:
     * 
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     */

    public static  int majorityEleme(int[] nums) {
        int majority = nums.length / 2;
        // HashMap<Integer,Integer> hm = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        // if(hm.containsKey(nums[i])){
        // hm.put(nums[i],hm.get(nums[i])+1);
        // }else{
        // hm.put(nums[i],1);
        // }
        // }
        // // System.out.println(hm);
        // for(Map.Entry<Integer,Integer>e:hm.entrySet()){
        // if(e.getValue()>majority){
        // return e.getKey();
        // }
        // }
        // return -1;

        Arrays.sort(nums);
        int num = nums[0];
        int count = 0;
        int majorityElem = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
                if (majority < count) {
                    majority = count;
                    majorityElem = nums[i];
                }
            } else {
                num = nums[i];
                count = 1;
            }
        }
        return majorityElem;
    }

    public static void main(String[] args) {
        int arr[] = {2,2,1,1,1,2,2};
        System.out.println(majorityEleme(arr));
    }
}
