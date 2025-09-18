package Recursion.BasicRecursion;

public class PalindromString {
    /*
     * You are given a string s. Your task is to determine if the string is a
     * palindrome. A string is considered a palindrome if it reads the same forwards
     * and backwards.
     * 
     * Examples :
     * 
     * Input: s = "abba"
     * Output: true
     * Explanation: "abba" reads the same forwards and backwards, so it is a
     * palindrome.
     * Input: s = "abc"
     * Output: false
     * Explanation: "abc" does not read the same forwards and backwards, so it is
     * not a palindrome.
     * Constraints:
     * 1 ≤ s.size() ≤ 106
     * The string s contains only lowercase english letters (a-z).
     */
    private static boolean palindrom(String s, int low, int high) {
        if (low >= high) {
            return true;
        }
        if (s.charAt(low) != s.charAt(high))
            return false;
        return palindrom(s, low + 1, high - 1);
    }

    static boolean isPalindrome(String s) {
        // code here
        return palindrom(s, 0, s.length() - 1);
    }
    public static void main(String[] args) {
        String s = "abba";
        boolean res = isPalindrome(s);
        System.out.println(res);
    }
}
