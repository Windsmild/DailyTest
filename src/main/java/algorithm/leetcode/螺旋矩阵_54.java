package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @author Stephen Cai
 * @date 2019-03-17 18:00
 */
public class 螺旋矩阵_54 {
    //这道题没什么特别的算法，就是去实现它。首先记录下矩形的宽高，然后再有对他进行循环转圈，每转完一圈将初始位置改到: [原始位置+1,原始位置+1]。
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        int hight = matrix.length;
        int width = matrix[0].length;
        List<Integer> list = new ArrayList<>(width * hight);

        int m = 0; //当前横坐标
        int n = 0; //当前纵坐标
        while (hight > 0 && width > 0) {
            if (width == 1) {
                for (int i = 0; i < hight; i++) {
                    list.add(matrix[n++][m]);
                }
                return list;
            } else if (hight == 1) {
                for (int i = 0; i < width; i++) {
                    list.add(matrix[n][m++]);
                }
                return list;
            }
            //right
            for (int i = 0; i < width - 1; i++) {
               list.add(matrix[m][n++]);
            }
            //down
            for (int i = 0; i < hight - 1; i++) {
               list.add(matrix[m++][n]);
            }
            //left
            for (int i = 0; i < width - 1; i++) {
                list.add(matrix[m][n--]);
            }
            //up
            for (int i = 0; i < hight-1; i++) {
               list.add(matrix[m--][n]) ;
            }
            m++;
            n++;
            width -= 2;
            hight -= 2;
        }
        return list;
    }
}
