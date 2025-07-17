package Arrays.Easy;
import java.util.Arrays;
/*
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Example 1:

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation: 
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]
    
 */
public class LeftRotate {
    // Approach 1 
    public static void leftRotate(int arr[],int k){
        int n = arr.length;
        int temp[] = Arrays.copyOf(arr,n);
        k = k%n;
         int index=0;
        for(int i=n-k;i<n;i++){
            temp[index++] = arr[i];
        }
        for(int i=0;i<n-k;i++){
            temp[index++] = arr[i];
        }
        for(int i=0;i<n;i++){
            arr[i] = temp[i];
        }

        System.out.println(Arrays.toString(arr));
    }



    //  Approach 2 :
    public static void reverse(int arr[],int low,int high){
        while(low<=high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }




    // Question 2 : Left Rotate an ARRAY by one place 

    public static void leftRotate1(int arr[]){
        int temp= arr[0];
        
        for(int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1] = temp;        
    }
    
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        int k=2;
        // Approach 1
        leftRotate(arr,k);

        // Approach 2 
        // int n = arr.length;
        // k=k%n;
        // // reverse(arr, 0, n-k-1);
        // // reverse(arr,  n-k,n-1);
        // // reverse(arr,0, n-1);


        // // System.out.println(Arrays.toString(arr));

    }
}
