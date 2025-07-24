package Arrays.Medium;

import java.util.ArrayList;

public class SpiralMatrix {
    /*
     * Given an m x n matrix, return all elements of the matrix in spiral order.
     * 
     * 
     * 
     * Example 1:
     * 
     * 
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     * 
     * 
     * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     * 
     * 
     * Constraints:
     * 
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     */

    /**
     * Prints the elements of a 2D matrix in spiral order and then prints the
     * original matrix.
     *
     * The spiral order starts from the top-left corner and moves right, down, left,
     * and up,
     * narrowing the boundaries after each direction until all elements are
     * traversed.
     *
     * The conditional checks:
     * - `if (top <= bot)`: Ensures that the bottom row has not already been
     * traversed after updating the top boundary.
     * - `if (left <= right)`: Ensures that the left column has not already been
     * traversed after updating the right boundary.
     *
     * These checks are necessary to avoid duplicate traversals or out-of-bounds
     * errors,
     * especially for matrices with odd dimensions or when the spiral traversal
     * meets in the center.
     *
     * @param matrix The 2D integer array to be traversed in spiral order.
     */
    public static void spiral(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bot = m - 1;
        ArrayList<Integer> res = new ArrayList<>();
        // left -> right -> down -> left -> top

        while (left <= right && top <= bot) {

            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bot; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= bot) {

                for (int i = right; i >= left; i--) {
                    res.add(matrix[bot][i]);
                }
                bot--;
            }
            if (left <= right) {

                for (int i = bot; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }

    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        spiral(matrix);
    }
}