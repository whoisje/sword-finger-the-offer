package problem9;

/**
 * @author je
 * @Date 2021/10/17
 */
public class Solution {
    public static long fib(long n) {
        if (n < 0) throw new IllegalArgumentException();
        if (n == 0) return 0;
        if (n == 1) return 1;
        long fn0 = 0;
        long fn1 = 1;
        for (int i = 2; i <= n; i++) {
            long tmp = fn0;
            fn0 = fn1;
            fn1 = fn1 + tmp;
        }
        return fn1;
    }

    public static void main(String[] args) {
        System.out.println(fib(20));
    }
}
