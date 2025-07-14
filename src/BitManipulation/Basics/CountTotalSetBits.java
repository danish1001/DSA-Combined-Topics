package BitManipulation.Basics;

// count set bits from 1 to n
public class CountTotalSetBits {
    public static int countSetBits(int n) {
        if(n == 0 || n == 1) return n;

        int pow = findPowerOf2(n);
        int element = (1 << pow);

        if(n == element) {
            return 1 + (pow * element) / 2;
        }
        return (1 + (element * pow) / 2) + (n - element) + countSetBits(n-element);
    }
    private static int findPowerOf2(int n) {
        int index = 0;
        while((n >> index) != 0) {
            index++;
        }
        return index-1;
    }
}
