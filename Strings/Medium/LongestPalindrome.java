package Medium;

public class LongestPalindrome {
    /*
     * Given a string s, return the longest palindromic substring in s.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     * 
     * Input: s = "cbbd"
     * Output: "bb"
     * 
     * 
     * Constraints:
     * 
     * 1 <= s.length <= 1000
     * s consist of only digits and English letters.
     */
    public static boolean checkPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        int max = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (checkPalindrome(s.substring(i, j + 1))) {
                    int len = j - i + 1;
                    if (len <= max) {
                        continue;
                    }
                    if (len > max) {
                        max = len;
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
