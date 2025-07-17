package Arrays.Easy;

public class SingleNumber {
    /*
     * Given a non-empty array of integers nums, every element appears twice except
     * for one. Find that single one.
     * 
     * You must implement a solution with a linear runtime complexity and use only
     * constant extra space.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [2,2,1]
     * 
     * Output: 1
     * 
     * Example 2:
     * 
     * Input: nums = [4,1,2,1,2]
     * 
     * Output: 4
     * 
     * Example 3:
     * 
     * Input: nums = [1]
     * 
     * Output: 1
     * 
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104
     * Each element in the array appears twice except for one element which appears
     * only once.
     */

    // Explaniation :
    // The problem: In an array where every element appears twice except for one,
    // find that single one.
    // The XOR operator (^) has these properties:
    // a ^ a = 0 (any number XOR itself is 0)
    // a ^ 0 = a (any number XOR 0 is the number itself)
    // XOR is commutative and associative (order doesn't matter)
    // So, if you XOR all numbers together, pairs cancel out and only the unique
    // number remains.

    public static int singleNumber(int[] nums) {
        // if(nums.length==1)return nums[0];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        // System.out.println(Arrays.toString(nums));
        return res;
    }

    public int singleNumberWithMap(int[] nums) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1; // Should not reach here if input is valid
    }

    public static void main(String[] args) {
        int arr[] ={2,2,2,2,2,21,1,1};
        System.out.println(singleNumber(arr));
    }
}
