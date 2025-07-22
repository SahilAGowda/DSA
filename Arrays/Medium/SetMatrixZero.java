package Arrays.Medium;

import java.util.Arrays;

public class SetMatrixZero {
    /*
     * Given an m x n integer matrix matrix, if an element is 0, set its entire row
     * and column to 0's.
     * 
     * You must do it in place.
     * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     * 
     * 
     */

    public static void markRow(int matrix[][], int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -100000;
            }
        }
    }

    public static void markCol(int matrix[][], int j) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -100000;
            }
        }
    }

    public static int[][] setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        System.out.println(m+" "+n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    markRow(matrix ,i);
                    markCol(matrix ,j);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-100000){
                    matrix[i][j]=0;
                }
            }
        }
        return matrix;
    }
     public static void main(String args[]){
        int arr[][]={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        System.out.println("Before: " + Arrays.deepToString(arr));
        arr=setZeroes(arr);
        System.out.println("After: " + Arrays.deepToString(arr));
     }}
