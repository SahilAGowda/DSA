package Arrays.Medium;

import java.util.Arrays;

public class RotateImage90 {
    /*
     * You are given an n x n 2D matrix representing an image, rotate the image by
     * 90 degrees (clockwise).
     * 
     * You have to rotate the image in-place, which means you have to modify the
     * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
     * rotation.
     * 
     * Example 1:
     * 
     * 
     * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * Output: [[7,4,1],[8,5,2],[9,6,3]]
     * Example 2:
     * 
     * 
     * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
     * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
     * 
     * 
     * Constraints:
     * 
     * n == matrix.length == matrix[i].length
     * 1 <= n <= 20
     * -1000 <= matrix[i][j] <= 1000
     */
    public static void  rotate(int[][] matrix) {
        // int ans[][] = new int[matrix.length][matrix[0].length];
        // int m = matrix.length;
        // int n = matrix[0].length;
        // for(int i=0;i<m;i++){
        // for(int j=0;j<n;j++){
        // ans[j][(n-1)-i] = matrix[i][j];
        // }
        // }

        // for(int i=0;i<m;i++){
        // for(int j=0;j<n;j++){
        // matrix[i][j] = ans[i][j];
        // }
        // }
        int m = matrix.length;
        int n = matrix[0].length;

        // Step 1 : Do the Transpose
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                // swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Step 2 : Reverse Each of the Row

        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = n - 1;
            while (low < high) {
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(arr));
        rotate(arr);
    }
}
