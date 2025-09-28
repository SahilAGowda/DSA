package Recursion.Medium;

public class countGoodNumbers {
    /*
     * A digit string is good if the digits (0-indexed) at even indices are even and
     * the digits at odd indices are prime (2, 3, 5, or 7).
     * 
     * For example, "2582" is good because the digits (2 and 8) at even positions
     * are even and the digits (5 and 2) at odd positions are prime. However, "3245"
     * is not good because 3 is at an even index but is not even.
     * Given an integer n, return the total number of good digit strings of length
     * n. Since the answer may be large, return it modulo 109 + 7.
     * 
     * A digit string is a string consisting of digits 0 through 9 that may contain
     * leading zeros.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: n = 1
     * Output: 5
     * Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
     * Example 2:
     * 
     * Input: n = 4
     * Output: 400
     * Example 3:
     * 
     * Input: n = 50
     * Output: 564908303
     * 
     * 
     * Constraints:
     * 
     * 1 <= n <= 1015
     */
    public static long power(long x, long n, long mod) {
        long ans = 1;
        long nn = n;
        if (nn < 0)
            nn = nn * -1;
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = (ans * x) % mod;
                nn = nn - 1;
            }
            x = (x * x) % mod;
            nn = nn / 2;
        }
        if (n < 0)
            return (long) 1 / ans;
        return ans;
    }

    public static int countGoodNumbers(long n) {
        long mod = (long) Math.pow(10, 9) + 7;
        long even = (n + 1) / 2;
        long odd = n / 2;
        long evenPower = power(5, even, mod);
        long oddPower = power(4, odd, mod);
        long ans = (evenPower * oddPower) % mod;
        return (int) ans;
    }
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1)); // 5
        System.out.println(countGoodNumbers(4)); // 400
        System.out.println(countGoodNumbers(50)); // 564908303
    }
}
