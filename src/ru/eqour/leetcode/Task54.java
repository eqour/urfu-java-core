package ru.eqour.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Task54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int row = 0, rowls = matrix.length - 1;
        int col = 0, colls = matrix[0].length - 1;
        while (row <= rowls && col <= colls){
            for (int i = col; i <= colls; i++){
                ans.add(matrix[row][i]);
            }
            row++;
            for (int i = row; i <= rowls; i++){
                ans.add(matrix[i][colls]);
            }
            colls--;
            if (rowls >= row){
                for (int i = colls; i >= col; i--){
                    ans.add(matrix[rowls][i]);
                }

            }
            rowls--;
            if (col <= colls){
                for (int i = rowls; i >= row; i--){
                    ans.add(matrix[i][col]);
                }
            }
            col++;
        }
        return ans;
    }
}
