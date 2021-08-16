package problem4;

/**
 * @author je
 * @Date 2021/8/15
 */

import org.junit.Assert;

/**
 * 在原来字符串的基础上，替换所有的空格为%20，时间复杂度O(n)，字符串有足够的空余空间
 * <p>
 * <p>
 * 分析：
 * 每个空格替换为%20需要额外的两个字符空间
 * 每次替换需要移动后面的所有元素两个位置
 * 后面的元素很多被重复移动了，时间复杂度为O(n^2)，因此，可以从后向前替换
 * 先计算需要替换的空格数，每个元素只会被移动一次
 * <p>
 * for example: "I am Chinese ____________" _代表空闲空间
 * 1. 计算"I am Chinese ____________"中的非空闲空间的长度length和空格个数blankCount
 * 2. 用headIndex记录当前从后往前插入的index
 * 3. 遍历[length-1～0]，遇到非空格字符，插入到[headIndex-1]下标处
 * 4. 遇到空格插入%20到[headIndex-3][headIndex-2][headIndex-1]处
 */
public class Solution {

    public static StringBuilder replaceBlank(StringBuilder input) {
        if (input == null || "".equals(input.toString())) return input;
        int blankCount = 0;
        int length = 0;
        //从后往前，从第一个非空格字符开始计数，用_代替无用空间
        for (int i = 0; i <= input.length() - 1; i++) {
            if (' ' == input.charAt(i)) {
                blankCount++;
            }
            if ('_' != input.charAt(i)) length++;
        }
        int headIndex = length + blankCount * 2;
        for (int i = length - 1; i >= 0; i--) {
            if (' ' == input.charAt(i)) {
                insertCurrentPos(input, headIndex - 1, '0');
                insertCurrentPos(input, headIndex - 2, '2');
                insertCurrentPos(input, headIndex - 3, '%');
                headIndex = headIndex - 3;
            } else {
                insertCurrentPos(input, headIndex - 1, input.charAt(i));
                headIndex--;
            }
        }
        return input;
    }

    public static void insertCurrentPos(StringBuilder input, int index, char c) {
        input.deleteCharAt(index);
        input.insert(index, c);
    }

    public static void main(String[] args) {
        Assert.assertEquals(Solution.replaceBlank(new StringBuilder("I am Chinese ____________")).toString(), "I%20am%20Chinese%20______");
        Assert.assertEquals(Solution.replaceBlank(new StringBuilder("")).toString(), "");
        Assert.assertNull(Solution.replaceBlank(null));
        Assert.assertEquals(Solution.replaceBlank(new StringBuilder("  ____________")).toString(), "%20%20________");
        Assert.assertEquals(Solution.replaceBlank(new StringBuilder("____________")).toString(), "____________");
    }
}
