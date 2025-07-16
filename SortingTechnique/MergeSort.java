package SortingTechnique;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void mergesort(int arr[], int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        mergesort(arr, low, mid);
        mergesort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int arr[], int low, int mid, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                res.add(arr[left]);
                left++;
            } else {
                res.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            res.add(arr[left]);
            left++;
        }
        while (right <= mid) {
            res.add(arr[right]);
            right++;
        }
        // System.out.println(res);

        // to add the in place Sorting
        for (int i = 0; i < res.size(); i++) {
            arr[low + i] = res.get(i);
        }

        
    }

    public static void main(String[] args) {
        int arr[] = { 5, 6, 32, 2, 5, 7, 42, 56, 7, 32, 1, 3, 4 };
        int n = arr.length;
        mergesort(arr, 0, n - 1);
        System.out.println("Final sorted Arrays would be " + Arrays.toString(arr));
    }
}
