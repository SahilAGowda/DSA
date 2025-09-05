package Medium;

public class maximumNestingDepthOfParanthesis {
    /*
     * Given a valid parentheses string s, return the nesting depth of s. The
     * nesting depth is the maximum number of nested parentheses.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "(1+(2*3)+((8)/4))+1"
     * 
     * Output: 3
     * 
     * Explanation:
     * 
     * Digit 8 is inside of 3 nested parentheses in the string.
     * 
     * Example 2:
     * 
     * Input: s = "(1)+((2))+(((3)))"
     * 
     * Output: 3
     * 
     * Explanation:
     * 
     * Digit 3 is inside of 3 nested parentheses in the string.
     * 
     * Example 3:
     * 
     * Input: s = "()(())((()()))"
     * 
     * Output: 3
     * 
     * 
     * 
     * Constraints:
     * 
     * 1 <= s.length <= 100
     * s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
     * It is guaranteed that parentheses expression s is a VPS.
     */
    public static int maxDepth(String s) {
        int count = 0;
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                depth = Math.max(count, depth);
            } else if (c == ')') {
                count--;
            }
        }
        return depth;
    }
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }
}
