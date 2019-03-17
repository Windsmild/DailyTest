package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stephen Cai
 * @date 2019-03-17 18:10
 */
public class 螺旋矩阵II_59 {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return new int[][]{new int[]{1}};
        }
        int num = 1;
        int hight = n;
        int width = n;
        List<Integer> list = new ArrayList<>(width * hight);
        int[][] matrix = new int[n][n];
        int m = 0; //当前横坐标
        int k = 0; //当前纵坐标
        int max = n * n;
        while (num < max) {
            //right
            for (int i = 0; i < width - 1; i++) {
                matrix[m][k++] = num;
                num += 1;
            }
            //down
            for (int i = 0; i < hight - 1; i++) {
                matrix[m++][k] = num;
                num += 1;
            }
            //left
            for (int i = 0; i < width - 1; i++) {
                matrix[m][k--] = num;
                num += 1;
            }
            //up
            for (int i = 0; i < hight - 1; i++) {
                matrix[m--][k] = num;
                num += 1;
            }
            m++;
            k++;
            hight -= 2;
            width -= 2;
            if (num == max) {
                matrix[m][k] = max;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new 螺旋矩阵II_59().generateMatrix(4);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
