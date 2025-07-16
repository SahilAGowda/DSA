package SortingTechnique;

import java.util.Arrays;

public class SelectionSort {
    // Key point to remember -> We should take the minimum element indexes at swap it 
    public static void main(String[] args) {
        int arr[] = {1,7,8,4,2,1,3,2};
        int n = arr.length;
        for(int i=0;i<n;i++){
            int min = i;
            for(int j=i;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
