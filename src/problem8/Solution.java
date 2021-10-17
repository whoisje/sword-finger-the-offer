package problem8;

/**
 * @author je
 * @Date 2021/10/17
 */
public class Solution {

    public static int searchMinInReverseArray(int[] reverseArray) {
        if (reverseArray.length == 0) {
            throw new IllegalArgumentException("require not empty array");
        }
        int start = 0;
        int end = reverseArray.length - 1;
        if (reverseArray[start] < reverseArray[end]) {//特殊情况1，把数组开始的0个元素搬到数组末尾，旋转数组就是原数组，此时最小为第一个元素，判断第一个元素是否小于最后一个即可。
            return reverseArray[start];
        }

        do {
            int middleIndex = (start + end) / 2;

            int middle = reverseArray[middleIndex];
            if (reverseArray[start] == middle && reverseArray[end] == middle) {//当middle start end相等时无法判断指针如何移动，因此遍历找最小值
                for (int i = 1; i < reverseArray.length; i++) {
                    if (reverseArray[i] - reverseArray[i - 1] < 0) {
                        return reverseArray[i];
                    }
                }
            }
            if (reverseArray[start] <= middle) {
                start = middleIndex;
            } else if (reverseArray[start] >= middle) {
                end = middleIndex;
            }

        } while (start != end - 1);
        return reverseArray[end];
    }


    public static void main(String[] args) {
        System.out.println(searchMinInReverseArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(searchMinInReverseArray(new int[]{1, 2, 3, 4, 5}));
        System.out.println(searchMinInReverseArray(new int[]{1, 1, 1, 0, 1}));
        System.out.println(searchMinInReverseArray(new int[]{1, 1, 1, 1, 1}));
    }
}
