package Easy;

import java.util.Arrays;

public class Anagram {
    /*
     * Given two strings s and t, return true if t is an anagram of s, and false
     * otherwise.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "anagram", t = "nagaram"
     * 
     * Output: true
     * 
     * Example 2:
     * 
     * Input: s = "rat", t = "car"
     * 
     * Output: false
     * 
     * 
     * 
     * Constraints:
     * 
     * 1 <= s.length, t.length <= 5 * 104
     * s and t consist of lowercase English letters.
     * 
     * 
     * Follow up: What if the inputs contain Unicode characters? How would you adapt
     * your solution to such a case?
     */

    public static boolean isAnagram(String s, String t) {
        char c1[] = s.toCharArray();
        char c2[] = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String res1 = new String(c1);
        String res2 = new String(c2);
        return res1.equals(res2);
    }
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
