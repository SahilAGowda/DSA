package SortingTechnique;

import java.util.Arrays;

public class BubbleSort {
    // Remember Bubble Sort : Adjacent Swaps
    public static void main(String[] args) {
        int arr[] = { 12, 2, 5, 7,  8, 2,42, 1 };
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) { // Adjacent Comparision
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
