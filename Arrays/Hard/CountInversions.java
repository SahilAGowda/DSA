package Arrays.Hard;

import java.util.ArrayList;

public class CountInversions {
    /*
     * Given an array of integers arr[]. You have to find the Inversion Count of the
     * array.
     * Note : Inversion count is the number of pairs of elements (i, j) such that i
     * < j and arr[i] > arr[j].
     * 
     * Examples:
     * 
     * Input: arr[] = [2, 4, 1, 3, 5]
     * Output: 3
     * Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1),
     * (4, 3).
     * Input: arr[] = [2, 3, 4, 5, 6]
     * Output: 0
     * Explanation: As the sequence is already sorted so there is no inversion
     * count.
     * Input: arr[] = [10, 10, 10]
     * Output: 0
     * Explanation: As all the elements of array are same, so there is no inversion
     * count.
     * Constraints:
     * 1 ≤ arr.size() ≤ 105
     * 1 ≤ arr[i] ≤ 104
     */
    public static int mergeSort(int arr[], int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }

    public static int merge(int arr[], int low, int mid, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int count = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                res.add(arr[left]);
                left++;
            } else {
                res.add(arr[right]);
                count += (mid - left + 1);
                right++;
            }
        }
        while (left <= mid) {
            res.add(arr[left]);
            left++;
        }
        while (right <= high) {
            res.add(arr[right]);
            right++;
        }

        for (int i = 0; i < res.size(); i++) {
            arr[low + i] = res.get(i);
        }
        return count;
    }

    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int nums[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(nums));
    }
}
