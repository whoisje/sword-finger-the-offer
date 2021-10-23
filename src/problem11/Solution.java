package problem11;

/**
 * @author je
 * @Date 2021/10/23
 */
public class Solution {

    public static double pow(double base, int exponent) {
        boolean isZeroBase = Double.compare(base, 0) == 0;

        if (isZeroBase && exponent < 0) {
            throw new IllegalArgumentException(String.format("illegal negative exponent %s when base is 0", exponent));
        }
        if (exponent == 0) return 1;
        if (exponent < 0) {
            int positiveExp = -exponent;
            return 1 / powWithPositiveExponentPlus(base, positiveExp);
        } else {
            return powWithPositiveExponentPlus(base, exponent);
        }
    }


    private static double powWithPositiveExponent(double base, int exponent) {
        double result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    private static double powWithPositiveExponentPlus(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double result = powWithPositiveExponentPlus(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 5));
    }

}
