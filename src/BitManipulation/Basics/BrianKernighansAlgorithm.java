package BitManipulation.Basics;

public class BrianKernighansAlgorithm {
    // Algorithm to count the number of set bits in number n
    public int countSetBits(int n) {
        int count = 0;
        while(n != 0) {
            n = (n & (n-1));
            count++;
        }
        return count;
    }
}
