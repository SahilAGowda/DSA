package Arrays.Easy;

public class RemoveduplicatesfromSortedArray {

    /*
     * Given an integer array nums sorted in non-decreasing order, remove the
     * duplicates in-place such that each unique element appears only once. The
     * relative order of the elements should be kept the same. Then return the
     * number of unique elements in nums.
     * 
     * Consider the number of unique elements of nums to be k, to get accepted, you
     * need to do the following things:
     * 
     * Change the array nums such that the first k elements of nums contain the
     * unique elements in the order they were present in nums initially. The
     * remaining elements of nums are not important as well as the size of nums.
     * Return k.
     */

    public static int removeDuplicates(int[] nums) {

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) { // we get the unique element
                nums[index + 1] = nums[i]; // assign to the next of the first element
                index++; // increment the pointer value to update the starting position
            }
        }
        return index + 1; // The point where the unique element has ended so basically count of it
    }

    public static void main(String[] args) {
        int arr[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println("The Size After removing Duplicates would be : "+removeDuplicates(arr));
    }
}
