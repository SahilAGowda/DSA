package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class Pascal {
    /*
     * 
     * Given an integer numRows, return the first numRows of Pascal's triangle.
     * 
     * In Pascal's triangle, each number is the sum of the two numbers directly
     * above it as shown:
     * 
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: numRows = 5
     * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * Example 2:
     * 
     * Input: numRows = 1
     * Output: [[1]]
     * 
     * 
     * Constraints:
     * 
     * 1 <= numRows <= 30
     */
    public static ArrayList<Integer> generateRow(int n) {
        int ans = 1;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(ans);
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            res.add(ans);
        }
        return res;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> a = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            a.add(generateRow(i));
        }
        return a;
    }

    public static void main(String[] args) {
        List<List<Integer>> a = generate(5);
        System.out.println(a);

    }
}
