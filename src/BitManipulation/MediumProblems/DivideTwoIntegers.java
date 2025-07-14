package BitManipulation.MediumProblems;

public class DivideTwoIntegers {
//    Question:
//    Given two integers dividend and divisor, divide two integers without
//    using multiplication, division, and mod operator.
//    The integer division should truncate toward zero, which means losing its fractional part.
//    For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
//    Return the quotient after dividing dividend by divisor.
//    Note: Assume we are dealing with an environment that could only store integers
//    within the 32-bit signed integer range: [−231, 231 − 1].
//    For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1,
//    and if the quotient is strictly less than -231, then return -231.

    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;

        boolean sign = true; // +ve
        if(dividend <= 0 && divisor > 0) sign = false; // -ve
        else if(dividend >= 0 && divisor < 0) sign = false; // -ve;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;

        while(n >= d) {
            int bitIndex = 0;
            // divisor * 2 ^ (bitIndex+1) as divisor << (bitIndex + 1)
            while(n >= (d << (bitIndex + 1))) {
                bitIndex++;
            }
            quotient += ((long) 1 << bitIndex);
            n -= (d << bitIndex);
        }

        if(quotient >= ((long) 1 << 31) && sign) return Integer.MAX_VALUE;
        if(quotient >= ((long) 1 << 31) && !sign) return Integer.MIN_VALUE;

        return (int) (sign ? quotient : -quotient);
    }
}
