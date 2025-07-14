package BitManipulation.MediumProblems;

public class CountTotalBits {

    public int countSetBits(int n) {
        if(n <= 0) return 0;
        int count = countSetBits(n-1);;
        while(n > 0) {
            count += n & 1;
            n = n >> 1;
        }
//        while(n > 0) {
//            count++;
//            n = (n & (n-1));
//        }
        return count;
    }

    public int countSetBitsFrom1ToN(int n) {
        if(n == 0) return 0;
        int x = findLargestPowerOf2InRange(n);
        // x * 2 ^ (x-1);
        int bitCountTillPowerIn2Range = (x << (x-1));
        int bitCountAfterPowerIn2Range = (n - (1 << x) + 1);
        int newN = n - (1 << x);
        int bitCount = bitCountTillPowerIn2Range + bitCountAfterPowerIn2Range + countSetBitsFrom1ToN(newN);
        return bitCount;
    }

    public int findLargestPowerOf2InRange(int n) {
        int power = 0;
        while((1 << power) <= n) {
            power++;
        }
        return power-1;
    }
}
