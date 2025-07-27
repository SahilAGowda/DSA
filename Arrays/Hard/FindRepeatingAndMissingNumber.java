package Arrays.Hard;

import java.util.Arrays;;

public class FindRepeatingAndMissingNumber {
    /*
     * Problem Statement: You are given a read-only array of N integers with values
     * also in the range [1, N] both inclusive. Each integer appears exactly once
     * except A which appears twice and B which is missing. The task is to find the
     * repeating and missing numbers A and B where A repeats twice and B is missing.
     */

    public static int[] findMissingandRepeat(int nums[]) {
        int ans[] = new int[2];
        int n = nums.length;
        int hash[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }
        // System.out.println(Arrays.toString(hash));
        int repeat = -1, missing = -1;
        for (int i = 1; i <= hash.length; i++) {
            if (hash[i] == 2) {
                repeat = i;
            }
            if (hash[i] == 0) {
                missing = i;
            }
            if (repeat != -1 && missing != -1) {
                break;
            }
        }
        ans[0] = repeat;
        ans[1] = missing;
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 2, 3, 4, 6, 7 };
        System.out.println(Arrays.toString(findMissingandRepeat(nums)));
    }

}
