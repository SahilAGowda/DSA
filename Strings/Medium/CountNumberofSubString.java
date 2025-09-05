package Medium;

public class CountNumberofSubString {
    /*
     * Given string s consisting only a,b,c. return the number of substrings
     * containing at least one occurrence of all these characters a, b, and c.
     * 
     * Example 1:
     * 
     * Input:
     * abcabc
     * Output:
     * 10
     * Explanation:
     * The required substrings are "abc", "abca", "abcab", "abcabc",
     * "bca", "bcab", "bcabc", "cab", "cabc" and "abc".
     * 
     * Example 2:
     * 
     * Input:
     * aaacb
     * Output:
     * 3
     * Your Task:
     * You don't have to read input or print anything. Your task is to complete the
     * function countSubstring() which takes the string s and returns the count of
     * substring having at least a,b,c.
     * 
     * Expected Time Complexity: O(n)
     * Expected Space Complexity: O(1)
     */
    public static boolean count(String s) {
        boolean hasA = false;
        boolean hasB = false;
        boolean hasC = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                hasA = true;
            } else if (s.charAt(i) == 'b') {
                hasB = true;
            } else if (s.charAt(i) == 'c') {
                hasC = true;
            }
        }
        return hasA && hasB && hasC;
    }

    public static int countSubstring(String s) {
        // code here
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (count(s.substring(i, j + 1))) {
                    ans += (s.length() - j);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(countSubstring(s));
    }
}
