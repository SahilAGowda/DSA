package Arrays.Hard;

import java.util.ArrayList;

public class ReversePairs {
    /*
     * Given an integer array nums, return the number of reverse pairs in the array.
     * 
     * A reverse pair is a pair (i, j) where:
     * 
     * 0 <= i < j < nums.length and
     * nums[i] > 2 * nums[j].
     * 
     * 
     * Example 1:
     * 
     * Input: nums = [1,3,2,3,1]
     * Output: 2
     * Explanation: The reverse pairs are:
     * (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
     * (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
     * Example 2:
     * 
     * Input: nums = [2,4,3,5,1]
     * Output: 3
     * Explanation: The reverse pairs are:
     * (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
     * (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
     * (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
     * 
     * 
     * Constraints:
     * 
     * 1 <= nums.length <= 5 * 104
     * -231 <= nums[i] <= 231 - 1
     */
    public static int ValidPairs(int nums[], int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > (long) 2 * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    public static int mergeSort(int nums[], int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }

        int mid = (low + high) / 2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += ValidPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }

    public static void merge(int nums[], int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = 0; i < temp.size(); i++) {
            nums[low + i] = temp.get(i);
        }
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    public static void main(String[] args) {
        int nums[]={1,3,2,3,1};
        System.out.println(reversePairs(nums));
    }
}
