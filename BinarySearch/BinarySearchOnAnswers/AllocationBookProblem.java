package BinarySearch.BinarySearchOnAnswers;

class AllocationBookProblem {
    /*
     * Given an array arr[] of integers, where each element arr[i] represents the
     * number of pages in the i-th book. You also have an integer k representing the
     * number of students. The task is to allocate books to each student such that:
     * 
     * Each student receives atleast one book.
     * Each student is assigned a contiguous sequence of books.
     * No book is assigned to more than one student.
     * The objective is to minimize the maximum number of pages assigned to any
     * student. In other words, out of all possible allocations, find the
     * arrangement where the student who receives the most pages still has the
     * smallest possible maximum.
     * 
     * Note: If it is not possible to allocate books to all students, return -1.
     * 
     * Examples:
     * 
     * Input: arr[] = [12, 34, 67, 90], k = 2
     * Output: 113
     * Explanation: Allocation can be done in following ways:
     * => [12] and [34, 67, 90] Maximum Pages = 191
     * => [12, 34] and [67, 90] Maximum Pages = 157
     * => [12, 34, 67] and [90] Maximum Pages = 113.
     * The third combination has the minimum pages assigned to a student which is
     * 113.
     * Input: arr[] = [15, 17, 20], k = 5
     * Output: -1
     * Explanation: Since there are more students than total books, it's impossible
     * to allocate a book to each student.
     * Constraints:
     * 1 ≤ arr.size() ≤ 106
     * 1 ≤ arr[i], k ≤ 10
     */
    public static int Maximum(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int Summation(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int helper(int arr[], int range) {
        int page = 0, student = 1;
        for (int i = 0; i < arr.length; i++) {
            if (page + arr[i] <= range) {
                page += arr[i];
            } else {
                student++;
                page = arr[i];
            }
        }
        return student;
    }

    public static int findPages(int[] arr, int k) {
        // code here
        int low = Maximum(arr);
        int high = Summation(arr);
        int ans = -1;
        if (arr.length < k) {
            return -1;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (helper(arr, mid) <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        int nums[]={12, 34, 67, 90};
        int k =2;
        System.out.println(findPages(nums, k));
    }
}
