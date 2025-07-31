package BinarySearch.BinarySearchOnAnswers;

public class NthRootOfNumber {
    /*
     * You are given 2 numbers n and m, the task is to find n√m (nth root of m). If
     * the root is not integer then returns -1.
     * 
     * Examples :
     * 
     * Input: n = 3, m = 27
     * Output: 3
     * Explanation: 33 = 27
     * Input: n = 3, m = 9
     * Output: -1
     * Explanation: 3rd root of 9 is not integer.
     * Input: n = 4, m = 625
     * Output: 5
     * Explanation: 54 = 625
     */

    public static long power(int i, int n) {
        return (long) Math.pow(i, n);
    }

    public static int nthRoot(int n, int m) {
        // code here
        // Brute
        // int ans = -1;
        // for(int i=1;i<=m;i++){
        // if((long)power(i,n)==m){
        // ans = i;
        // }else if(power(i,n)>m){
        // break;
        // }
        // }
        // return ans;

        // OPtimal
        int low = 1;
        int high = m;
        // int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (power(mid, n) == m) {
                return mid;
            } else if (power(mid, n) > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 27;
        System.out.println(nthRoot(n, m));
    }
}
