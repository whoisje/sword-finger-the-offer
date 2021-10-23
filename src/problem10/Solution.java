package problem10;

/**
 * @author je
 * @Date 2021/10/21
 */
public class Solution {

    public static int count(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {//左移n位，直到超过位数
            if ((flag & n) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int betterCount(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count(0x80000000));
        System.out.println(betterCount(0x80000000));
    }
}
