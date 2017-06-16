package com.crackbook;

/**
 * Created by Amal on 5/15/2017.
 */
public class p_8_ZeroMatrix {
    public static void main(String[] args) {

    }
    public int[][] initalizeMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j]=-1;
                }
                }
            }
            return matrix;
        }
    public int[][] zeroMatrix(int[][] matrix)
    {
        int col=-1,row=-1;
        matrix=initalizeMatrix(matrix);
        for (int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) {
                    row = i;
                    col = j;
                    break;
                }
            }
            if (col != -1 && row != -1)
                resetMatrix(row, col, matrix);
        }
        return matrix;
    }
    private int[][] resetMatrix(int row,int col,int[][] matrix)
    {
        for(int j=0;j<matrix[row].length;j++)
            matrix[row][j]=0;
        for(int i=0;i<matrix.length;i++)
            matrix[i][col]=0;
        return matrix;
    }
    }
