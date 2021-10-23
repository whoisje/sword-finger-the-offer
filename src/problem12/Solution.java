package problem12;

import java.util.Arrays;

/**
 * @author je
 * @Date 2021/10/23
 */
public class Solution {

    public static void printNum(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n can not be negative");
        }
        char[] nums = new char[n];
        Arrays.fill(nums, '0');

        while (increment(nums)) {
            print(nums);
        }
    }

    private static void print(char[] nums) {
        StringBuilder builder = new StringBuilder();
        boolean isForeZero = true;
        for (char num : nums) {
            if (num != '0') {//不打印前面的0
                isForeZero = false;
                builder.append(num);

            } else {
                if (!isForeZero)
                    builder.append(num);
            }
        }
        System.out.println(builder);
    }

    private static boolean increment(char[] nums) {
        int i;
        for (i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != '9') {
                nums[i] += 1;
                return true;//当某一位不满足进位时，直接返回。
            } else {
                if (i == 0) return false;//i==0&发生进位，说明已经达到的最大值。
                nums[i] = '0'; //进位时当前为变为0，下一个循环会给上一位+1
                // 这里时字符'0'不要写错成0了！！！！
            }
        }
        return true;
    }

    public static void main(String[] args) {
        printNum(3);
    }
}
