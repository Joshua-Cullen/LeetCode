class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long dividendPos = Math.abs((long) dividend);
        long divisorPos = Math.abs((long) divisor);

        long quotient = 0;
        while (dividendPos >= divisorPos) {
            long tempDivisor = divisorPos;
            long count = 1;

            while (dividendPos >= (tempDivisor << 1)) {
                tempDivisor <<= 1; // double divisor
                count <<= 1; // double number of multiples
            }
            dividendPos -= tempDivisor;
            quotient += count;
        }

        // convert to negative, if needed
        quotient = (isNegative) ? -quotient : quotient;

        // check quotient is valid
        long bound = 2147483648l;
        if (quotient < -bound) { 
            return (int) -bound;
        } else if (quotient > bound - 1) {
            return (int) (bound - 1);
        }

        return (int) quotient;
    }
}