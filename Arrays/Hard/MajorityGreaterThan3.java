package Arrays.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MajorityGreaterThan3 {
    /*
     * Given an integer array of size n, find all elements that appear more than ⌊
     * n/3 ⌋ times.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [3,2,3]
     * Output: [3]
     * Example 2:
     * 
     * Input: nums = [1]
     * Output: [1]
     * Example 3:
     * 
     * Input: nums = [1,2]
     * Output: [1,2]
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 5 * 104
     * -109 <= nums[i] <= 109
     * 
     * 
     * Follow up: Could you solve the problem in linear time and in O(1) space?
     * 
     */

    // Brute Apporach
    public static ArrayList<Integer> Majority(int nums[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int major = nums.length / 3;
        for (int i = 0; i < nums.length; i++) {
            if (res.size() == 0 || res.get(0) != nums[i]) {
                int count = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == nums[i]) {
                        count++;
                    }
                }
                if (count > major) {
                    res.add(nums[i]);
                }
            }
            if (res.size() == 2)
                break;
        }

        return res;
    }

    // Better Solution

    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> res = new ArrayList<>();
            HashMap<Integer, Integer> hm = new HashMap<>();
            HashSet<Integer> hs = new HashSet<>();
            if (nums.length <= 2) {
                for (int i = 0; i < nums.length; i++) {
                    hs.add(nums[i]);
                }
                for (int s : hs) {
                    res.add(s);
                }
                return res;
            }
            int major = nums.length / 3;

            for (int i = 0; i < nums.length; i++) {
                if (hm.containsKey(nums[i])) {
                    hm.put(nums[i], hm.get(nums[i]) + 1);
                } else {
                    hm.put(nums[i], 1);
                }
            }

            for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
                if (e.getValue() > major) {
                    res.add(e.getKey());
                }
            }
            // System.out.println(hm);
            return res;

        }
    }

    // Better Approach
    public static List<Integer> majorityElement1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        if (nums.length <= 2) {
            for (int i = 0; i < nums.length; i++) {
                hs.add(nums[i]);
            }
            for (int s : hs) {
                res.add(s);
            }
            return res;
        }
        int major = nums.length / 3;

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            if (e.getValue() > major) {
                res.add(e.getKey());
            }
        }
        // System.out.println(hm);
        return res;

    }

    // Optimal Approach
    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int elem1 = Integer.MIN_VALUE, elem2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != elem2) {
                count1 = 1;
                elem1 = nums[i];
            } else if (count2 == 0 && nums[i] != elem1) {
                count2 = 1;
                elem2 = nums[i];
            } else if (elem1 == nums[i]) {
                count1++;
            } else if (elem2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == elem1)
                count1++;
            if (nums[i] == elem2)
                count2++;
        }
        int major = nums.length / 3;
        if (count1 > major) {
            res.add(elem1);
        }
        if (count2 > major) {
            res.add(elem2);
        }
        return res;

    }

    public static void main(String[] args) {
        int nums[] = {3,2,3};
        System.out.println(Majority(nums));
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement1(nums));
    }
}
