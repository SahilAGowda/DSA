package Arrays.Easy;

public class SecondLargest {

    // Question : Given an array of positive integers arr[], return the second
    // largest element from the array. If the second largest element doesn't exist
    // then return -1.

    // Note: The second largest element should not be equal to the largest element.

    /*
     * Examples:
     * 
     * Input: arr[] = [12, 35, 1, 10, 34, 1]
     * Output: 34
     * Explanation: The largest element of the array is 35 and the second largest
     * element is 34.
     * Input: arr[] = [10, 5, 10]
     * Output: 5
     * Explanation: The largest element of the array is 10 and the second largest
     * element is 5.
     * Input: arr[] = [10, 10, 10]
     * Output: -1
     * Explanation: The largest element of the array is 10 and the second largest
     * element does not exist.
     */

    public static int getSecondLargest(int[] arr) {

        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2 && max2 < max1 && arr[i] != max1) {
                max2 = arr[i];
            }
        }
        // System.out.println(max1+" "+max2);
        if (max2 == Integer.MIN_VALUE) {
            return -1;
        }
        return max2;
    }

    public static void main(String[] args) {
        int arr[] = { 9, 4, 6, 2, 4, 6, 21, 4, 5, 7, 21, 34, 45, 2, 1 };
        System.out.println("The Second Largest Element in the Arrays is : " + getSecondLargest(arr));
    }
}
