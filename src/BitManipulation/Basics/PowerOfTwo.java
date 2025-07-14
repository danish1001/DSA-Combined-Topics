package BitManipulation.Basics;

public class PowerOfTwo {
    public boolean isPowerOfTwo_sol1(int n) {
        if(n <= 0) return false;
        if((n & (n-1)) == 0) return true;
        return false;
    }
    public boolean isPowerOfTwo_sol2(int n) {
        if(n <= 0) return false;
        int count = 0;
        for(int i=0; i<32; i++) {
            if((n & (1 << i)) > 0) count++;
            if(count > 1) return false;
        }
        if(count == 1) return true;
        return false;
    }
}
