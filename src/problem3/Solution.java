package problem3;

/**
 * @author je
 * @Date 2021/8/15
 */

import org.junit.Assert;

/**
 * <p>
 * 从左到右，从上到下increment
 * 找到是否存在正整数
 * <p>
 * 1.分析问题<br/>
 * 1,3,5,7,9
 * 2.4,6,8,10
 * <p>
 * 取右上角的数字l[n]和target比较<br/>
 * a.如果l[n]=target 则存在<br/>
 * b.如果l[n]<target，则l[n]所在行所有元素<target，排除l[n]所在行<br/>
 * e.如果l[n]>target 则l[n]所在列所有元素>target，排除l[n]所在列<br/>
 * d.n-1重复a.b.c步骤<br/>
 * e.如果没有找到则返回不存在<br/>
 */
public class Solution {
    public static boolean findInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int d = matrix[0].length;
        int r = 0;
        int[] row = matrix[r];
        for (int i = d - 1; i >= 0; i--) {
            int e = row[i];
            if (e == target) return true;
            if (e < target) {
                if (r == matrix.length - 1) return false;
                r++;
                i = d - 1; //goto next row
                row = matrix[r];
            }
//            if (e>target)continue;
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Assert.assertTrue(Solution.findInMatrix(matrix, 7));
        Assert.assertFalse(Solution.findInMatrix(matrix, 100));

    }
}
