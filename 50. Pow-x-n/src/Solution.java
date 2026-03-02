import static java.lang.Math.abs;

class Solution {
    public double myPow(double x, int n) {
        double result = 1.0;
        long y = abs((long) n);
        while (y >= 1) {
            if (y % 2 == 1) {
                result *= x;
            }
            x *= x;
            y /= 2;
        }
        return n < 0 ? 1 / result : result;
    }
}