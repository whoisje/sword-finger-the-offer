package problem14;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author je
 * @Date 2021/10/27
 */
public class Solution {

    /**
     * @param array        array need adjust
     * @param shouldAdjust whether element should adjust
     * @return array adjusted
     */
    public static int[] adjustArray(int[] array, Predicate<Integer> shouldAdjust) {
        if (array == null || array.length == 0) {
            return array;
        }
        int head = 0;
        int tail = array.length - 1;
        while (head < tail) {
            while (head < tail && !shouldAdjust.test(array[head])) {
                head++;
            }
            while (head < tail && shouldAdjust.test(array[tail])) {
                tail--;
            }
            if (head < tail) {
                int temp = array[head];
                array[head] = array[tail];
                array[tail] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        //(a) -> (a & 1) == 0 a是偶数
        int[] result = adjustArray(new int[]{1, 2, 3, 4, 5}, (a) -> (a & 1) == 0);
        System.out.println(Arrays.toString(result));
    }
}
