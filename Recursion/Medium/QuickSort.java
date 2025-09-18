package Recursion.Medium;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }
        int partIndex = partition(arr, low, high);
        quickSort(arr, low, partIndex - 1);
        quickSort(arr, partIndex + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int part = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[i] <= part && i <= high - 1) {
                i++;
            }
            while (arr[j] > part && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
    public static void main(String[] args) {
        int arr[] = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
